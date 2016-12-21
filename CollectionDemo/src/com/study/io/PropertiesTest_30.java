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
 * 那么在加载数据时，需要数据有固定格式：键=值
 * 
 * 
 * 
 */

public class PropertiesTest_30 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Test1();
		Test2();
		Test3();
	}
	

	private static void Test3() throws IOException {
		// TODO Auto-generated method stub
		Properties proper = new Properties();
		FileInputStream fis = new FileInputStream("info.txt");
		proper.load(fis);
		sop(proper);
		proper.setProperty("wangwu", "55");
		proper.list(System.out);
		FileOutputStream fos = new FileOutputStream("info.txt");
		proper.store(fos, "haha");
	}
	


	//演示：如何将流中的数据存储到集合中
	//想要将info.txt中的键值数据存储到集合中进行操作
	/*
	 * 1、用一个流和info.txt文件关联
	 * 2、读取一行数据，将该行数据用"="进行切割
	 * 3、"="左边作为键，右边作为值，存入到Properties集合集合
	 */
	private static void Test2() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("info.txt"));
		Properties proper = new Properties();
		String line = null;
		while((line=br.readLine())!=null){
			
			String[] arr = line.split("=");
			
			proper.setProperty(arr[0], arr[1]);
		}
		br.close();
		sop(proper);
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
