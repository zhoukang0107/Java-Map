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
 * 
 * 字符编码
 * 字符流的出现是为了方便操作字符
 * 更重要的是加入了编码转换
 * 通过子类转换流来完成   
 *    InputStreamWriter
 *    OutputStreamReader
 * 这两个对象在进行构造的时候可以加入字符集
 * 
 * 编码表由来：
 * 计算机只能识别二进制数据，早期由来是电信号
 * 为了方便应用计算机，让他可以识别各个国家的文字
 * 就将各个国家的文字用数字来表示，并一一对应，形成一张表
 * 这就是编码表
 * 
 * 
 * 常见的编码表：
 * ASCII:美国标准信息交换码
 *    用一个字节的7位可以表示
 * ISO8859-1:拉丁码表 。 欧洲码表
 *    用一个字节的8位表示
 * GB2312:中国的中文表码表
 * GBK:中国的中文编码表升级，融合了更多的中文文字符号
 * Unicode:国际标准，融合了多种文字
 *    所有的文字都用两个字节来表示，java语言使用的就是unicode
 * UTF-8:最多用三个字节来表示一个字符
 * 
 * 编码：字符串变成字节数组
 * 
 * 
 * 解码：字节数组变成字符串
 * 
 * 
 * String-->byte[]    str.getBytes(charsetName);
 * byte[]-->String    new String(byte[],charsetName);
 * 
 * 
 */


public class EncodeStreamTest_41 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//EncodeStreamTest();
		//EncodeStreamTest1();
		EncodeStreamTest2();
	}


	
	
	private static void EncodeStreamTest2() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s = "你好";
		byte[] b1 = s.getBytes("gbk");   //中文编码出错，解不出来
		System.out.println(Arrays.toString(b1));
		String str1 = new String(b1,"iso8859-1");
		sop("iso8859-1:"+str1);
		//对iso8859-1编码
		byte[] b2 = str1.getBytes("iso8859-1");
		//重新解码（gbk）
		sop("utf-8:"+new String(b2,"gbk"));
	}




	private static void EncodeStreamTest1() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s = "你好";
		byte[] b1 = s.getBytes();  //s.getBytes("gbk");
		byte[] b2 = s.getBytes("iso8859-1");   //编码出错，解不出来
		System.out.println(Arrays.toString(b1));
		System.out.println(Arrays.toString(b2));
		sop("gbk:"+new String(b1,"gbk"));
		sop("utf-8:"+new String(b1,"utf-8"));
		sop("gbk:"+new String(b2,"gbk"));
		sop("utf-8:"+new String(b2,"utf-8"));
	}




	private static void EncodeStreamTest() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s = "你好";
		byte[] b1 = s.getBytes();  //s.getBytes("gbk");
		byte[] b2 = s.getBytes("utf-8");
		System.out.println(Arrays.toString(b1));
		System.out.println(Arrays.toString(b2));
		sop("gbk:"+new String(b1,"gbk"));
		sop("utf-8:"+new String(b1,"utf-8"));
		sop("gbk:"+new String(b2,"gbk"));
		sop("utf-8:"+new String(b2,"utf-8"));
				
	}




	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
}
