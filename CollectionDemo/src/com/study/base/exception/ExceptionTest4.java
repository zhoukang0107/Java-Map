package com.study.base.exception;
/**
 * finally:
 * 定义一定执行的代码，通常用于关闭资源
 * 
 * try{
 * 	
 * }catch(){
 * 	
 * }
 * 
 * try{
 * 	
 * }catch{
 * 	
 * }finally{
 * 	
 * }
 * 
 * try{
 * 	
 * }finally{
 * 	
 * }
 * 
 * 记住一点：catch是用来处理异常的，如果没有catch就代表异常没有被处理，如果该异常是检测时异常，那么必须声明
 * 
 * 
 * class NoException extends Exception{
 * 	
 * };
 * 
 * public void method() throws NoException{
 * 	链接数据库；
 * 	数据库操作 ; //throw new SQLException
 * 	关闭数据库; //该操作无论数据库操作是否成功，一定要关闭资源
 * 	
 * 	try{
 * 		链接数据库；
 * 		操作数据库；
 * 	}catch(SQLException e){
 * 		throw new NoException();    //抛出自定义的异常，而非SQLException异常，
 * 		                            //主要是分层思想，调用方法者没有必要知道具体的SQL异常细节，
 * 		                            //使用我们自己定义的异常来告诉调用者f方法调用失败了，以及失败的原因，异常必须抛出
 * 	}finally{
 * 		关闭数据库
 * 	}
 * }
 * 
 * 
 * 异常在子父类覆盖中的体现
 * 1、子类在覆盖父类时，如果父类的方法抛出异常，那么子类的覆盖方法，只能抛出父类的异常或该异常的子类或者不抛,如果子类真的发生其他异常，只能内部处理
 * 2、如果父类方法抛出多个异常，那么子类在覆盖该方法时，只能抛出父类异常的子集
 * 3、如果父类或者接口的方法中没有异常的抛出，那么子类在覆盖方法时，也不可以抛出异常
 *    如果子类方法发生了异常。就必须要进行try处理，绝对不能抛
 * 
 */


/*
 * Exception
 *   |--AException
 *      |--BException
 *   |--CException
 */
 
class AException extends Exception{
	
}

class BException extends AException{
	
}

class Parent{
	void show() throws AException{
		
	}
}

class CException extends Exception{
	
}

class Test{
	static void function(Parent p){
		try {
			p.show();
		} catch (AException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Child extends Parent{

	@Override
	void show() throws BException {  //重写父类的show方法后，子类show方法只能抛AException,或者BException，或者不抛
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args){
		Parent p = new Parent();
		Test.function(p);
		Child c = new Child();
		Test.function(c);
	}
}





/*class FushuRException extends Exception{
	FushuRException(String message){
		super(message);
	}
}*/

class Demo3{
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
	
	int div2(int a, int b) throws FushuRException  { //RuntimeException不需要声明
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

public class ExceptionTest4 {

	public static void main(String[] args)// throws Exception 
	{
		// TODO Auto-generated method stub
		int x = 0;;
		try {
			x = test();
		} catch (FushuRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("x = " + x);
		
	}
	
	public static int test() throws FushuRException{
		Demo3 d = new Demo3();
		int x = 0;
		try {
			
			x = d.div2(4, -3);
			System.out.println("x = " + x);
		} catch (FushuRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
			//System.out.println("异常产生了"+e.getMessage());
		}finally{
			System.out.println("finally");
		}
		System.out.println("over");
		return 1;
	}
	
	public void method() throws Exception{
		try{
			throw new Exception();
		}finally{
			//关资源   一定会执行的代码
		}
	}

}








