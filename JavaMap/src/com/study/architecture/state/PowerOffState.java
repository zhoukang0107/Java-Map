package com.study.architecture.state;

public class PowerOffState implements TvState{
    @Override
    public void nextChannel() {
        System.out.println("无效");
    }

    @Override
    public void preChannel() {
        System.out.println("无效");
    }

    @Override
    public void turnOn() {
        System.out.println("正在开机");
    }

    @Override
    public void turnOff() {
        System.out.println("无效");
    }
}
