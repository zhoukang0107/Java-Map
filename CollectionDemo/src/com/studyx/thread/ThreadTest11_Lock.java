package com.studyx.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * ¶ÁÐ´Ëø£º
 * ·ÖÎª¶ÁËøºÍÐ´Ëø£¬¶à¸ö¶ÁËø²»»¥³â£¬¶ÁËøÓëÐ´Ëø»¥³â£¬Ð´ËøÓëÐ´Ëø»¥³â
 * 
 * 
 * 
 * 
 * 
 */

public class ThreadTest11_Lock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Queue queue = new Queue();
		for (int i=0;i<6;i++){
			new Thread(){
				public void run() {
					queue.put(Math.random()*1000);
				};
			}.start();
		}
		
		for (int i=0;i<6;i++){
			new Thread(){
				public void run() {
					queue.get();
				}
			}.start();
		}
	}

}

class Queue{
	private Object data = Math.random()*1000;
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	public void get(){
		rwLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"  be ready read data!");
			Thread.sleep((long) (Math.random()*1000));
			System.out.println(Thread.currentThread().getName()+"  have read data:"+data.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rwLock.readLock().unlock();
		}
		
	}
	
	public void put(Object data){
		rwLock.writeLock().lock();
		
		try {
			System.out.println(Thread.currentThread().getName()+"  be ready write data!");
			
			Thread.sleep(2000);
			this.data = data;
			System.out.println(Thread.currentThread().getName()+"  have write data:"+data.toString());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rwLock.writeLock().unlock();
		}
		
	}
}

