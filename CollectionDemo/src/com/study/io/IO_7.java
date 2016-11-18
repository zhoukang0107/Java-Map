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
 * 既然IO流是操作数据的，那么数据的最常见体现形式就是：文件
 * 
 * 那么以先操作数据为例
 *
 * 先学习字符流
 * 需求：在硬盘上创建一个文件，并写入一些文字数据
 * 专门操作文件的子类对象：FileWriter   后缀名是父类名，前缀名是该子类的功能
 *	
 *
 */
public class IO_7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			//创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件
			//而且该文件会被创建到指定的目录下，如果该目录下已有同名文件将被覆盖
			//其实该步就是明确数据要存放的目的地
			FileWriter fw = new FileWriter("filewriter.txt");
			//调用write方法，将字符串写入流中（内存中）
			fw.write("abcde");
			//刷新流对象中缓冲的数据，将缓存区中临时存放的数据放入目的地中
			fw.flush();
			fw.write("fghijk");
			//关闭流资源，但是关闭之前会刷新一次内部缓冲中的数据
			//将数据刷到目的地中
			//和flush的区别，flush刷新后，流可以继续使用，close刷新后，会将流关闭
			fw.close();
	}

}
