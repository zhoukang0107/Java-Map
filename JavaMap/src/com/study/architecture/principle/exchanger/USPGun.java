package com.study.architecture.principle.exchanger;

/**
 * Created by Zack on 2017/6/17.
 */
public class USPGun implements IGun {
    @Override
    public void fire() {
        System.out.println("USP:开火了");
    }
}
