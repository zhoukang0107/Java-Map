package com.study.thread;

/**
 * �̼߳�ͨѶ��
 * ��ʵ���Ƕ���߳��ڲ���ͬһ��Դ
 * ���ǲ����Ķ�����ͬ
 * 
 * niitify()/notifyAll()
 * �������̵߳��ô˶����notify��������notifyAll����ǰ�����µ�ǰ�̵߳ȴ������仰˵���˷�������Ϊ�ͺ�������ִ��wait(0)����һ����
 * ��ǰ�̱߳������δ˶��������
 * 
 * 
 * wait()
 * niitify()/notifyAll()
 * ��ʹ����ͬ���У���Ϊ��Ҫ�Գ��м��������������̲߳���
 * ����Ҫʹ����ͬ���У���Ϊֻ��ͬ���ž������ĸ���
 * 
 * 
 * Ϊʲô��Щ�����̵߳ķ���Ҫ������Object�����أ�
 * ��Ϊ��Щ�����ڲ���ͬ�����߳�ʱ��������Ҫ��ʶ�����������̳߳��е�����
 * ֻ��ͬһ�����ϵı��ȴ��߳̿��Ա�ͬһ�����ϵ�notify���ѣ������ԶԲ�ͬ���е��߳̽��л���
 * 
 * 
 * Ҳ����˵���ȴ��ͻ��ѱ�����ͬһ������
 * 
 * ��������������������Կ��Ա����������õķ�������Object���С�
 * 
 * ���ڶ�������ߺ������ߣ�
 * ΪʲôҪ����while�жϱ�ǣ�
 * ԭ���ñ����ѵ��߳���һ���жϱ�ǡ�
 * 
 * Ϊʲô����notifyAll��
 * ��Ϊ��Ҫ���ѶԷ��̣߳�
 * ��Ϊֻ��notify�����׳���ֻ���ѱ����̵߳���������³����е������̶߳��ȴ���
 * 
 * 
 */

import static java.lang.System.*;

class Resource{
	private String name;
	private int Count = 1;
	private boolean flag = false;
	
	public synchronized void set(String name){
		while (flag){ //if (flag)  //���ֶ�������߶����������Ҫʹ��while�жϱ��
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name = name+"--"+ Count;
		Count++;
		out.println(Thread.currentThread().getName()+"--������--"+this.name);
		notifyAll();//notify();  //���ֶ�������߶����������Ҫʹ��notifyAll���������߳�
		flag = true;
	}
	
	public synchronized void out(){
		while (!flag){  //if (!flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.println(Thread.currentThread().getName()+"--������--"+this.name);
		notifyAll();//notify();
		flag = false;
	}
}


class Producer implements Runnable{

	private Resource res;

	public Producer(Resource res) {
		super();
		this.res = res;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			res.set("+��Ʒ+");
		}
	}
	
}

class Consumer implements Runnable{
	private Resource res;

	public Consumer(Resource res) {
		super();
		this.res = res;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			res.out();
		}
	}
}

public class ThreadTest8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource res = new Resource();
		new Thread(new Producer(res)).start();
		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();
		new Thread(new Consumer(res)).start();
	}

}