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
 * 操作字节数组
 * ByteArrayInputStream与ByteArrayOutputStream
 * ByteArrayInputStream包含一个内部缓存区，该缓存区包含从流中读取的字节，内部计数器跟踪read方法要提供的下一个字节。
 * 关闭ByteArrayInputStream无效，此类的方法在关闭此流后仍可被调用，而不会产生任何IOException
 * 在构造的时候需要接收数据源，而且数据源是一个数组
 * 
 * ByteArrayOutputStream此类实现了一个输出流，其中的数据被写入一个byte数组，缓存区会随着数据的不断写入而自动增长，可使用toByteArray()和toString()获取数据
 * 关闭ByteArrayOutputStream无效，此类中的方法在关闭此流后仍可被调用，而不会产生任何IOException
 * 在构造的时候不用定义数据目的，因为该对象中已经内部封装了可变长度字节数组，这就是数据的目的地
 * 
 * 因为这两个流对象double操作的数据，没有使用系统资源，所以不用进行close关闭
 * 
 * 
 * 
 * 在流操作规律讲解时：
 * 源设备：
 *    键盘System.in  硬盘FileStream   内存ByteArrayInputStream
 * 目的设备
 *    控制台System.out  硬盘FileStream   内存ByteArrayOutputStream
 *   
 * 用流的读写思想来操作数组
 */


public class ByteArrayStreamTest_39 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ByteArrayStream();
	}
	
	public static void ByteArrayStream() throws FileNotFoundException, IOException{
		//数据源
		ByteArrayInputStream bis = new ByteArrayInputStream("abcdefg".getBytes());
		//数据目的
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		sop(bos.size());
		
		int by = 0;
		while((by=bis.read())!=-1){
			bos.write(by);
		}
		
		sop(bos.size());
		sop(bos.toString());
		
		bos.writeTo(new FileOutputStream("ByteArrayOutput.txt"));
	}
	
	
	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
}
