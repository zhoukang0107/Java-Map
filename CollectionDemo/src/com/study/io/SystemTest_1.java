package com.study.io;

import java.util.Properties;

/**
 * System:类中的方法和属性都是静态的
 * out:标准输出
 * in:标准输入，默认是键盘
 * 
 * 
 * 描述系统一些信息
 * 获取系统属性信息Properties System.getProperties();
 * 
 * @author kang
 *
 */
public class SystemTest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Properties properties = System.getProperties();
		 //如何在系统中设置一些自定义信息
		 System.setProperty("mykey", "hahha");
		 //因为properties是HashTable的子类，也就是map集合的一个子类，可以使用map集合的方法取出集合中的元素
		 //该集合存储的都是字符串，没有泛型定义
		 for (Object obj: properties.keySet()){
			 System.out.println(obj+"--> "+properties.getProperty( (String) obj));
		 }
		 //获取指定属性 java -DKey=value   启动虚拟机时设置属性（-D）
		 System.out.println(properties.getProperty("os.name"));
	}

}
