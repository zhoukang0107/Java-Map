package com.study.architecture.abstractfactory;

import com.study.architecture.simplefactory.Api;

/**
 * Created by Zack on 2017/6/1.
 */
public class RefFactory {
    /**
     * 简单工厂方法（另一种方法）
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends Api> T creatProduct(Class<T> clazz){
        Api api = null;
        try {
            api = (Api) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)api;
    }
}
