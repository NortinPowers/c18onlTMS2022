package by.tms.repository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionPool {

    private static volatile ConnectionPool instance;

    private static final String DB_PROPERTY_FILE = "application";
    private static final String DB_URL = "db.url";
    private static final String DB_LOGIN = "db.login";
    private static final String DB_PASS = "db.pass";
    private static final String DB_DRIVER = "db_driver";
    private static final int MAX_CONNECTION_COUNT = 20;
    private static final int MIN_CONNECTION_COUNT = 10;

    private static final String URL;
    private static final String LOGIN;
    private static final String PASS;
    private static final String DRIVER;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_PROPERTY_FILE);
        URL = resourceBundle.getString(DB_URL);
        LOGIN = resourceBundle.getString(DB_LOGIN);
        PASS = resourceBundle.getString(DB_PASS);
        DRIVER = resourceBundle.getString(DB_DRIVER);
    }

    private final AtomicInteger currentConnectionNumber = new AtomicInteger(MIN_CONNECTION_COUNT);
    private final BlockingQueue<ConnectionWrapper> pool = new ArrayBlockingQueue<>(MAX_CONNECTION_COUNT, true);

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    private ConnectionPool() {
        for (int i = 0; i < MIN_CONNECTION_COUNT; i++) {
            try {
                Class.forName(DRIVER);
                pool.add(new ConnectionWrapper(this, DriverManager.getConnection(URL, LOGIN, PASS)));
            } catch (Exception e) {
                log.error("SQLException ConnectionPool(): ", e);
            }
        }
    }

    private void openAdditionalConnection() throws Exception {
        try {
            Class.forName(DRIVER);
            pool.add(new ConnectionWrapper(this, DriverManager.getConnection(URL, LOGIN, PASS)));
            currentConnectionNumber.incrementAndGet();
        } catch (SQLException e) {
            throw new Exception("New connection wasn't add in the connection pool", e);
        }
    }

    public ConnectionWrapper getConnectionWrapper() throws Exception {
        ConnectionWrapper connectionWrapper;
        try {
            if (pool.isEmpty() && currentConnectionNumber.get() < MAX_CONNECTION_COUNT) {
                openAdditionalConnection();
            }
            connectionWrapper = pool.take();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new Exception("Max count of connections was reached!");
        }
        return connectionWrapper;
    }

    public void closeConnection(ConnectionWrapper connectionWrapper) throws Exception {
        if (connectionWrapper != null) {
            if (currentConnectionNumber.get() > MIN_CONNECTION_COUNT) {
                currentConnectionNumber.decrementAndGet();
            }
            try {
                pool.put(connectionWrapper);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new Exception("Connection wasn't returned into pool properly");
            }
        }
    }

    public void closeAllConnection() {
        for (ConnectionWrapper connectionWrapper : pool) {
            try {
                if (connectionWrapper != null) {
                    connectionWrapper.getConnection().close();
                }
            } catch (Exception e) {
                log.error("Some connection cannot be closed: ", e);
            }
        }
    }
}