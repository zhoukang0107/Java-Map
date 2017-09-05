package com.study.architecture.observermodel;


import com.study.architecture.chain.AbstractRequest;

public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String content) {
        System.out.println(name + "收到消息："+content);
    }
}
