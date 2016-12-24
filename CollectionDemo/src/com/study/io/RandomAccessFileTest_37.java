package com.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

/**
 * IO包中其他类 RandomAccessFile 随机访问文件，自身具备读写的方法 通过skipBytes(int x),seek(int
 * x)来达到随机访问
 * 
 * 管道流 PipedOutputStream和PipedInputStream 输入输出可以直接进行连接，通过结合线程使用
 * 
 * 连接方式： PipedInputStream(PipedOutputStream piped) 或者
 * PipedInputStream.connect(PipedOutputStream piped)
 * 
 * 
 * 
 * RandomAccessFile:数据的分段写入（多线程下载文件）
 * 此类的实例对象支持随机访问文件的读取和写入，随机访问文件的行为类似存储在文件系统中的一个大型byte数组，存在指向该隐含数组的
 * 光标或索引，称为文件指针；输入操作从文件指针开始读取字节，并随着字节的读取而移此文件指针。如果随机访问文件以读取/写入模式创建
 * 则输出操作也可以用；输入操作从文件指针开始写入字节，并随着对字节的写入而前移此文件指针。写入隐含数组的当前末尾之后的输出操作
 * 导致该数组扩展。该文件指针可以通过geiFilePoint方法读取，并通过seek方法设置
 * 通常，如果此类中的所有读取例程在读取所需数量的字节之前已达到文件末尾，则抛出EOFException(是一种IOException)。
 * 如果由于某些原因无法读取任何字节，而不是在读取所需数量的字节之前已达到文件末尾，则抛出IOException，而不是EOFException。
 * 需要特别指出的是，如果流已关闭，则可能抛出IOException
 * 
 * 
 * 该类不算是IO体系中的子类，而是直接继承自Object
 * 但是它是IO包中的成员，因为它具备读和写功能，
 * 内部封装了一个数组，而且通过指针对数组中的元素进行操作，
 * 可以通过getFilePoint获取指针位置，同时可以通过seek改变指针的位置
 * 
 * 其实完成读写的原理就是内部封装了字节输入流和输出流
 * 通过构造函数可以看出，该类只能操作文件
 * 而且操作文件还有模式:只读r,读写rw
 * 
 * 如果模式为r只读，不会创建文件，回去读取一个存在的文件，如果该文件不存在则会出现异常
 * 如果模式为rw,要操作的文件不存在，会自动创建(非r只读模式)，如果存在不会覆盖
 * 
 * 
 * 
 */


public class RandomAccessFileTest_37 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//RandomAccessFileTest();
		//readFile();
		writeFile();
		
	}
	
	public static void writeFile() throws IOException{
		RandomAccessFile accessFile = new RandomAccessFile("ran.txt", "rw");
		accessFile.seek(8*2);
		accessFile.write("周七".getBytes());
		accessFile.writeInt(120);
		accessFile.close();
		
	}
	
	private static void readFile() throws IOException{
		RandomAccessFile accessFile = new RandomAccessFile("ran.txt", "r");
		byte[] buf = new byte[4];
		int len = 0;
		len = accessFile.read(buf);
		String name = new String(buf,0,len);
		sop(name);
		int age = accessFile.readInt();
		sop(age);
		
		//调整对象指针
		//accessFile.seek(8);
		
		//跳过指定的字节数
		accessFile.skipBytes(8); //只能往前跳，不能往回跳
		len = accessFile.read(buf);
		String name1 = new String(buf,0,len);
		sop(name1);
		int age1 = accessFile.readInt();
		sop(age1);
		accessFile.close();
	}

	private static void RandomAccessFileTest() throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile rAccessFile = new RandomAccessFile("ran.txt", "rw");
		rAccessFile.write("李四".getBytes());
		rAccessFile.writeInt(97);
		rAccessFile.write("王五".getBytes());
		rAccessFile.writeInt(99);
		rAccessFile.write("张三".getBytes());
		rAccessFile.writeInt(110);
		rAccessFile.close();
		
	}

	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
}
