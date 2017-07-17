package com.studyx.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

/**
 * 泛型：
 * 
 * 通配符
 * "?"
 * 使用"?"通配符可以引用其他参数化的类型，"?"通配符定义的变量主要用作引用，
 * 可以调用与参数化无关的方法，不能调用与参数化有关的方法。
 * 
 * 通配符的扩展
 * 限定通配符的上界
 * Vector<? extends Number> x = new Vector<Integer>() //ok
 * Vector<? extends Number> x = new Vector<String>() //err
 * 
 * 限定通配符的下界
 * Vector<? extends super> x = new Vector<Number>() //ok
 * Vector<? extends super> x = new Vector<Byte>()   //err
 *
 * 限定通配符总是包含自己
 * 
 * 泛型方法
 * 
 * 泛型类
 * dao data access object-->crud
 * 
 * 
 * 
 */
public class GenericTest2 {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		test();
	}

	private static void test() throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("abc");
		list.add("sdf");
		list.add("ewe");
		list.add("dfg");
		printCollection(list);

		//Vector<Date> v1 = new Vector<Date>();
		Method method = GenericTest2.class.getMethod("applyVector",Vector.class);
		Type[] types = method.getParameterTypes();
		System.out.println(types[0]);  //class java.util.Vector
		System.out.println(method.getGenericParameterTypes()[0]);  //java.util.Vector<java.util.Date>
		System.out.println(((ParameterizedType)(method.getGenericParameterTypes()[0])).getRawType());   //class java.util.Vector
		System.out.println(((ParameterizedType)(method.getGenericParameterTypes()[0])).getActualTypeArguments()[0]);  //class java.util.Date
	}
	
	public static void applyVector(Vector<Date> v1){
		
	}

	private static void printCollection(Collection<?> collection) {
		// TODO Auto-generated method stub
		System.out.println(collection.size());
		for (Object obj : collection){
			System.out.println(obj);
		}
		//collection.add("dfd");  //error
		collection = new HashSet<Date>();  //ok
	}
	
	private static <T> void printCollection1(Collection<T> collection, T t) {
		// TODO Auto-generated method stub
		System.out.println(collection.size());
		for (Object obj : collection){
			System.out.println(obj);
		}
		collection.add(t);  //ok
	}
	
	private static void printCollection2(Collection<Object> collection) {
		// TODO Auto-generated method stub
		System.out.println(collection.size());
		for (Object obj : collection){
			System.out.println(obj);
		}
		collection.add("dfd");  //ok
		//collection = new HashSet<Date>();  //error
	}
}
