package com.study.architecture.principle.exchanger;

/**
 * Created by Zack on 2017/6/17.
 */
public class AK47Gun implements IGun {
    @Override
    public void fire() {
        System.out.println("AK47:开火了");
    }
}
