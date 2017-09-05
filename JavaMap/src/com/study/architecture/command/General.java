package com.study.architecture.command;

/**
 * 将军
 */
public class General {
    private Command undoCommand;
    private Command attachCommand;

    public General() {
        //构建士兵
        Soldier soldier = new Soldier();
        //建立军队
        Army army = new Army(soldier);
        undoCommand = new UndoCommand(army);
        attachCommand = new AttachCommand(army);


    }

    /**
     * 皇帝调用大臣攻击方法
     */
    public void attach(){
        attachCommand.excute();
    }

    public void undo(){
        undoCommand.back();
    }
}
