package com.study.architecture.observermodel;

/**
 * 观察者模式：
 * 定义了一种一对多的依赖关系，让多格观察者对象同时监听某一个主题对象，
 * 这个主题对象在状态发生变化时，会通知所有观察者对象，使他们能够自动更新自己
 *
 * 角色：
 * 观察者、被观察者
 *
 */
public class ObserverModelClient {
    public static void main(String[] args){
        AbstractSubject abstractSubject = new ConcreteSubject();
        //建立观察者
        Observer observer1 = new ConcreteObserver("observer1");
        Observer observer2 = new ConcreteObserver("observer2");
        Observer observer3 = new ConcreteObserver("observer3");
        Observer observer4 = new ConcreteObserver("observer4");
        Observer observer5 = new ConcreteObserver("observer5");
        //建立联系
        abstractSubject.attach(observer1);
        abstractSubject.attach(observer2);
        abstractSubject.attach(observer3);
        abstractSubject.attach(observer4);
        abstractSubject.attach(observer5);
        //开始通知观察者
        abstractSubject.notify("快十一了");
    }

}
