package com.study.architecture.prototype;

/**
 * 原型模式：
 * 用原型的实例指定创建的种类，并通过拷贝这些原型创建新的对象(克隆)
 * 目的：保护最原始的那一份存档，隐藏复制过程
 *
 *
 * 需求：客户产生一个订单，订单有产品的数量，产品的名称。公司接收订单，并进入内部处理系统
 * 进入后需要保留最原始的一份数据作为存根，进入生产部门后，每个部门只能在一个订单生产最多1000
 * 个产品，开始根据订单生产产品
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
