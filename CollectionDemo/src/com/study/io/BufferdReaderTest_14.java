package com.study.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 写入缓存区
 * 从字符输入流中读取文本，缓存各个字符，从而实现字符、数组和行的高效读取
 * 
 * 该缓存区提供了一个一次读一行的方法，readLine(不包含行终止符)，方便对文本的读取
 * 
 * 当返回null时，表示读到文件末尾
 * 
 * readLine方法只返回回车符之前的内容，并不返回回车符
 * 无论是读一行还是读取多个字符，其实最终都是在硬盘上一个一个读取，所以最终使用的还是read方法一次读取一个的方法
 *
 */
public class BufferdReaderTest_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;
		try {
			//创建一个读取流对象和文件相关联
			fr = new FileReader("buf.txt");
			//为了提高效率，加入缓存技术，将字符读取流对象作为参数传递给缓存区对象的构造函数
			br = new BufferedReader(fr);
			String s1 = null;
			while((s1 = br.readLine())!=null){  //结束条件
				System.out.println(s1);
			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (br!=null){
					br.close();	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
