//package by.tms.repository.util;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//
////@AllArgsConstructor
//@Repository
//@RequiredArgsConstructor
//public class ConnectionWrapper implements AutoCloseable {
//
//    private final ConnectionPool connectionPool;
//
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