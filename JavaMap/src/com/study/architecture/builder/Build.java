package com.study.architecture.builder;

/**
 * 抽象的建造者
 */
public interface Build {
    public void makeWindow();

    public void makeFllor();

    public Room build();

}
