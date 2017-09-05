package com.study.architecture.command;

public class UndoCommand implements Command {
    private Army army;

    public UndoCommand(Army army) {
        this.army = army;
    }

    @Override
    public void excute() {
        army.attach();
    }

    @Override
    public void back() {
        army.back();
    }
}
