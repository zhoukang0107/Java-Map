package com.study.architecture.chain;

/**
 * 责任链模式定义：
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系，
 * 将这些对象形成一条链，并沿着这条链传递该请求，直到有对象处理它为止
 *
 *
 * 多个对象能够处理同一个请求，具体处理
 *
 * 责任链是一个单向链表，丢给头部
 *
 */

public class ChainClient {

    public static void main(String[] args){
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();
        Handler handler3 = new Handler3();
        //拼装链子
        handler1.nextHandler = handler2;
        handler2.nextHandler = handler3;

        AbstractRequest request1 = new Request1();
        //一定要将请求对象对给头开始处理
        handler1.handRequest(request1);

        AbstractRequest request2 = new Request2();
        //一定要将请求对象对给头开始处理
        handler1.handRequest(request2);

    }
}
