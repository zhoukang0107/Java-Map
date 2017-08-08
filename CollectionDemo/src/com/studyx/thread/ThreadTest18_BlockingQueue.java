package com.studyx.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
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
 * 可阻塞队列
 * 队列包含固定长度的队列和不固定长度的队列
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 */

public class ThreadTest18_BlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		Exchanger<String> exchanger = new Exchanger<>();

		executorService.submit(new Runnable() {		
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						String data = "线程1的数据";
						System.out.println("线程"+Thread.currentThread().getName()+" 正在把数据："+data+"换出去");
						Thread.sleep((long) (Math.random()*1000));
						data = exchanger.exchange(data);
						System.out.println("线程"+Thread.currentThread().getName()+"换回数据："+data);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
							
				}
			});
		
		executorService.submit(new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data = "线程2的数据";
					System.out.println("线程"+Thread.currentThread().getName()+" 正在把数据："+data+"换出去");
					Thread.sleep((long) (Math.random()*1000));
					data = exchanger.exchange(data);
					System.out.println("线程"+Thread.currentThread().getName()+"换回数据："+data);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
						
			}
		});

	}
//	线程pool-1-thread-1 正在把数据：线程1的数据换出去
//	线程pool-1-thread-2 正在把数据：线程2的数据换出去
//	线程pool-1-thread-2换回数据：线程1的数据
//	线程pool-1-thread-1换回数据：线程2的数据
	
}

