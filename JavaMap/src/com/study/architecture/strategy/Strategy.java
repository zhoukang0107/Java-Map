package com.study.architecture.strategy;

/**
 * 抽象策略角色
 *
 */
public interface Strategy {
    /**
     * @param price  调用层传递的原价
     * @return  返回的折扣价格
     */
    public double strategyInterface(double price);
}
