package com.kc;

import com.kc.dto.Order;
import com.kc.exception.OrderException;
import com.kc.service.OrderBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyXMLApplicationClient {
    private static final Logger logger = LoggerFactory.getLogger(MyXMLApplicationClient.class);


    @Autowired
    private OrderBO orderBO;

    public void processRequests() throws OrderException {
        logger.info("In Client Application..");
        logger.debug("In Client Application..");

        placeOrder();

    }

    private void placeOrder() throws OrderException {

        System.out.println("in process "+orderBO);
        Order order=new Order(1,0);
        logger.info("In Client placeing order..{}",order.getId());
        logger.debug("In Client placeing order..{}",order.getId());
        this.orderBO.placeOrder(order);

    }

}