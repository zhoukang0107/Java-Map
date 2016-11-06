package com.study.base.exception;
/**
 * 因为项目中会出现特有的问题
 * 而这些问题并未被java所描述并封装对象
 * 所以对于这些特有的问题可以按照java对问题封装的思想
 * 将特有的问题，进行自定义异常封装
 * 
 * 
 * 自定义异常：
 * 
 * 需求，在本程序中，对于除数为-1，也视为错误的，是无法进行运算的
 * 那么就需要对这个问题进行自定义描述
 * 
 * 当在函数内部出现throw抛出异常对象，那么就必须要给对应的处理动作
 * 要么在内部try catch处理
 * 要么在函数上声明让调用者处理
 * 
 * 一般情况在函数内出现异常，函数上需要声明
 * 
 * 发现打印的结果中只有异常的名称，却没有异常的信息，因为自定义的异常未定义信息
 * 
 * 
 * 如何定义异常信息？
 * 因为父类已经把异常信息的操作完成了，子类只要在构造时，将异常信息传递给父类，通过super语句。
 * 那么就可以直接通过getMessage获取异常信息
 * 
 * 
 * 自定义异常：
 * 必须是自定义类继承Exception  （Throwable以及其子类）
 * 
 * 继承Exception原因：
 * 异常体系由一个特点，因为异常类和异常对象都需要被抛出，
 * 他们都具备可抛性，这个可抛性是Throwable这个体系独有的特点
 * 只有这个体系中的类和对象才可以被throws和throw操作
 * 
 * 
 * throws和throw的区别：
 * throws使用在函数上，throw使用在函数内
 * throws后面跟的是异常类，可以跟多个，用逗号隔开
 * throw跟的是异常对象
 * 
 */


class FuShuException extends Exception{
	public FuShuException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

class Demo1{
	int div(int a, int b) throws FuShuException{
		if (b<0){
			throw new FuShuException("出现了除数是负数的情况");  //手动通过throw抛出一个自定义异常对象
		}
		
		return a/b;
	}
}

public class ExceptionTest2 {

	public static void main(String[] args)// throws Exception 
	{
		// TODO Auto-generated method stub
		Demo1 d = new Demo1();
		int x = 0;
		try {
			x = d.div(4, -1);
			System.out.println("x = " + x);
		} catch (FuShuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("除数出现负数了");
		}
		System.out.println("over");
		
	}

}
