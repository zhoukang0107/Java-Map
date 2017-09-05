package com.study.architecture.chain;

/**
 * 具体的处理者
 */
public class Handler1 extends Handler {
    @Override
    public void handler(AbstractRequest request) {
        System.out.println("handler1--->处理了对象"+request.getContent());
    }

    @Override
    public int getHandlerLevel() {
        return 1;
    }
}
