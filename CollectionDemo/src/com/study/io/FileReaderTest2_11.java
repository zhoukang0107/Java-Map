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
;public class FileReaderTest2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;
		try {
			//创建一个文件读取流，和指定名称文件相关联
			//要保证该文件夹是已经存在的，如果不存在，会发生异常FileNotFoundException
			fr = new FileReader("D:\\Users\\Think\\workspacej2EE\\CollectionDemo\\src\\com\\study\\io\\FileWriteTest_9.java");
			
			char[] buf = new char[1024];  //通常定义1024的整数倍
			int num = 0;
			while ((num=fr.read(buf))!=-1){
				out.print(new String(buf,0,num));
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
