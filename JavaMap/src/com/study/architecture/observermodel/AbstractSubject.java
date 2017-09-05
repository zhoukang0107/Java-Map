package com.study.architecture.observermodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */

public abstract class AbstractSubject {
    /**
     * 保存观察者
     */
    private List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer){
        observerList.add(observer);
    }

    public void detach(Observer observer ){
        observerList.remove(observer);
    }

    public void notify(String content){
        for (Observer observer : observerList){
            observer.update(content);
        }
    }
}
