package com.study.architecture.builder;

/**
 * 建造者模式
 * 定义：将一个复杂的构建与他的表示分离，使得同样的构建过程可以创建不同的表示
 * 角色：
 * 抽象建造者->给出一个抽象接口，定义了各个工人所需要进行的工作，
 * 这些工作是为了完成对房子的创建，就像工地会有指导手册一样
 * 具体建造者-》具体建造者去建造房子，房子造完需要将房子还给房屋主人，所以需要有返回房子的方法
 * 设计者，
 * 知道房子怎么设计
 * 知道工人所具备的能力
 * 从整体角度出发，他什么样的房子都能够建成，他可以覆盖你所需要的所有需求
 * 产品：产品
 *
 *
 * 变形：
 * 剔除设计者角色
 *
 *
 *
 */
public class BuilderClient {


    public static void main(String[] args){
        Build build = new WorkBuild();
        Designer designer = new Designer();
        Room room = designer.build(build);
        System.out.println(room.toString());
    }
}
