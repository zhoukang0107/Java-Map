package com.study.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流的缓冲区
 * 缓存区的出现提高了对数据的读写效率
 * 对应类
 *     -BufferedWriter
 *     -BufferedReader
 * 缓存区结合流才可以使用
 * 在流的基础上对流的功能进行了增强
 * 
 * 
 * 缓存区的出现是为了提高流的操作效率而出现
 * 所以在创建缓存区之前，必须要先有流对象
 * 该缓存区提供了一个跨平台的换行符
 * newLine()
 *
 */
public class BufferdWriterTest_13 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先创建一个字符写入流对象
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("buf.txt");
			//为了提高字符写入流效率，加入缓存技术
			//只要将需要被提高效率的流对象作为参数传递给缓存区的构造函数即可
			bw = new BufferedWriter(fw);
			//
			for (int i=0;i<5;i++){
				bw.write("abcde"+i);
				bw.newLine();//写入一个行分隔符
				bw.write("ghik"+i);
				bw.newLine();//写入一个行分隔符
				bw.flush();   //防止断电等造成数据丢失
			}
			//记住只要用到缓存区就要记得刷新
			bw.flush();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//其实关闭缓存区，就是关闭缓存区中的流对象,下面关闭流是多余的
				if (bw!=null){
					bw = null;
				}
				if (fw!=null){
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
