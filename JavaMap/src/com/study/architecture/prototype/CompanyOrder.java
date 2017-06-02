package com.study.architecture.prototype;

import java.util.ArrayList;

/**
 * Created by Zack on 2017/6/2.
 */
public class CompanyOrder implements IOrder {
    private String orderName;
    private int orderNumber;
    private ArrayList<String>  list;//深拷贝
    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;

    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public Prototype clonePrototype() {
        CompanyOrder order = new CompanyOrder();
        order.setOrderNumber(orderNumber);
        order.setOrderName(orderName);
        order.list = new ArrayList<>();//深拷贝
        return order;
    }
}
