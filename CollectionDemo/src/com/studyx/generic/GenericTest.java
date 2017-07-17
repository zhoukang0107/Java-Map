package com.studyx.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

/**
 * 泛型：
 * 泛型是提供给javac编译器使用的，可以限定集合中的输入类型，让编译器挡住
 * 源程序中的非法输入，编译器编译带类型说明符的集合时，会去掉“类型”信息，
 * 使程序运行效率不受影响，对于参数化的类型信息，getClass（）方法的返回
 * 值和原始类型完全一样，由于编译生产的额字节码会去掉泛型的“类型”信息，只
 * 要能跳过编译器，就可以往某个泛型集合中加入其它类型的数据，例如，用反射
 * 得到集合，再调用其add方法即可。
 * 
 * 参数化类型不考虑参数的继承关系
 * Vector<String> v = new Vector<Object>();  //错误
 * Vector<Object> v = new Vector<String>();  //错误
 * 在创建数组实例时，数组的元素不能使用参数化的类型
 * Vector<String> vlist[] = new Vector<String>[10];  /err
 * 
 * 注意编译阶段和运行阶段的区分
 * 
 * Vector v1 = new Vector<String>();
 * Vector<Object> v2 = v1             //没错
 */
public class GenericTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		test();
	}

	private static void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		ArrayList<String> strlist = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();
		System.out.println(strlist.getClass()==intList.getClass());  //true   javac编译后会去掉泛型类型信息

		ArrayList<Integer> cl = new ArrayList<>();
		cl.getClass().getMethod("add", Object.class).invoke(cl, "abc");
		System.out.println(cl.get(0));   //abc
		
		//Vector<String> vlist[] = new Vector<String>[10];   //error
		
		 Vector v1 = new Vector<String>();
		 Vector<Object> v2 = v1;      //ok
	}

}
