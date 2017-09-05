package com.study.architecture.abstractfactory;

/**
 * 抽象工厂模式
 * 每一个工厂只生产一种产品
 *
 * 调用方与构建过程分离
 *
 *
 * 简单工厂模式使用产品比较单一的场景，抽象工厂模式补足这一点
 *
 */
public class AbstractFactoryClient {
    public static void main(String[] args) {
        IFactory factory = new AndroidFactory();
        factory.create().show();
    }
}
