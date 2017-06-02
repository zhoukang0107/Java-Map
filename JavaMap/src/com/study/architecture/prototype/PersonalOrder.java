package com.study.architecture.prototype;

/**
 * Created by Zack on 2017/6/2.
 */
public class PersonalOrder implements IOrder {
    private String orderName;
    private int orderNumber;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public Prototype clonePrototype() {
        PersonalOrder order = new PersonalOrder();
        order.setOrderNumber(orderNumber);
        order.setOrderName(orderName);
        return order;
    }
}
