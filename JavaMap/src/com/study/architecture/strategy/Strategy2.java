package com.study.architecture.strategy;

public class Strategy2 implements Strategy {
    @Override
    public double strategyInterface(double price) {
        //返回中级会员打折后的价格
        return price*0.9;
    }
}
