package com.study.architecture.command;

/**
 * 命令模式
 * 将请求封装成一个对象，从而让用户使用不同的请求把客户端参数化。请求排队或者记录请求日志，
 * 以及支持可撤销的操作
 *
 *
 */
public class Emperor {

    public static void main(String[] args){
        General general = new General();
        general.attach();
        general.undo();

    }
}
