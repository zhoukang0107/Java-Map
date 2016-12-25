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
 * IO包中其他数据类型
 * 操作基本数据类型
 *     DataInputStream与DataOutputStream
 * 操作字节数组
 *     ByteArrayInputStream与ByteArrayOutputStream
 * 操作字符数组
 *     CharArrayReader与CharArrayWrite
 * 操作字符串
 *     StringReader与StringWriter
 * 
 * 
 * 操作基本数据类型
 * DataInputStream与DataOutputStream
 * 可以用于操作基本数据类型的流对象
 * 
 * 
 * 
 */


public class DataStreamTest_38 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	
		writeUTF_8();
		//writeUTF();
		//readUTF();
		//writeFile();
		//readFile();
	}
	
	private static void writeUTF_8() throws IOException {
		// TODO Auto-generated method stub
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
		osw.write("你好");
		osw.close();
	}

	private static void readUTF() throws IOException {
		// TODO Auto-generated method stub
		DataInputStream dis = new DataInputStream(new FileInputStream("datautf.txt"));
		sop(dis.readUTF());
		dis.close();
	}

	private static void writeUTF() throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream dos =new DataOutputStream(new FileOutputStream("datautf.txt"));
		dos.writeUTF("你好");
		dos.close();
		
	}

	public static void writeFile() throws IOException{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("dataoutputstream.txt"));
		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(3.14);
		dos.close();
	}
	
	private static void readFile() throws IOException{

		DataInputStream dis = new DataInputStream(new FileInputStream("dataoutputstream.txt"));
		sop(dis.readInt());
		sop(dis.readBoolean());
		sop(dis.readDouble());
		dis.close();
	}

	

	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
}
