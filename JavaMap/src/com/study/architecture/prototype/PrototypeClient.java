package com.study.architecture.prototype;

/**
 * 原型模式：
 * 用原型的实例指定创建的种类，并通过拷贝这些原型创建新的对象(克隆)
 * 目的：保护最原始的那一份存档，隐藏复制过程
 */
public class PrototypeClient {
    public static void main(String[] args){

        OrderDealFactory factory = new OrderDealFactory();
        PersonalOrder order = new PersonalOrder();
        order.setOrderName("产品");
        order.setOrderNumber(3200);
        factory.dealOrder(order);
    }
}
