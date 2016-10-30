package com.study.utils.collections;

/**
 * java 1.5版本出现的新特性
 * 可变参数
 * 
 * 方法的可变参数
 * 在使用时注意：可变参数一定要定义在参数列表的最后
 */

public class ParamMedthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//show(3,4);
		
		//int[] arr = {2,3,4,5};
		//show(arr);
		
		//虽然少定义了多个方法，但是每一次都要定义一个数组作为实际参数
		
		/**
		 * 可变参数
		 * 其实就是前一种数组参数的简写形式，
		 * 不用每次手动建立数组对象，
		 * 只要将要操作的元素作为参数传递即可
		 * 隐式的的将这些参数封装成了数据
		 */
		show();
		show(2);
		show(2,2,3,45,6);
		show("hahaha",2,3,45,6);
	}
	
	/*public static void show(int a, int b){
		System.out.println(a+" "+b);
	}*/
	
/*	public static void show(int[] arr){
		
	}*/
	
	public static void show(int... ar){
		System.out.println(ar.length);
	}
	
	public static void show(String str,int... ar){
		System.out.println(str+":"+ar.length);
	}

}
