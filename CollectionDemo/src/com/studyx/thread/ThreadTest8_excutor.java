package com.studyx.thread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 线程池
 * 
 * 
 * 
 * 
 * 
 */

public class ThreadTest8_excutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建固定大小的线程池
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);
		//创建缓存线程池
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		//创建单一线程池(如何实现线程死掉后重新启动)
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int j=0;j<10;j++){
			final int ii = j;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i=0;i<10;i++){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+" is looping of " +i+" pool task is "+ ii);
					}
				}
			});
		}
		System.out.println("All of task have commited");
		//threadPool.shutdown();
		//threadPool.shutdownNow();
		
		//定时器线程池：10秒以后执行
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing");
			}
		}, 10, TimeUnit.SECONDS);
		//固定频率：5秒后，每隔2秒执行一次
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing");
			}
		}, 5,2 , TimeUnit.SECONDS);
		//定时：指定执行时间减去当前时间
		
	}

}


