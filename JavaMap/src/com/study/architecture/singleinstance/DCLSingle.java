package com.study.architecture.singleinstance;

/**
 * 懒汉模式：
 * DCL模式创建单例  双重检查
 *
 * DCL模式这种方式不是绝对安全  jvm指令集乱序
 * JVM调用方法的底层机制：
 *
 *
 */
public class DCLSingle {
    private static DCLSingle instance;

    private DCLSingle(){

    }

    public static DCLSingle getInstance(){
        if (instance==null){
            synchronized (DCLSingle.class){
                if (instance==null){
                    instance = new DCLSingle();
                }
            }
        }
        return instance;
    }
}
