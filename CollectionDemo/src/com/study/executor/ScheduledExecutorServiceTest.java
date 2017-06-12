package com.study.executor;
/**
 *  * public interface ScheduledExecutorService extends ExecutorService
 * 一个 ExecutorService，可安排在给定的延迟后运行或定期执行的命令。
 * 用 Executor.execute(java.lang.Runnable) 和 ExecutorService 的 submit 
 * 方法所提交的命令，通过所请求的 0 延迟进行安排。schedule 方法中允许出现 0 和负数延迟
 * （但不是周期），并将这些视为一种立即执行的请求。
 * 
 * 用法示例
 * 
 * 以下是一个带方法的类，它设置了 ScheduledExecutorService ，在 1 小时内每 10 秒钟蜂鸣一次：
 * import static java.util.concurrent.TimeUnit.*;
 class BeeperControl {
    private final ScheduledExecutorService scheduler = 
       Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
                public void run() { System.out.println("beep"); }
            };
        final ScheduledFuture<?> beeperHandle = 
            scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        scheduler.schedule(new Runnable() {
                public void run() { beeperHandle.cancel(true); }
            }, 60 * 60, SECONDS);
    }
 }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class ScheduledExecutorServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
