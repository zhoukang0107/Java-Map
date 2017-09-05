package com.study.architecture.strategy;

/**
 * 策略模式：
 * 策略模式定义了一系列的算法，并将每个算法封装起来，而且使他们之间可以相互替换，
 * 策略模式让算法独立于使他的客户独立而变化
 *
 * 角色：环境角色(Context):持有一个Strategy引用
 * 抽象策略角色：这是一个抽象角色，通常由一个接口或者抽象类实现，此角色给出所有的具体策略所需要的接口
 * 具体策略角色：包装了相关算法或行为
 *
 * 需求：
 * 假设有一个商店搞活动，对所有高级会员打20%折扣，对所有中级会员打10%的促销折扣，
 * 对初级会员没有折扣；
 * 算法一：对初级会员不打折
 * 算法二：对中级会员提供10%折扣
 * 算法三：对高级会员打20%折扣
 *
 *
 *
 *
 *
 *
 *
 */
public class StrategyClient {

    public static void main(String[] args){
        //策略在客户端实例化的
        Strategy strategy1 = new Strategy1();
        MemberContext context = new MemberContext(strategy1);
        System.out.println("计算出的价格："+context.caculetor(100));
    }
}
