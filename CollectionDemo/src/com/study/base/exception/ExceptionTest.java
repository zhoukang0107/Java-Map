package com.study.base.exception;
/**
 * 异常：就是程序在运行时出现的不正常情况
 * 异常由来：问题也是现实生活中的一个具体的事物，也可以通过Java的类的形式进行描述，并封装成对象
 *          其实就是Java对不正常情况进行描述后的对象体现
 * 
 * 对于问题的划分：两种：一种是严重的问题，一种是非严重的问题
 * 对于严重的，Java通过Error类进行描述
 *           对于Error一般不编写针对性的代码对其进行处理
 * 对于非严重的，Java通过Exception类进行描述
 *           对于Exception可以使用针对性的处理方式进行处理
 *           
 * 无论Error或者Exception都具有一些共性内容
 * 比如：不正常情况的信息，引发原因等
 * 
 * Throwable
 *   |--Error
 *   |--Exception
 *   
 * 异常处理：
 * Java提供了特殊的语句进行处理
 * try{
 *   需要被检测的代码
 * }catch(异常类  变量){
 *   处理异常的代码（处理方式）
 * }finally{
 *   一定会执行的语句
 * }
 * 
 * 
 * 对捕获到的异常对象进行常见方法操作
 * String getMessage();//获取异常的信息
 * 
 * 对多异常的处理
 * 1、声明异常时，建议声明更为具体的异常，这样处理可以更具体
 * 
 */


class Demo{
	int div(int a, int b){
		return a/b;
	}
	
	int div1(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException{  //在功能上通过throws的关键字声明了该功能可能出现问题
		int res = a/b;
		int[] arr = new int [a];
		System.out.println(arr[4]);
		return res;
	}
}

public class ExceptionTest {

	public static void main(String[] args)// throws Exception 
	{
		// TODO Auto-generated method stub
		Demo d = new Demo();
		int x = 0;
		try{
			//x = d.div(4, 0);
			x = d.div(4, 2);
			System.out.println("x="+x);
		}catch(Exception e){
			System.out.println("除零了");
			System.out.println(e.getMessage());  //异常信息
			System.out.println(e.toString());    //异常名称  异常信息
			e.printStackTrace();                 //异常名称  异常信息 异常出现的位置
			                                     //其实jvm默认的异常处理机制，就是调用printStackTrace方法，打印异常的堆栈跟踪信息
		}
		
		
		//
		Demo d2 = new Demo();
		int x1 = 0;
		try {
			x1 = d2.div1(4, 0);    //自己处理异常
			System.out.println("x1="+x1);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("除零了");
		} catch (ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("数组越界");
		}
		System.out.println("over");
		
		//Demo d3 = new Demo();
		//int x2 = d3.div1(4, 0);   //异常向上抛出
		//System.out.println("x2"+x2);
		
	}

}
