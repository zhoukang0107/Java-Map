package com.study.architecture.state;

/**
 * 非状态模式
 */
public class TvControl {
    /**
     * 开机状态
     */
    private final static int POWER_ON = 1;

    /**
     * 关机状态
     */
    private final static int POWER_OFF = 2;

    private int mState = POWER_OFF;

    /**
     * 关机方法
     */
    public void powerOff(){
        if (mState==POWER_ON){
            System.out.println("关机了");
        }else {
            System.out.println("关机");
        }
        mState = POWER_OFF;
    }

    /**
     * 开机方法
     */
    public void powerOn(){
        if (mState==POWER_OFF) {
            System.out.println("开机了");
        }else{
            System.out.println("开机");
        }
        mState = POWER_ON;
    }

    public void nextChannel(){
        if (mState==POWER_OFF){
            System.out.println("已经关机，无效");
        }else{
            System.out.println("切换下一个频道");
        }
    }

    public void preChannel(){
        if (mState==POWER_OFF){
            System.out.println("已经关机，无效");
        }else{
            System.out.println("切换上一个频道");
        }
    }

}
