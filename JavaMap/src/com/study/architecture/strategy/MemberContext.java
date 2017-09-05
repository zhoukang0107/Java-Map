package com.study.architecture.strategy;

/**
 * 策略模式上下午
 */
public class MemberContext {
    private Strategy strategy;

    public MemberContext(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 计算打折之后的价格
     * @param price
     * @return
     */
    public double caculetor(double price){
        return strategy.strategyInterface(price);
    }
}
