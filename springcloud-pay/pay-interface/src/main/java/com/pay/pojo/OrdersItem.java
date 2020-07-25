package com.pay.pojo;

import java.io.Serializable;
import java.util.List;

public class OrdersItem implements Serializable{
    private List<TbOrder> order;
    private List<TbOrderItem> orderItem;

    public List<TbOrder> getOrder() {
        return order;
    }

    public void setOrder(List<TbOrder> order) {
        this.order = order;
    }

    public List<TbOrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<TbOrderItem> orderItem) {
        this.orderItem = orderItem;
    }
}
