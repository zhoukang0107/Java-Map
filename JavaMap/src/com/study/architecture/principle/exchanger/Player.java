package com.study.architecture.principle.exchanger;

/**
 * Created by Zack on 2017/6/17.
 */
public class Player {
    private IGun iGun;
    public void buyGun(IGun iGun){
        this.iGun = iGun;
    }

    public void fire(){
        iGun.fire();
    }

}
