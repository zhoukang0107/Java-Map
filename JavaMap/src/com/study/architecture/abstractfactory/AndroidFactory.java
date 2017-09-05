package com.study.architecture.abstractfactory;

/**
 * AndroidFactory专门用来创建产品AndroidApi
 */
public class AndroidFactory implements IFactory {
    @Override
    public IApi create() {
        return new AndroidApi();
    }
}
