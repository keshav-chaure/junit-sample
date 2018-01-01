package com.kc.service;

import com.kc.dao.OrderDAO;
import com.kc.dao.OrderDAOImpl;
import com.kc.dto.Order;
import com.kc.exception.OrderException;
import com.kc.exception.PlaceOrderException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class OrderBOImplTest {

    private static final int ANY_ORDER_ID =123;
    @InjectMocks
    OrderBO orderBO = new OrderBOImpl();

    @Mock
    OrderDAO orderDAO = new OrderDAOImpl();


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        System.out.println("setup");
    }

    @After
    public void teardown() {
        System.out.println("teardown");
    }

    @Test
    public void placeOrderShouldReturnOrderId() throws OrderException, SQLException {
        Order order = new Order();
        when(orderDAO.create(order)).thenReturn(ANY_ORDER_ID);

        int orderId = orderBO.placeOrder(order);

        verify(orderDAO).create(order);
        assertEquals(orderId, ANY_ORDER_ID);

    }

    @Test
    public void placeOrderShouldNotReturnOrderId() throws OrderException, SQLException {
        Order order = new Order();
        when(orderDAO.create(order)).thenReturn(0);

        int orderId = orderBO.placeOrder(order);

        verify(orderDAO).create(order);
        assertNotEquals(orderId, ANY_ORDER_ID);

    }

    @Test(expected = OrderException.class)
    public void placeOrderShouldReturnException() throws SQLException, OrderException {
        Order order = new Order();
       when(orderDAO.create(order)).thenThrow(SQLException.class);
        int orderId=orderBO.placeOrder(order);

    }


    @Test
    public void cancelOrderShouldCancelOrder() throws OrderException, SQLException {
        int orderId=123;
        when(orderDAO.delete(orderId)).thenReturn(ANY_ORDER_ID);

        int actualOrderId = orderBO.cancelOrder(orderId);

        verify(orderDAO).delete(anyInt());
        assertEquals(actualOrderId, ANY_ORDER_ID);

    }

    @Test
    public void cancelOrderShouldNotCancelOrder() throws OrderException, SQLException {
        int orderId=123;
        when(orderDAO.delete(orderId)).thenReturn(0);

        int actualOrderId = orderBO.cancelOrder(orderId);

        verify(orderDAO).delete(anyInt());
        assertNotEquals(actualOrderId, ANY_ORDER_ID);

    }

    @Test(expected = OrderException.class)
    public void cancelOrderShouldReturnException() throws SQLException, OrderException {
        int orderId = 112;
        when(orderDAO.delete(orderId)).thenThrow(SQLException.class);
        int actualOrderId = orderBO.cancelOrder(orderId);
    }

    @Test
    public void deleteOrderShouldCancelOrder() throws OrderException, SQLException {
        int orderId=123;
        when(orderDAO.delete(orderId)).thenReturn(ANY_ORDER_ID);

        int actualOrderId = orderBO.deleteOrder(orderId);

        verify(orderDAO).delete(anyInt());
        assertEquals(actualOrderId, ANY_ORDER_ID);

    }

    @Test
    public void deleteOrderShouldNotCancelOrder() throws OrderException, SQLException {
        int orderId=123;
        when(orderDAO.delete(orderId)).thenReturn(0);

        int actualOrderId = orderBO.deleteOrder(orderId);

        verify(orderDAO).delete(anyInt());
        assertNotEquals(actualOrderId, ANY_ORDER_ID);

    }

    @Test(expected = OrderException.class)
    public void deleteOrderShouldReturnException() throws SQLException, OrderException {
        int orderId=112;
        when(orderDAO.delete(orderId)).thenThrow(SQLException.class);
        int actualOrderId=orderBO.deleteOrder(orderId);

    }
}