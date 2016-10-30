package com.study.utils.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 集合框架工具类
 * 
 *
 */

class Student{
	
}
public class CollectionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sortTest();
		//maxTest();
		//binarySearchTest();
		//fillTest();
		replaceAllTest();
		//reverseOrderTest();
	}
	
	public static void sortTest(){
		List<String> list = new ArrayList<String>();
		list.add("list1sdgsg");
		list.add("list4");
		list.add("list3qw");
		list.add("list2as");
		list.add("list6zxzd");
		list.add("list2a");
		list.add("list0aqrg");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, new StrLength());
		System.out.println(list);
	}
	
	public static void maxTest(){
		List<String> list = new ArrayList<String>();
		list.add("list1sdgsg");
		list.add("list4");
		list.add("list3qw");
		list.add("list2as");
		list.add("list6zxzd");
		list.add("list2a");
		list.add("list0aqrg");
		Collections.sort(list);
		System.out.println(list);
		String str = Collections.max(list);
		System.out.println("max:"+str);
		String str1 = Collections.max(list,new StrLength());
		System.out.println("max-length:"+str1);
	}
	
	public static void binarySearchTest(){
		List<String> list = new ArrayList<String>();
		list.add("list1sdgsg");
		list.add("list4");
		list.add("list3qw");
		list.add("list2as");
		list.add("list6zxzd");
		list.add("list2a");
		list.add("list0aqrg");
		Collections.sort(list);
		System.out.println(list);
		//int index = Collections.binarySearch(list, "list4");
		int index = halfSearch(list, "list4");
		System.out.println("index:"+index);
		Collections.sort(list,new StrLength());
		System.out.println(list);
		 index = halfSearch2(list, "list4",new StrLength());
		System.out.println("index:"+index);
		
	}
	
	public static int halfSearch(List<String> list,String key){
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		while(min<=max){
			mid = (max+min)>>1;
			String str = list.get(mid);
			int res = str.compareTo(key);
			if (res==0){
				return mid;
			}else if (res>0){
				max = mid-1;
			}else{
				min = mid + 1;
			}
		}
		return -min-1; //插入点
	}
	
	public static int halfSearch2(List<String> list,String key,Comparator<String> comp){
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		while(min<=max){
			mid = (max+min)>>1;
			String str = list.get(mid);
			int res = comp.compare(str, key);
			//int res = str.compareTo(key);
			if (res==0){
				return mid;
			}else if (res>0){
				max = mid-1;
			}else{
				min = mid + 1;
			}
		}
		return -min-1; //插入点
	}
	/*
	 * fill方法可以将list中所有元素替换成指定元素，
	 * 将list中部分元素替换成指定元素？？
	 */
	public static void fillTest(){
		List<String> list = new ArrayList<String>();
		list.add("list1sdgsg");
		list.add("list4");
		list.add("list3qw");
		list.add("list2as");
		list.add("list6zxzd");
		list.add("list2a");
		list.add("list0aqrg");
		System.out.println(list);
		Collections.fill(list, "hahaha");
		System.out.println(list);
	}
	public static void replaceAllTest(){
		List<String> list = new ArrayList<String>();
		list.add("list1sdgsg");
		list.add("list4");
		list.add("list3qw");
		list.add("list2a");
		list.add("list6zxzd");
		list.add("list2a");
		list.add("list0aqrg");
		System.out.println(list);
		Collections.swap(list, 2, 3);
		System.out.println(list);
		Collections.replaceAll(list, "list2a","hahaha");
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println("随机置换列表位置shuffle:"+list);
	}
	
	public static void reverseOrderTest(){
		//Collections.reverseOrder(new StrLength())返回一个与StrLength相反的比较器
		TreeSet<String> sets = new TreeSet<String>(Collections.reverseOrder(new StrLength()));
		sets.add("list1sdgsg");
		sets.add("list4");
		sets.add("list3qw");
		sets.add("list2as");
		sets.add("list6zxzd");
		sets.add("list2a");
		sets.add("list0aqrg");
		System.out.println(sets);
	}

}

class StrLength implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()-o2.length();
	}
	
}
