package com.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**，
 * 用于记录应用程序运行的次数
 * 如果使用次数已到，那么给出注册提示
 * 
 * 容易想到：计数器
 * 可是该计数器定义在程序中随着程序的运行而在内存中存在，并进行自增，可是随着该应用程序的退出，该计数器也在内存中消失了
 * 
 * 下次再启动又重新开始从零计数，这不是我们想要的
 * 
 * 程序即使结束，该计数器的值也存在，下次重新启动会先加载该计数器的值，并加1后再重新存储起来
 * 所以要建立一个配置文件，用于记录该软件的使用次数
 * 
 * 该配置文件使用键值对的形式，这样便于阅读并操作数据
 * 
 * 
 * 键值对数据是map集合
 * 
 * 数据是以文件形式存储，使用io技术
 * 那么map+io -->properties
 * 
 * 配置文件可以实现应用程序数据的共享
 * 
 */

public class PropertiesTest_31 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
		
	}
	

	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		Properties proper = new Properties();
		File file = new File("count.ini");
		if (!file.exists()){
			file.createNewFile();
		}
		FileInputStream fis = new FileInputStream(file);
		proper.load(fis);
		int count = 0;
		String value = proper.getProperty("times");
		if (value!=null){
			count = Integer.parseInt(value);
			if (count>=5){
				sop("您好，使用次数已到！");
				return;
			}
		}
		count++;
		proper.setProperty("times", count+"");
		FileOutputStream fos = new FileOutputStream(file);
		proper.store(fos, "");
		fis.close();
		fos.close();
		
		
		
	}

	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
	
	
}
/*
 * dom for java
 * 
 * dom4j
 * <Persions>
 * 		<Persion id = "111">
 * 			<name>name</name>
 * 			<age>12</age>
 * 		</Persion>
 * </Persions>
 */
//log4j 
