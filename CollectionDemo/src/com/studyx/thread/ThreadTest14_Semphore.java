package com.studyx.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
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
 * 信号灯：
 * 可以维护当前访问自身的线程个数，并提供了同步机制
 * 使用Semaphore可以控制同时访问资源的个数
 * 
 * 
 * 
 * 
 */

public class ThreadTest14_Semphore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(3);
		for (int i =0;i<15;i++){
			executorService.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("线程"+Thread.currentThread().getName()+"进入,"+
					"当前已有"+(3-semaphore.availablePermits()));
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("线程"+Thread.currentThread().getName()+"即将离开,"+
							"当前已有"+(3-semaphore.availablePermits()));
					semaphore.release();
					
					System.out.println("线程"+Thread.currentThread().getName()+"已经离开,"+
							"当前已有"+(3-semaphore.availablePermits()));
						
				}
			});
		}
	}
	
	
}

class Pool {
	   private static final int MAX_AVAILABLE = 100;
	   private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

	   public Object getItem() throws InterruptedException {
	     available.acquire();
	     return getNextAvailableItem();
	   }

	   public void putItem(Object x) {
	     if (markAsUnused(x))
	       available.release();
	   }

	   // Not a particularly efficient data structure; just for demo

	   protected Object[] items = new Object[MAX_AVAILABLE];//... whatever kinds of items being managed
	   protected boolean[] used = new boolean[MAX_AVAILABLE];

	   protected synchronized Object getNextAvailableItem() {
	     for (int i = 0; i < MAX_AVAILABLE; ++i) {
	       if (!used[i]) {
	          used[i] = true;
	          return items[i];
	       }
	     }
	     return null; // not reached
	   }

	   protected synchronized boolean markAsUnused(Object item) {
	     for (int i = 0; i < MAX_AVAILABLE; ++i) {
	       if (item == items[i]) {
	          if (used[i]) {
	            used[i] = false;
	            return true;
	          } else
	            return false;
	       }
	     }
	     return false;
	   }

	 }