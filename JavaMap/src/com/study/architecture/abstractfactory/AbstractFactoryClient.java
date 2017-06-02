package com.study.architecture.abstractfactory;

/**
 * 抽象工厂模式
 * 每一个工厂只生产一种产品
 *
 * d调用方与构建过程分离
 */
public class AbstractFactoryClient {
    public static void main(String[] args) {
        IFactory factory = new AndroidFactory();
        factory.create().show();
    }
}
