package com.study.architecture.singleinstance;

/**
 * 饿汉模式
 * 现实随用随加载，多线程安全
 */
public class Single {
    private static Single instance = new Single();

    private Single(){

    }

    public static Single getInstance(){
        return instance;
    }
}
