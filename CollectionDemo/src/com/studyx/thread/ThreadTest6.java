package com.studyx.thread;

import java.util.Random;

public class ThreadTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareData data = new ShareData();
		new Thread(new RunnableDecrement(data)).start();
		new Thread(new RunnableIncrement(data)).start();
	}

}

class RunnableIncrement implements Runnable{
	ShareData data;
	
	public RunnableIncrement(ShareData data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		data.increment();
	}
	
}

class RunnableDecrement implements Runnable{
	ShareData data;
	
	public RunnableDecrement(ShareData data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		data.decrement();
	}
	
}

class ShareData {
	private int i = 0;

	public synchronized void increment() {
		i++;
	}

	public synchronized void decrement() {
		i--;
	}


}
