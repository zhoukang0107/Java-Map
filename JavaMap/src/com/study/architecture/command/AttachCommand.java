package com.study.architecture.command;

public class AttachCommand implements Command {
    private Army army;

    public AttachCommand(Army army) {
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
