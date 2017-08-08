package com.studyx.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * CountDownLatch：
 * 倒计时计数器，调用CountDownLatch对象的countDown方法就将计数器减1，当计数器到达0时，则所有等待者或单个等待者开始执行，
 * 
 * 
 * 
 * 
 * 
 */

public class ThreadTest16_CountDownLatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		final CountDownLatch cyclicBarrier1 = new CountDownLatch(1);
		final CountDownLatch cyclicBarrier2 = new CountDownLatch(3);
		for (int i =0;i<3;i++){
			executorService.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println("线程"+Thread.currentThread().getName()+"正准备接受命令！");
						cyclicBarrier1.await();
						System.out.println("线程"+Thread.currentThread().getName()+"已接受命令！");
						Thread.sleep((long) (Math.random()*1000));
						System.out.println("线程"+Thread.currentThread().getName()+"回应命令处理结果！");
						cyclicBarrier2.countDown();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
						
				}
			});
		}
		
		
		try {
			Thread.sleep((long) (Math.random()*1000));
			System.out.println("线程"+Thread.currentThread().getName()+"即将发布命令！");
			cyclicBarrier1.countDown();
			System.out.println("线程"+Thread.currentThread().getName()+"已经发送命令，正在等待结果！");
			cyclicBarrier2.await();
			System.out.println("线程"+Thread.currentThread().getName()+"得到命令结果！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

