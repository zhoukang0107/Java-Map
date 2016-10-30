package com.study.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合变数组
 * Collection接口中的toArray方法
 * 
 *
 */
public class CollectionToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String > list = new ArrayList<>();
		list.add("asd");
		list.add("ds");
		list.add("asads");
		/*
		 * 指定类型的数组到底要定义多长呢？
		 * 当指定类型的数组长度小于了集合的size,那么该方法内部会创建一个新的数组，长度为集合的size
		 * 当指定类型的数组长度大于了集合大size,就不会新创建数组，二是使用传递进来的数据
		 * 所以创建一个刚刚好的数组最优
		 * 
		 * 为什么要将集合变数组？
		 * 为限定对元素的操作，不需要进行增删了
		 */
		String[] arr = list.toArray(new String[0]);
		System.out.println(Arrays.toString(arr));
		String[] arr1 = list.toArray(new String[5]);
		System.out.println(Arrays.toString(arr1));
		String[] arr2 = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(arr2));
	}

}
