package com.pay.pojo;

import java.io.Serializable;
import java.util.List;

public class orderList implements Serializable{

    private List<Goods> goods;
    private List<TbOrder> order;
    private List<Orders> orderItem;
    private List bb;

    public List getBb() {
        return bb;
    }

    public void setBb(List bb) {
        this.bb = bb;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<TbOrder> getOrder() {
        return order;
    }

    public void setOrder(List<TbOrder> order) {
        this.order = order;
    }

    public List<Orders> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<Orders> orderItem) {
        this.orderItem = orderItem;
    }

    public orderList() {
    }

    public orderList(List<Goods> goods, List<TbOrder> order, List<Orders> orderItem, List bb) {
        this.goods = goods;
        this.order = order;
        this.orderItem = orderItem;
        this.bb = bb;
    }
}
