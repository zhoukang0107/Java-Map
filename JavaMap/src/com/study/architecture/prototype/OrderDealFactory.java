package com.study.architecture.prototype;

/**
 *
 */
public class OrderDealFactory {
    public void dealOrder(IOrder order){
        int number = order.getOrderNumber();
        while (number>0){
        /*
          不使用原型模式
          if (order instanceof PersonalOrder){
                //生产个人订单
                System.out.println("订单编号："+order.hashCode());
            IOrder iOrder = null;
            PersonalOrder personalOrder = (PersonalOrder) order;
            PersonalOrder newOrder = new PersonalOrder();
            newOrder.setOrderName(personalOrder.getOrderName());
            newOrder.setOrderNumber(number>=1000?1000:number);
            iOrder = personalOrder;
            System.out.println("newOrder:"+newOrder.getOrderName()+"  number:"+newOrder.getOrderNumber()+"  order:"+newOrder);
            number -= 1000;
            }else if (order instanceof CompanyOrder){
                //生产公司订单
            }


         */
            System.out.println("订单编号："+order.hashCode());
            IOrder iOrder = (IOrder) order.clonePrototype();
            iOrder.setOrderNumber(number>=1000?1000:number);
            number -= 1000;
            System.out.println("number:"+iOrder.getOrderNumber()+"  order:"+iOrder);
        }
    }
}
