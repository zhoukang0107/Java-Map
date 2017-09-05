package com.study.architecture.strategy;

public class Strategy3 implements Strategy {
    @Override
    public double strategyInterface(double price) {
        //返回初级会员打折后的价格
        System.out.println("初级会员没有折扣");
        return price;
    }
}
