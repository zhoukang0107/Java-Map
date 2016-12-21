package com.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

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
 * 序列流：
 * SequenceInputStream：
 * 表示其他输入流的逻辑串联，它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾。
 * 第二个输入流读取，以此类推，指导到达包含的最后一个输入流的文件末尾
 * 构造函数：
 * 1、SequenceInputStream(InputStream is1,InputStream is2);
 * 
 * 
 * 
 * 
 */

public class SequenceInputStreamTest_33 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
	}
	

	


	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		Vector<FileInputStream> v = new Vector<>();
		v.add(new FileInputStream("a.txt"));
		v.add(new FileInputStream("info.txt"));
		v.add(new FileInputStream("javafile.txt"));
		Enumeration<FileInputStream> e = v.elements();
		SequenceInputStream sis = new SequenceInputStream(e);
		FileOutputStream fout = new FileOutputStream("collect.txt");
		
		byte[] buff = new byte[1024];
		int len = 0;
		while((len=sis.read(buff))!=-1){
			fout.write(buff,0,len);
			sop(len);
		}
		fout.close();
		sis.close();
		
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
