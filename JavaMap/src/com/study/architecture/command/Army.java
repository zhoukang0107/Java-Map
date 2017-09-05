package com.study.architecture.command;

/**
 * 军队
 * 具体执行打仗任务
 */
public class Army {
    private Soldier soldier;

    public Army(Soldier soldier) {
        this.soldier = soldier;
    }

    public void attach(){
        soldier.setAttach("攻击 齐国");
        System.out.println("攻击 齐国");
    }

    public void back(){
        soldier.setBack("前方大事不妙，赶紧撤退！");
        System.out.println("前方大事不妙，赶紧撤退！");
    }
}
