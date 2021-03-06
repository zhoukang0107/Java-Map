package com.study.thread;

/**
 * http://tanfujun.com/2016/07/03/Thread-Future-FutureTask-CompletableFuture-ThreadLocal-%E5%AD%A6%E4%B9%A0/
 * Callable
 * Callable是一个参数化的类型接口，里面只有一个call方法，但是该方法是有返回值的，而且返回值类型就是参数类型。
 * 
 * Future
 * 与Callable接口相配套使用的就是Future接口，其作用就是用来保存异步运算的结果和 和启动一个异步运算，Future接口中一共有五个方法，分别用来查询和控制线程运行的状态和结构。
 * boolean cancel (boolean mayInterruptIfRunning) 取消任务的执行。参数指定是否立即中断任务执行，或者等等任务结束
 * boolean isCancelled () 任务是否已经取消，任务正常完成前将其取消，则返回 true, boolean isDone () 任务是否已经完成。需要注意的是如果任务正常终止、异常或取消，都将返回true
 * V get () throws InterruptedException, ExecutionException 等待任务执行结束，然后获得V类型的结果。InterruptedException 线程被中断异常， ExecutionException任务执行异常，如果任务被取消，还会抛出CancellationException
 * V get (long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException 同上面的get功能一样，多了设置超时时间。参数timeout指定超时时间，uint指定时间的单位，在枚举类TimeUnit中有相关的定义。如果计 算超时，将抛出TimeoutException
 * 
 * FutureTask
 * 实际的运用中间我们还有更简洁的机制那就是FutureTask包装器，它可将Callable转换成Future和Runnable，它同时是实现了两者的接口的。使用这种方式可以控制线程超时等等
 * 
 * CompletableFuture
 * Java 8 的新玩意
 * 
 * ThreadLocal
 * ThreadLocal是一个关于创建线程局部变量的类。
 * 通常情况下，我们创建的变量是可以被任何一个线程访问并修改的。而使用ThreadLocal创建的变量只能被当前线程访问，其他线程则无法访问和修改。
 * 同一个ThreadLocal在不同的线程中存在不同的值
 * 修改ThreadLocal初始值:
 * ThreadLocal<String> mThreadLocal = new ThreadLocal<String>() {
 *     @Override
 *     protected String initialValue() {
 *       return Thread.currentThread().getName();
 *     }
 * };
 * 
 * 
 */

import static java.lang.System.*;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest18_ThreadLocal {
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
