package com.study.architecture.singleinstance;

/**
 * 懒汉模式：
 * DCL模式创建单例  双重检查
 *
 * DCL模式这种方式不是绝对安全  
 */
public class DCLVolatileSingle {
    private volatile static DCLVolatileSingle instance;

    private DCLVolatileSingle(){

    }

    public static DCLVolatileSingle getInstance(){
        if (instance==null){
            synchronized (DCLVolatileSingle.class){
                if (instance==null){
                    instance = new DCLVolatileSingle();
                }
            }
        }
        return instance;
    }
}
