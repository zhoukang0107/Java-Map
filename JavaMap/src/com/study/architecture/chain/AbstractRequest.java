package com.study.architecture.chain;

public abstract class AbstractRequest {
    private Object object;

    public Object getContent(){
        return object;
    }

    /**
     *
     * @return
     */
    public abstract int getRequestLevel();
}
