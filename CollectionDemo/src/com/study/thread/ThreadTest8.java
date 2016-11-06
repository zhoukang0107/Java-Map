package com.study.thread;

/**
 * 线程间通讯：
 * 其实就是多个线程在操作同一资源
 * 但是操作的动作不同
 * 
 */

import static java.lang.System.*;

class Res{
	String name;
	String sex;
}

class Input implements Runnable{

	private Res res = null;
	public Input(Res res) {
		// TODO Auto-generated constructor stub
		this.res = res;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean flag = true;
		while(true){
			synchronized (res) {
				if(flag){
					flag = false;
					res.name = "mike";
					res.sex = "man";
				}else{
					flag = true;
					res.name = "lili";
					res.sex = "woman";
				}
			}
		}
	}
}
class Output implements Runnable{
	private Res res = null;
	public Output(Res res) {
		// TODO Auto-generated constructor stub
		this.res = res;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(res){
					out.println(res.name+"  "+ res.sex);
			}
		}
	}
}


public class ThreadTest8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Res res = new Res();
		Input in = new Input(res);
		Output out = new Output(res);
		
		Thread tin = new Thread(in);
		Thread tout = new Thread(out);
		
		tin.start();
		tout.start();
	}

}