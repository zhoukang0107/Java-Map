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
 * 对象的持久化
 * ObjectInputStream
 * ObjectOutputStream将Java对象的基本数据类型和图像写入OutputStream,可以使用ObjectInputStream读取（重构）对象，通过在流中使用文件可以实现对象的持久存储。
 * 如果流是网络套接字，则可以在另一台主机或另一个进程中重构对象
 * 
 * 1、静态不能序列化
 * 2、对非静态不进行序列化，加关键字transient
 * 
 * 
 */

class SPersion implements Serializable{
	private static final long serialVersionUID = 42L;
	String name;
	transient int age;
	static int count;
	
	public SPersion(String name, int age) {
		super();
		count++;
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "SPersion [name=" + name + ", age=" + age + ",count="+count+"]";
	}
	
	
}
public class SerializableTest_35 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		writeObject();
		readObject();
	}

	
	private static void readObject() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
		SPersion p = (SPersion)ois.readObject();
		sop(p);
	}


	public static void  writeObject() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
		oos.writeObject(new SPersion("lisi", 20));
		oos.close();
	}



	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
}
