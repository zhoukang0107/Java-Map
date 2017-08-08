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
/**
 * Ïß³Ì³Ø
 * 
 * 
 * 
 * 
 * 
 */

public class ThreadTest10_Lock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}

class BusketBall{
	private int count;
	Lock lock = new ReentrantLock();
	void put(){
		
		lock.lock();
		try{
			System.out.println(count++);
		}finally {
			lock.unlock();
		}
		
	}
	
	void pop(){
		lock.lock();
		try{
			System.out.println(count--);;
		}finally {
			lock.unlock();
		}
	}
}

