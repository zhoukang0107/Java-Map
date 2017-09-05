package com.study.architecture.state;

/**
 * 状态模式：
 * 当一个对象，在其内部状态改变的时候改变其行为，这个对象看上去就像是改变了它的类一样，
 * 又称状态对象模式，状态对象模式是对象的行为模式
 *
 *
 * 角色：
 * 环境（Context）角色：上下文，定义客户端所感兴趣的接口，并且保留一个具体状态类的实例，这个定义了对象的当前状态；
 * 抽象状态（State）角色：定义一个接口，应以封装环境(Context)对象的一个特定的状态所对应的行为。
 * 具体状态(ConcreteState)角色：每一个具体状态类都实现了环境的一个状态所对应的行为
 *
 * 使用场景：
 * 1、一个对象的行为取决于他的状态，并且他必须在运行时根据状态改变他的行为
 * 2、。。。。。。。
 *
 *
 *
 * 需求：
 * 电视遥控器，分为开机和关机两种状态，在开机状态下可以通过遥控器进行频道切换、
 * 调整音量操作，但是开机键是无效的，在关机状态下，频道切换、调整音量、关机都是无效的
 * 只有开机键是有效的。
 *
 *
 *
 *
 */
public class StateClient {

    public static void main(String[] args){
        //不使用状态模式
        TvControl tvControl = new TvControl();
        tvControl.powerOff();
        tvControl.nextChannel();
        tvControl.powerOn();
        tvControl.nextChannel();
        tvControl.preChannel();
        tvControl.powerOff();

        System.out.println("*************************");
        //状态模式
        TvStateControl tvStateControl = new TvStateControl();
        tvStateControl.powerOn();
        tvStateControl.preChannel();
        tvStateControl.nextChannel();
        tvStateControl.powerOff();
    }
}
