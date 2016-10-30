package com.study.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 高级for循环
 * 
 * 格式：
 * for (数据类型  变量名:被遍历的集合（Collection）或者数组){
 * 
 * }
 * 
 * 对集合进行遍历
 * 只能获取元素，但是不能对集合进行操作
 * 
 * 迭代器除了遍历，还可以进行remove集合中的元素的动作
 * 
 * 如果使用ListIterator，还可以在遍历的过程中对集合进行增删改查的动作
 * 
 * 
 * 传统for循环和高级for循环有什么区别？
 * 高级for由一个局限性，必须有遍历的目标（例如遍历1到100的数字）
 * 
 * 建议在遍历数组的时候还是使用传统for循环，因为传统for循环可以使用角标
 * 
 *
 */
public class ForEachTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("list1sdgsg");
		list.add("list4");
		list.add("list3qw");
		list.add("list2as");
		list.add("list6zxzd");
		list.add("list2a");
		list.add("list0aqrg");
		System.out.println(list);
		/*Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		for (String s: list){
			//s = "kk";  只能对元素读取，无法修改
			System.out.println(s);
		}
		System.out.println(list);
		
		
		int[] arr = {3,4,5};
		for (int i: arr){
			//i = 1;
			System.out.println(i);
		}
		System.out.println(Arrays.toString(arr));
		
		//
		HashMap<Integer,String> hashMap = new HashMap<>();
		hashMap.put(2, "fd");
		hashMap.put(1, "qw");
		hashMap.put(4, "as");
		hashMap.put(3, "fd");
		
		Set<Integer> setKey = hashMap.keySet();
		for (Integer key:setKey){
			System.out.println(hashMap.get(key));
		}
 
		for (Entry<Integer, String> entrySet:hashMap.entrySet()){
			System.out.println(entrySet.getKey()+" "+entrySet.getValue());
		}
		
		
	}

}
