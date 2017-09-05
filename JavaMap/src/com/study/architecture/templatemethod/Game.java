package com.study.architecture.templatemethod;

public abstract class Game {
    abstract void login();
    abstract void startPlay();
    abstract void endPlay();

    //算法框架，定义为final,防止子类重写算法框架
    public final void play(){
        System.out.println("开机。。。。。。");
        login();
        startPlay();
        endPlay();
        System.out.println("关机。。。。。。");
    }
}
