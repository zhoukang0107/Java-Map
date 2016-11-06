package com.study.base.exception;
/**
 * 有一个圆形和长方形
 * 都可以获取面积，对于面积如果出现非法数值，视为获取面积出现问题
 * 问题通过异常来表示，先对这个程序进行基本设计
 * 
 * 
 * 异常：
 * 是对问题的描述，将问题进行对象的封装
 * 
 * 异常体系：
 * Throwable
 *    |--Error
 *    |--Exception
 *       |--RuntimeException
 * 异常体系的特点：
 * 异常体系中的所有类以及建立的对象都具备可抛性
 * 也就是可以被throw和throws关键字所处理，只有异常体系具备这个特点
 * 
 * throw和throws区别
 * throw定义在函数内，用于抛出异常对象
 * throws定义在函数上，用于抛出异常类，可以抛出多个用逗号隔开
 * 
 * 
 * 当函数内有throw抛出异常对象，并未进行try处理，必须要在函数上声明，否则编译失败
 * 注意：RuntimeExeption异常除外，也就是说函数内如果抛出的是RuntimeException异常，函数上可以不用声明
 * 
 * 如果函数上声明了异常，调用者需要进行处理，处理方法可以throws可以try.
 * 
 * 
 * 异常有两种：
 *     编译时被检测异常
 *          该异常在编译时，如果没有处理（没有抛也没有try，那么编译失败）
 *          该异常被标识代表着可以被处理
 *     运行时异常（编译时不检测）
 *          在编译时，不需要处理，编译器不检查
 *          该异常的发生建议不处理，让程序停止，需要对代码进行修正
 *          
 *          
 * 异常处理的语句：
 * try{
 *     需要被检测的代码
 * }catch(){
 *     处理异常的代码
 * }finally{
 *     一定会执行的代码
 * }
 * 有三种结合格式
 * 1、
 * try{
 * }catch(){
 * }
 * 2、
 * try{
 * }finally{
 * }
 * 3、
 * try{
 * }catch(){
 * }finally{
 * }
 * 注意：
 * 1、finally通常定义的是关闭资源代码，因为资源必须被释放
 * 2、finally有一种情况不会被执行，当执行到System.exit(0)时finally不会执行
 * try{
 * 
 * }catch(Exception e){
 *    System.exit(0); //系统退出时，不会执行finally中语句
 * }finally{
 *    finally语句
 * }
 * 
 * 自定义异常：
 *     定义类继承Exception或者RuntimeException
 *     1、为了让该自定义类具备可抛性
 *     2、让该类具备操作异常的共性方法
 *     
 *     当要定义自定义异常的信息时，可以使用父类已经定义好的功能，
 *     将异常信息传递给父类的构造函数，
 *     class MyException extends Exception{
 *         MyException(String msg){
 *             super(msg);
 *         }
 *     }
 * 
 * 自定义异常：是按照java的面向对象思想，将程序中出现的特有问题进行封装。
 * 
 * 
 * 异常的好处：
 *     1、将问题进行封装
 *     2、将正常流程代码和问题处理代码相分离，方便阅读
 * 
 * 异常的处理原则：
 *     1、处理方式有两种：try或者throw
 *     2、调用到抛出异常的功能时，抛出几个，就处理几个
 *         一个try对应多个catch
 *     3、多个catch,父类的catch放到最下面
 *     4、catch内需要定义针对性的处理方式，不要简单的定义printStackTrace，输出语句，也不要不写
 *         当捕获到的异常，本功能处理不了时可以继续在catch中抛出
 *         try{
 *             throw new AException();
 *         }catch(AException e){
 *             throw e
 *         }
 *         
 *         
 *         如果该异常处理不了，但并不属于该功能出现的异常，可以将异常转换后，再抛出和该功能相关的异常
 *         或者异常可以处理，需要将异常产生的本功能相关的问题提供出去，让调用者指定并处理，
 *         也可以将捕获异常处理后，转换新的异常
 *         try{
 *             throw new AException()
 *         }catch(AException e){
 *             //对AException异常先处理
 *             throw new BException()
 *         }
 *         比如：汇款的例子
 *         
 * 
 * 异常的注意事项：
 *     在子父类覆盖时，
 *     1、子类抛出的异常必须是父类的异常的子类或者子集（重写方法中）
 *     2、如果父类或者接口没有异常抛出时，子类覆盖出现异常，只能try不能抛        
 *         
 * 
 * 
 */

class NoValueException extends RuntimeException{
	NoValueException(String message){
		super(message);
	}
}

interface Shape{
	double getAre() throws NoValueException;
}

class Rec implements Shape{

	private int width,height;

	public Rec(int width, int height)// throws NoValueException
	{
		super();
		
		/***********正常流程代码和问题处理代码结合非常的紧密，阅读性很差**********/
		/*if (width<=0||height<=0){
			System.out.println("错了");
		}else{
			this.width = width;
			this.height = height;
		}*/
		
		if (width<=0||height<=0)
			throw new NoValueException("出现非法值");
		
		this.width = width;
		this.height = height;
	}
	@Override
	public double getAre() {
		// TODO Auto-generated method stub
		
		System.out.println(width*height);
		return width*height;
	}
}

class Circle implements Shape{
	private int radius;
	
	public Circle(int radius) {
		super();
		if (radius<=0){
			throw new NoValueException("出现非法值");
		}
		this.radius = radius;
	}

	@Override
	public double getAre() throws NoValueException {
		// TODO Auto-generated method stub
		double d = Math.PI*radius*radius;
		System.out.println(d);
		return d;
	}
	
}
public class ExceptionTest5 {

	public static void main(String[] args)// throws Exception 
	{
		// TODO Auto-generated method stub
	
		Rec r = new Rec(3, 4);
		r.getAre();
		
		Circle c = new Circle(-5);
		c.getAre();
		
		System.out.println("over");
	}


}








