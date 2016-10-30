package com.study.base;

/**
 * 需求：获取一段程序运行的时间
 * 原理：获取程序开始和结束的时间，并相减
 * 获取时间：System.currentTimeMillis()
 * 
 * 
 * 当代码完成优化后就可以解决这类问题，这种方式叫做模板方法设计模式
 * 
 * 
 * 什么是模板方法呢？
 * 在定义功能时，功能的一部分是确定的，但是有不一部分是不确定，而确定的部分在使用不确定的部分，
 * 那么这时就需要将不确定的部分暴露出去，由该类的子类去完成
 * 
 * 
 */


abstract class GetTime{
	public final void getTime(){   //不允许复写
		long start = System.currentTimeMillis();
		/*for (int i=0;i<1000;i++){
			System.out.println(i);
		}
		*/
		runCode();
		long end = System.currentTimeMillis();
		System.out.println("毫秒："+(end-start));
	}

	public abstract void runCode();   //必须复写 
	/*{
		// TODO Auto-generated method stub
		for (int i=0;i<1000;i++){
			System.out.println(i);
		}
	}*/
}

class SubTime extends GetTime{
	/*public void getTime(){
		long start = System.currentTimeMillis();
		for (int i=0;i<4000;i++){
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("毫秒："+(end-start));
	}*/
	public void runCode(){
		for (int i=0;i<4000;i++){
			System.out.println(i);
		}
	}
}
public class TemplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*GetTime gt = new GetTime();
		gt.getTime();*/
		
		SubTime st = new SubTime();
		st.getTime();
	}

}
