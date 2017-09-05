package com.study.architecture.builder;

/**
 * 具体建造者
 * 持有对房子的引用
 */
public class WorkBuild implements Build {
    Room room = new Room();
    @Override
    public void makeWindow() {
        room.setWindow("法式窗户");
    }

    @Override
    public void makeFllor() {
        room.setFloor("欧式地板");
    }

    @Override
    public Room build() {
        return room;
    }
}
