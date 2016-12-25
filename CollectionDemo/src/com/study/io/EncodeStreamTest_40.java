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
 */


public class EncodeStreamTest_40 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		writeText();
	}
	
	private static void writeText() {
		// TODO Auto-generated method stub
		
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
