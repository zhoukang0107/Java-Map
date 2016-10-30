package com.study.utils.collections;

import java.util.Arrays;
import java.util.List;


/**
 * Arrays：用于操作数组的工具类
 * 里面都是些静态方法
 * 
 * asList：将数组变成list集合
 * 可以使用集合中的方法操作数组
 * 将数组变换成集合不可以使用集合的增删方法，因为数据的长度是固定的，如果增删了就会发生UnsupportedOperationException
 * 
 * 如果数组中的元素是对象时，那么变成集合时数组中的元素就直接转成集合中的元素
 * 如果数组中的元素都是基本数据类型，那么会将该数组作为集合中的对象存在
 */


public class ArraysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] arr = {1,23,54,21,32};
		System.out.println(Arrays.toString(arr));
		String[] strs = {"asa","aas","dsd","gdsd","asa"};
		List<String> list = Arrays.asList(strs);
		//list.add("qq");   //将数组变换成集合不可以使用集合的增删方法
		System.out.println(list);*/
		
		int[] arr = {1,23,54,21,32};
		List list = Arrays.asList(arr);
		System.out.println(list);
		List<int[]> li = Arrays.asList(arr);
		System.out.println(li);
		
		Integer[] arr1 = {1,23,54,21,32};
		List list1 = Arrays.asList(arr1);
		System.out.println(list1);
	}

}

