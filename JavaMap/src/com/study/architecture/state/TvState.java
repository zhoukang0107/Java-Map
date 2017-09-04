package com.study.architecture.state;

/**
 * 电视机状态类
 */
public interface TvState {
    void nextChannel();
    void preChannel();
    void turnOn();
    void turnOff();
}
