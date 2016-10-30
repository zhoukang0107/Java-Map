package com.study.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 读取已有文件
 * FileReader(filename)
 *
 */

import static java.lang.System.*
;public class FileReaderTest_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;
		try {
			//创建一个文件读取流，和指定名称文件相关联
			//要保证该文件夹是已经存在的，如果不存在，会发生异常FileNotFoundException
			fr = new FileReader("fileWriterTest.txt");
			//调用读取流对象的read方法
			//读取方式一：int read()方法：一次读取一个字符，而且会自动往下读,返回-1时读完
			/*while (true){
				int ch = fr.read();
				if (ch==-1){
					break;
				}
				out.println((char)ch);
			}*/
			/*int ch = 0;
			while ((ch=fr.read())!=-1){
				out.println((char)ch);
			}*/
			//读取方式二：字符数组读取 int read(char[] buf)
			//定义一个字符数组，用于存储读到的字符串，
			//该read方法返回的读到的字符个数,返回-1则读取结束
			/*char[] buf = new char[6];
			int num = fr.read(buf);
			out.println("num="+num+"--"+new String(buf));
			
			num = fr.read(buf);
			out.println("num="+num+"--"+new String(buf));*/
			
			char[] buf = new char[1024];  //通常定义1024的整数倍
			int num = 0;
			while ((num=fr.read(buf))!=-1){
				out.println("num="+num+"--"+new String(buf,0,num));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//关闭流资源，关闭之前会刷新内部缓存中的数据，将数据刷到目的地
				//和flush的区别是：flush刷新后流还可以继续使用，close刷新后，会关闭流
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
