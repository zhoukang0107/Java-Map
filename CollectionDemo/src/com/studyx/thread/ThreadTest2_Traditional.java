package com.studyx.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 线程：
 * 多线程下载：通过多线程抢服务器带宽
 * 
 * 定时器：
 * quartz
 * 
 * 内部类不能定义静态变量
 * 
 * 
 *
 */

public class ThreadTest2_Traditional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("timer:"+Thread.currentThread().getName());
			}
		}, 1000,2000);
		
		//new Timer().schedule(task, firstTime, period);
	}

}
