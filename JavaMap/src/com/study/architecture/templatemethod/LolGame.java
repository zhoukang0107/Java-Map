package com.study.architecture.templatemethod;

public class LolGame extends Game {
    @Override
    void login() {
        System.out.println("登录LOL");
    }

    @Override
    void startPlay() {
        System.out.println("开始LOL");
    }

    @Override
    void endPlay() {
        System.out.println("结束LOL");
    }
}
