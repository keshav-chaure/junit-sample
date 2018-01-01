package com.kc.exception;

import java.sql.SQLException;

public class OrderException extends Exception {
    public OrderException(SQLException message) {
        super(message);
    }
}
