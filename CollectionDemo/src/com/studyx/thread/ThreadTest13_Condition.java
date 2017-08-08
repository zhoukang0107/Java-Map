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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 
 * 
 * 
 * 
 * 
 */

public class ThreadTest13_Condition {

	private Map<String ,Object> cache = new HashMap<>();
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Object getData(String key){
		rwLock.readLock().lock();
		Object value = null;
		try{
			value = cache.get(key);
			if (value==null){
				rwLock.readLock().unlock();
				rwLock.writeLock().lock();
			    try{
			    	if (value==null){
			    		value = "aaaa";	  // µº »•queryDB
			    	}
			    }finally {
			    	rwLock.writeLock().unlock();
				}
			    rwLock.readLock().lock();  
			}
			
		}finally {
			rwLock.readLock().unlock();
		}
		return value;
	}

	
	class Business{
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Condition notEmpty = lock.newCondition();
		private boolean bShouldSub = true;
		private int value = 0;
		public void put(int i){
			lock.lock();
			try{
				while (bShouldSub){
					try {
						condition.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				value = i;
				System.out.println("");
				notEmpty.signal();
			}finally {
				lock.unlock();
			}
		}
		
		public void get() {
			lock.lock();
			try{
				while (bShouldSub){
					try {
						notEmpty.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println(""+value);
				condition.signal();
			}finally {
				lock.unlock();
			}
		}
		
	}
	
	
	class Business1{
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		private int index = 1;
		public void run1(){
			lock.lock();
			try{
				while (index!=1){
					try {
						condition1.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println("run1 over, run2 will run...");
				condition2.signal();
			}finally {
				lock.unlock();
			}
		}
		
		public void run2(){
			lock.lock();
			try{
				while (index!=2){
					try {
						condition2.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println("run2 over, run3 will run...");
				condition3.signal();
			}finally {
				lock.unlock();
			}
		}
		
		public void run1(int i){
			lock.lock();
			try{
				while (index!=3){
					try {
						condition3.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println("run3 over, run1 will run...");
				condition1.signal();
			}finally {
				lock.unlock();
			}
		}
		
	}
}


class BoundedBuffer {
	   final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 

	   final Object[] items = new Object[100];
	   int putptr, takeptr, count;

	   public void put(Object x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length) 
	         notFull.await();
	       items[putptr] = x; 
	       if (++putptr == items.length) putptr = 0;
	       ++count;
	       notEmpty.signal();
	     } finally {
	       lock.unlock();
	     }
	   }

	   public Object take() throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == 0) 
	         notEmpty.await();
	       Object x = items[takeptr]; 
	       if (++takeptr == items.length) takeptr = 0;
	       --count;
	       notFull.signal();
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   } 
	 }

