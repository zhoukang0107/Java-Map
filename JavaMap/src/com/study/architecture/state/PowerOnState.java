package com.study.architecture.state;

public class PowerOnState implements TvState{
    @Override
    public void nextChannel() {
        System.out.println("下一个频道");
    }

    @Override
    public void preChannel() {
        System.out.println("上一个频道");
    }

    @Override
    public void turnOn() {
        System.out.println("已经开机，开机无效");
    }

    @Override
    public void turnOff() {
        System.out.println("关机");
    }
}
