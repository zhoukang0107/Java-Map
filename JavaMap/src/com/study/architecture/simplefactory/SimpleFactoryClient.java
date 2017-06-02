package com.study.architecture.simplefactory;

import com.study.architecture.simplefactory.Api;
import com.study.architecture.simplefactory.Factory;
//
// import com.study.architecture.simplefactory.ImplB;

/**
 * 场景：创建对象
 * 简单工厂模式：提供创建对象的功能，不需要关心具体的实现
 * 好处：降低客户端与模块之间的耦合度(最少知识原则)
 *
 *
 *
 *
 * 最少知识原则
 * 自己模块提供给别人使用时，不需要让使用方知道提多实现细节，让使用方知道越少实现细节越好
 * Api的实现类的访问权限非public的，这样使用方就只能通过Factory来获取API对象，而且不需要知道具体的实现细节
 *
 *
 */
public class SimpleFactoryClient {

    public static void main(String[] args){

        Api api = Factory.create(2);
        //Api api = new ImplB();   //ImplB不向调用方暴露
    }
}
