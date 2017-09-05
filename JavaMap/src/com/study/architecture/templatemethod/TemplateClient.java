package com.study.architecture.templatemethod;

/**
 * 模板方法：
 * 定义一个操作中的算法框架，而将一些步骤延迟到子类中去实现，//x新建一个终结符
 * 是的子类不改变算法的接口即可重复定义算法的某些特点步骤
 *
 * 封装不变部分，扩展变化部分
 *
 *
 * 角色：
 * 抽象类，定义算法结构，提供通用实现
 */
public class TemplateClient {
    public static void main(String[] args){
        Game game = new LolGame();
        game.play();
    }
}
