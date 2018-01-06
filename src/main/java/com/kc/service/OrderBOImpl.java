package com.kc.service;


import com.kc.dao.OrderDAO;
import com.kc.dto.Order;
import com.kc.exception.OrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//Lighthouse.jpg https://s3.ap-south-1.amazonaws.com/kc-s3bucket123/Lighthouse.jpg
import java.sql.SQLException;

@Component
public class OrderBOImpl implements OrderBO {

    @Autowired
    OrderDAO orderDAO;
    //private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(OrderBOImpl.class);

    public int placeOrder(Order order) throws OrderException {
        int orderId = 0;
        logger.info("In BO order placed for order id: {}", orderId);
        logger.debug("Debugging...In BO order placed for order id: {}", orderId);
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
        /*try {
            deleteOrder = orderDAO.delete(orderId);
        } catch (SQLException sqle) {
            throw new OrderException(sqle);
        }*/
        return deleteOrder;
    }


}
