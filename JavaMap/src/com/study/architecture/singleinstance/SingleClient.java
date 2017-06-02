package com.study.architecture.singleinstance;

import com.study.architecture.singleinstance.DCLSingle;

/**
 * VM调用底层机制
 * 第一步：提取SingleClient.class字节码放入方法区，在常量池有一个DCLSingle的符号引用(这个引用还没有指向真正类信息的地址)
 * 第二步：运行到 将DCLSingle.class字节码信息加载到内存，这时DCLSingle的符号变量指向class类信息
 * 第三步：声明DCLSingle类型 single变量，指向DCLSingle对象
 * 第四步：在堆区开辟空间，实例化DCLSingle对象
 * 指令集乱序导致第三步和第四步的执顺序不确定，single指向了DCLSingle对象的内存空间，由于指令集乱序的原因，此时DCLSingle对象可能还没有创建，volatile关键字解决执行集乱序，被volatile关键字修饰的变量创建的时候不乱序
 * 到底是在堆内存开辟空间返回给single，还是先将single指向堆内存，然后创建对象
 *
 * 1、通过子类引用父类静态字段会不会初始化子类？
 * Class A{
 *     public static int a;
 * }
 *
 * Class B extends A{
 *
 * }
 *
 * B.a = 3;  //不会加载子类字节码
 * 不会
 *
 * 2、通过自定义对象数组类型，会不会加载该类型   Class[]{Person.class,Child.class},此处不会加载Person和Child的class文件
 *
 * 加载一个类的原因：new、反射（Class.from），其他的都不会加载类
 *
 * public static final int a = 10; Persion.java      引用Persion.a;不会加载字节码，在编译成class文件的时候就已经在class文件中定义好了
 *
 *
 *
 */
public class SingleClient {

    public static void main(String[] args) {

        DCLSingle single = DCLSingle.getInstance();

        System.out.println("Hello World!");
    }
}
