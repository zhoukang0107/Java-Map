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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
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

public class ThreadTest12_Lock {

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
			    		value = "aaaa";	  //Êµ¼ÊÈ¥queryDB
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

}


