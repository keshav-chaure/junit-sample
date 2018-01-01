package com.kc.dto;

public class Order {
    int id;
    int status;

    public Order() {
    }
    //status : 1=order placed, 0=not placed
    public Order(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
