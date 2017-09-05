package com.study.architecture.strategy;

public class Strategy1 implements Strategy {
    @Override
    public double strategyInterface(double price) {
        //返回高级会员打折后的价格
        return price*0.8;
    }
}
