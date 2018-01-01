package com.kc.dao;

import com.kc.dto.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    int create(Order order)throws SQLException;
    Order read(int orderId)throws SQLException;
    int update(Order order)throws SQLException;
    int delete(int orderId)throws SQLException;
}
