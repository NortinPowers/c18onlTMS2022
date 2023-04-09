//package by.tms.repository;
//
//import java.sql.Connection;
//import lombok.AllArgsConstructor;
//
//@AllArgsConstructor
//public class ConnectionWrapper implements AutoCloseable {
//
//    private final ConnectionPool connectionPool;
//    private final Connection connection;
//
//    @Override
//    public void close() throws Exception {
//        connectionPool.closeConnection(this);
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//}