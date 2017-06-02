package com.study.architecture.singleinstance;

/**
 * 内部类模式实现单例模式，线程安全
 * s随用随加载
 */
public class InnerClassSingle {
    private InnerClassSingle(){}

    private static class SingleHolder{
        private static final InnerClassSingle instance = new InnerClassSingle();
    }

    public static InnerClassSingle getInstance(){
        return SingleHolder.instance;
    }
}
