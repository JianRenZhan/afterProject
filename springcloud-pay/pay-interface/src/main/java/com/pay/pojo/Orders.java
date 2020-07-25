package com.pay.pojo;

import java.io.Serializable;

public class Orders implements Serializable{
    private TbOrder orders;
    private TbOrderItem orderItem;

    public TbOrder getOrders() {
        return orders;
    }

    public void setOrders(TbOrder orders) {
        this.orders = orders;
    }

    public TbOrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(TbOrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Orders() {
    }

    public Orders(TbOrder orders, TbOrderItem orderItem) {
        this.orders = orders;
        this.orderItem = orderItem;
    }
}
