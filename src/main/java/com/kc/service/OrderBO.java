package com.kc.service;

import com.kc.dto.Order;
import com.kc.exception.OrderException;

public interface OrderBO {
    int placeOrder(Order order) throws OrderException;

    int cancelOrder(int orderId) throws OrderException;

    int deleteOrder(int orderId) throws OrderException;

}
