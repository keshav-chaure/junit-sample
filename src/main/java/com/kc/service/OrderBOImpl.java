package com.kc.service;


import com.kc.dao.OrderDAO;
import com.kc.dao.OrderDAOImpl;
import com.kc.dto.Order;
import com.kc.exception.OrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = new OrderDAOImpl();
    //private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(OrderBOImpl.class);

    public int placeOrder(Order order) throws OrderException {
        int orderId = 0;
        logger.info("order placed for order id: {}", orderId);
        logger.debug("Debugging...");
        try {
            orderId = orderDAO.create(order);
        } catch (SQLException sqle) {
            throw new OrderException(sqle);
        }
        logger.info("order placed for order id: {}", orderId);
        logger.debug("Debugging...");

        return orderId;
    }

    public int cancelOrder(int orderId) throws OrderException {
        int canceledOrderId = 0;
        try {
            canceledOrderId = orderDAO.delete(orderId);
        } catch (SQLException sqle) {
            throw new OrderException(sqle);
        }
        return canceledOrderId;
    }

    public int deleteOrder(int orderId) throws OrderException {
        int deleteOrder = 0;
        try {
            deleteOrder = orderDAO.delete(orderId);
        } catch (SQLException sqle) {
            throw new OrderException(sqle);
        }
        return deleteOrder;
    }


}
