package com.study.architecture.abstractfactory;

/**
 * Created by Zack on 2017/6/1.
 */
public class IOSFactory implements IFactory {
    @Override
    public IApi create() {
        return new IOSApi();
    }
}
