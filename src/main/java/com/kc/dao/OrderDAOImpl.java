package com.kc.dao;

import com.kc.dto.Order;
import com.kc.service.OrderBOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class OrderDAOImpl implements OrderDAO {
    private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

    public int create(Order order) throws SQLException {
        logger.info("In DAO Inserted record for order id: {}", order.getId());
        logger.debug("Debugging...In DAO Inserted record for order id: {}", order.getId());
        return 0;
    }

    public Order read(int orderId) throws SQLException {
        return null;
    }

    public int update(Order order) {
        return 0;
    }

    public int delete(int orderId) {
        return 0;
    }
}
