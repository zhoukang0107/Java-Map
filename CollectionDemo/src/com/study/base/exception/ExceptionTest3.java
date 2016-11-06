package com.study.base.exception;
/**
 * Exception 中由一个特殊的子类异常RuntimeException 运行时异常
 * 
 * 如果在函数内抛出该异常，函数上可以不用声明，编译一样通过
 * 如果在函数上声明了该异常，调用者可以不用进行处理，编译一样通过
 * 
 * 之所以不用在函数上声明，不需要让调用者处理，
 * 当该异常发生，希望程序停止，因为在运行时，出现了无法继续运行的情况，希望停止程序后由程序员对代码进行修正
 * 
 * 
 * 自定义异常时，如果该异常的发生，无法再继续运行，
 * 就让自定义异常继承RuntimeException
 * 
 * 对于异常分两种：
 * 1、编译时被检测的异常
 * 2、编译时不被检测的异常：运行时异常，RuntimeException以及其子类
 */

class FushuRException extends RuntimeException{
	FushuRException(String message){
		super(message);
	}
}

class Demo2{
	int div(int a, int b) {
		if (b==0){
			throw new ArithmeticException("被零除了");
		}
		return a/b;
	}
	
	int div1(int a, int b) throws ArithmeticException { //RuntimeException不需要声明
		if (b==0){
			throw new ArithmeticException("被零除了");
		}
		return a/b;
	}
	
	int div2(int a, int b)  { //RuntimeException不需要声明
		if (b<0){
			throw new FushuRException("不能为负数");
		}
		return a/b;
	}
	
	int div3(int a, int b) throws Exception {
		if (b==0){
			throw new Exception();
		}
		return a/b;
	}
}

public class ExceptionTest3 {

	public static void main(String[] args)// throws Exception 
	{
		// TODO Auto-generated method stub
		Demo2 d = new Demo2();
		int x = 0;
		//x = d.div(4, 0);
		//d.div1(4, 0);
		d.div2(4, -3);
		System.out.println("x = " + x);
		
		System.out.println("over");
		
	}

}
