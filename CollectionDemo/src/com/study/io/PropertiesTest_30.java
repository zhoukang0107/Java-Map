package com.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**，
 * Properties是hashMap的子类
 * 也就是说它具备map集合的特点，而且它里面存储的键值对都是字符串
 * 
 * 是集合中和IO技术相结合的集合容器
 * 
 * 该对象的特点：可以用于键值对形式的配置文件
 * 
 * 
 * 
 * 
 * 
 */

public class PropertiesTest_30 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
	}
	

	//设置和获取元素
	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		Properties proper = new Properties();
		proper.setProperty("张三", "zhangsan");
		proper.setProperty("李四", "lisi");
		sop(proper);
		sop(proper.getProperty("张三"));
		proper.setProperty("李四", "小李子");
		Set<String> names = proper.stringPropertyNames();
		for (String name:names){
			sop(name+" "+proper.getProperty(name));
		}
	}

	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
	
	
}

//log4j 
