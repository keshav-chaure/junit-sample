package com.kc;

import com.kc.dto.Order;
import com.kc.exception.OrderException;
import com.kc.service.OrderBO;

public class MyXMLApplication {

    private OrderBO orderBO;

    public OrderBO getOrderBO() {
        return orderBO;
    }



    public void setOrderBO(OrderBO orderBO) {
        this.orderBO = orderBO;
    }

    //private MessageService service;

    //constructor-based dependency injection
//	public MyXMLApplication(MessageService svc) {
//		this.service = svc;
//	}

    //setter-based dependency injection
//    public void setService(MessageService svc) {
//        this.service = svc;
//    }

    public void processMessage() throws OrderException {
        // some magic like validation, logging etc
        System.out.println("in process "+orderBO);
        Order order=new Order(1,0);
        this.orderBO.placeOrder(order);
    }

}