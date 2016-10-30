package com.study.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * IO分了字符流和字节流
 * IO常用基类
 *
 * 字节流的抽象类
 * InputoutStream,OutputStream
 * 
 * 
 * 
 * 字符流的抽象基类
 * Reader,Writer
 *
 *
 *
 *	先学习字符流
 *	需求：在硬盘上创建一个文件，并写入一些文字数据
 *	专门操作文件的子类对象：FileWriter   后缀名是父类名，前缀名是该子类的功能
 *	
 *
 */
public class FileWriteTest_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//创建一个FileWriter对象,该对象一被初始化就必须明确被操作的文件,
		//而且该文件会被创建到指定的目录下,如果该目录下已有同名文件，将被覆盖
		FileWriter fw = null;
		try {
			//其实该步就是明确数据要存放的目录
			fw = new FileWriter("fileWriterTest.txt");
			//调用Write方法将字符串写入到流中,还未到文件中
			fw.write("hahahaha");
			//刷新流对象中的缓冲中的数据，将数据刷到目的地
			//fw.flush();
			fw.write("heheheh");
			//fw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//关闭流资源，关闭之前会刷新内部缓存中的数据，将数据刷到目的地
				//和flush的区别是：flush刷新后流还可以继续使用，close刷新后，会关闭流
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
