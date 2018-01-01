package com.kc.service;

import com.kc.dao.OrderDAO;
import com.kc.dto.Order;
import com.kc.exception.OrderException;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO;


    public int placeOrder(Order order) throws OrderException {
        int orderId = 0;
        try {
            orderId = orderDAO.create(order);
        } catch (SQLException sqle) {
            throw new OrderException(sqle);
        }
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
