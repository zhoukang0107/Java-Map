package com.study.io;

import java.io.*;

/**
 * 读取键盘录入
 * System.out:对应标准的输出设备：控制台
 * System.in:对应标准的输入设备：键盘
 * 
 * 需求：通过键盘录入数据，当录入一行数据后就将该行数据进行打印
 * 如果录入的数据是over,那么停止录入
 * 
 * 通过刚才的键盘录入一行数据并打印其大写，发现其实就是读一行数据的原理
 * 也就是readLine方法
 * 
 * 能不能直接使用readLine方法来完成键盘录入的一行数据的读取呢？
 * readLine方法是BufferedReader类中的方法
 * 而键盘录入的read方法是字节流InputStream的方法
 * 那么能不能将字节流转换成字符流，再使用字符流缓存区readLine方法
 */

public class WriterOut_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test1();
		//Test2();
		//Test3();
		Test4();
	}
	
	private static void Test4() {
		// TODO Auto-generated method stub
		//获取键盘录入对象
		InputStream in = System.in;
		//将字节流对象转换成字符流对象，使用转换留，InputStreamReader
		InputStreamReader isr = new InputStreamReader(in);
		//将字符流传入字符流缓存区
		BufferedReader br = new BufferedReader(isr);
		String str;
		try {
			while((str = br.readLine())!=null){
				if ("over".equals(str)){
					break;
				}
				System.out.println(str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void Test3() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		try {
			int by1 = 0;
			StringBuilder sb = new StringBuilder();
			while(true){
				int ch = in.read();
				if (ch=='\r'){
					continue;
				}
				if (ch=='\n'){
					String str = sb.toString();
					if ("over".equals(str)){
						break;
					}
					System.out.println(str.toUpperCase());
					sb.delete(0, sb.length());
				}
				sb.append((char)ch);
				//System.out.println(by1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Test2() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		try {
			int by1 = 0;
			while((by1=in.read())!=-1){
				System.out.println(by1);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Test1() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		try {
			int by1 = in.read();
			int by2 = in.read();
			int by3 = in.read();
			System.out.println(by1);
			System.out.println(by2);
			System.out.println(by3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
