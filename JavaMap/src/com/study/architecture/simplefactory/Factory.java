package com.study.architecture.simplefactory;

/**
 *  简单工厂模式：
 *
 * 最少支持原则
 *
 * Api的实现类的访问权限非public的。
 *
 *
 */
public class Factory {

    public static Api create(int type){
        Api api = null;
        switch (type){
            case 1:
                api = new ImplA();
                break;
            case 2:
                api = new ImplB();
                break;
            case 3:
                api = new ImplC();
                break;
            case 4:
                api = new ImplD();
                break;
        }
        return api;
    }

    public <T extends Api> T createProduct(Class<T> cls){
        Object api = null;
        try {
            api = Class.forName(cls.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) api;
    }
}
