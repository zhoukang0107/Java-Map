package com.study.thread;

/**
 * http://blog.csdn.net/u010687392/article/details/50549236
 * ThreadLocal
 * 作用
 * 关于ThreadLocal，这个类的出现并不是用来解决在多线程并发环境下资源的共享问题的，它和其它三个关键字不一样，其它三个关键字都是从线程外来保证变量的一致性，
 * 这样使得多个线程访问的变量具有一致性，可以更好的体现出资源的共享。而ThreadLocal的设计，并不是解决资源共享的问题，而是用来提供线程内的局部变量，
 * 这样每个线程都自己管理自己的局部变量，别的线程操作的数据不会对我产生影响，互不影响，所以不存在解决资源共享这么一说，如果是解决资源共享，
 * 那么其它线程操作的结果必然我需要获取到，而ThreadLocal则是自己管理自己的，相当于封装在Thread内部了，供线程自己管理
 * 
 * 用法
 * 一般使用ThreadLocal，官方建议我们定义为private static ，至于为什么要定义成静态的，这和内存泄露有关，后面再讲。 
 * 它有三个暴露的方法，set、get、remove。
 * 
 * 对于get方法，在ThreadLocal没有set值得情况下，默认返回null，所有如果要有一个初始值我们可以重写initialValue()方法，在没有set值得情况下调用get则返回初始值。
 * 值得注意的一点：ThreadLocal在线程使用完毕后，我们应该手动调用remove方法，移除它内部的值，这样可以防止内存泄露，当然还有设为static。
 * 
 * 内部实现
 * ThreadLocal内部有一个静态类ThreadLocalMap，使用到ThreadLocal的线程会与ThreadLocalMap绑定，维护着这个Map对象，
 * 而这个ThreadLocalMap的作用是映射当前ThreadLocal对应的值，它key为当前ThreadLocal的弱引用：WeakReference
 * 内存泄露问题
 * 
 * 
 * 
 */

import static java.lang.System.*;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest19_Future {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "hello";
        }
    };
    static class MyRunnable implements Runnable{
        private int num;
        public MyRunnable(int num){
            this.num = num;
        }
        @Override
        public void run() {
            threadLocal.set(String.valueOf(num));
            System.out.println("threadLocalValue:"+threadLocal.get());
        }
    }

    public static void main(String[] args){
    	
        new Thread(new MyRunnable(1)).start();
        new Thread(new MyRunnable(2)).start();
        new Thread(new MyRunnable(3)).start();
        //res
        //运行结果如下，这些ThreadLocal变量属于线程内部管理的，互不影响
        /*
        threadLocalValue:2
        threadLocalValue:3
        threadLocalValue:1
        */
    }
}
