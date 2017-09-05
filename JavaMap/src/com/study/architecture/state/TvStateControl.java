package com.study.architecture.state;

public class TvStateControl {
    private TvState mTvState;

    public void setmTvState(TvState tvState){
        mTvState = tvState;
    }

    public void powerOn(){
        setmTvState(new PowerOnState());
        mTvState.turnOn();
    }

    public void powerOff(){
        setmTvState(new PowerOffState());
        mTvState.turnOff();
    }
    public void nextChannel() {
        mTvState.nextChannel();
    }

    public void preChannel() {
       mTvState.preChannel();
    }

    public void turnOn() {
        mTvState.turnOn();
    }

    public void turnOff() {
        mTvState.turnOff();
    }


}
