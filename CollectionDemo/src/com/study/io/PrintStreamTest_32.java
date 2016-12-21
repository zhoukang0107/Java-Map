package com.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**，
 * 打印流
 * PrintWriter与PrintStream
 * 可以直接操作输出流和文件
 * 
 * 序列流
 * SequenceInputStream
 * 对多个流进行合并
 * 
 * 操作对象
 * ObjectInputStream与ObjectOutputStream
 * 被操作的对象需要实现Serializable(标记接口)
 * 
 * 
 * 
 * 打印流：：
 * 该流提高了一个打印方法，可以将各种数据类型的数据都原样打印
 * 
 * 字节打印流
 * PrintStream:
 * 构造函数可以接受的参数类型：
 * 1、File对象,File
 * 2、字符串路径，String
 * 3、字节输出流 OutputStream
 * 
 * 字符打印流
 * PrintWriter：
 * 构造函数可以接受的参数类型：
 * 1、File对象,File
 * 2、字符串路径，String
 * 3、字节输出流 OutputStream
 * 4、字符输出流
 * 
 * 
 * 
 */

public class PrintStreamTest_32 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Test1();
		Test2();
	}
	

	private static void Test2() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter("a.txt");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("a.txt")),true);  //println(),printf,format方法自动刷新缓存区
		String line = null;
		while( (line=br.readLine())!=null){
			if ("over".equals(line)){
				break;
			}
			out.println(line);
			//out.write(line.toUpperCase());
			//out.flush();
		}
		out.close();
		br.close();
	}


	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		PrintWriter out = new PrintWriter(System.out,true);  //println(),printf,format方法自动刷新缓存区
		String line = null;
		while( (line=br.readLine())!=null){
			if ("over".equals(line)){
				break;
			}
			out.println(line);
			//out.write(line.toUpperCase());
			//out.flush();
		}
		out.close();
		br.close();
		
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
