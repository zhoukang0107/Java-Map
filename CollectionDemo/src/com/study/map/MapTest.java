package com.study.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合：该集合存储键值对。一对一对往里存，而且要保证键的唯一性
 * 1、添加
 * 		put(key,value)
 * 		putAll(Map<? extends E,? extends V> m)
 * 2、删除
 * 		clear()
 * 		value = remove(key)
 * 		
 * 3、判断
 * 		boolean containsKey(Object key)
 * 		boolean containsValue(Object value)
 * 		isEmpty()
 * 4、获取
 * 		get(Key)
 * 		size()
 *      Collection values()
 *      
 *      entrySet()
 *      keySet()
 *		
 *子类：
 *	HashTable:低层是哈希表数据结构，不可以存入null键、null值,用作键的对象必须实现hashCode和equals,该集合是线程同步的
 *	HashMap：低层是哈希表数据结构，并允许使用null键、null值，该集合是线程非同步，效率高
 *	TreeMap：低层是二叉树结构，线程不同步，可以用于给map集合中的键进行排序
 *
 *
 *
 *和Set很像，其实Set低层就是使用Map实现
 *
 *
 * Map集合的两种取出方式
 * 1、keySet:将map中所有的键存入到Set集合，因为Set具备迭代器，所以可以迭代方式取出所有的键，
 *    再根据get方法，获取每一个键对应的值
 *    Map集合去除原理：将map集合转成Set集合，再通过迭代器取出
 *
 * 2、Set<Map.entry<k,v>> entrySet:将map集合中的映射关系存入到了Set集合中，
 * 	     而这个关系的数据类型就是Map.Entry
 * 	  Map.Entry:其实Entry也是一个接口，它是map接口中的一个内部接口
 * 
 *	  interface Map{
 *	      public static interface Entry{
 *		      public abstract Object getKey();
 *            public abstract Object getValue();
 *		  }
 *	  }
 *
 *	  class HashMap implements Map{
 *	     public Haha implements Map.Entry{
 *	          public Object getKey(){};
 *            public  
 *            Object getValue(){};
 *		 }
 *	  }
 *	  
 *}
 */
public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> hashMap = new HashMap<String,String>();
		//添加元素如果出现添加相同的键，后添加的值会覆盖原有的值，put方法会返回被覆盖的值
		System.out.println("put:"+hashMap.put("map1", "mapvalue1"));
		System.out.println("put:"+hashMap.put("map1", "mapvalue22"));
		hashMap.put("map2", "mapvalue2");
		hashMap.put("map3", "mapvalue3");
		hashMap.put("map4", "mapvalue4");
		hashMap.put(null, "mapvalue4");
		hashMap.put("map5", null);
		System.out.println("containsKey:"+hashMap.containsKey("map1"));
		
		System.out.println("containsKey:"+hashMap.get("map2"));
		System.out.println("get:"+hashMap.get("map22"));//可以通过get方法的返回值判断一个键是否存在，通过返回null来判断
		System.out.println("null:"+hashMap.get(null));
		System.out.println(hashMap);
		
		Collection<String> ct = hashMap.values();
		System.out.println(ct);
		
		Map<String,String> hashMap1 = new HashMap<String,String>();
		hashMap1.put("map1", "mapvalue1");
		hashMap1.put("map2", "mapvalue22");
		hashMap1.put("map1", "mapvalue2");
		hashMap1.put("map6", "mapvalue3");
		hashMap1.put("map5", "mapvalue4");
		hashMap1.put(null, "mapvalue4");
		
		//先获取Map的所有键的Set集合，keySet()
		Set<String> keySet = hashMap1.keySet();
		
		//有了Set集合，就可以获取其迭代器
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(hashMap.get(key)); 
		}
		
		//将map中的映射关系取出
		Set<Map.Entry<String, String>> setEntry = hashMap.entrySet();
		Iterator<Map.Entry<String, String>> mapIt = setEntry.iterator();
		while(mapIt.hasNext()){
			Map.Entry<String, String> entry = mapIt.next();
			System.out.println("key:"+entry.getKey()+" value:"+entry.getValue()); 
		}
	}

}
