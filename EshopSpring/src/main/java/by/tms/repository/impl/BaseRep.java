package by.tms.repository.impl;

import by.tms.repository.ConnectionPool;
import org.springframework.stereotype.Repository;

@Repository
public class BaseRep {

        ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

}
