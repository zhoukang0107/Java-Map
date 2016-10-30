package com.study.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 已有文件续写
 * FileWriter(filename,append)  //传递一个true参数，代表不覆盖已有文件，并在已有文件的末尾续写，文件不存在则创建
 *
 */
public class FileWriteTest_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileWriter fw = null;
		try {
			//其实该步就是明确数据要存放的目录
			//传递一个true参数，代表不覆盖已有文件，并在已有文件的末尾续写
			fw = new FileWriter("fileWriterTest.txt",true);
			//调用Write方法将字符串写入到流中,还未到文件中
			fw.write("你好\r\n谢谢");   //在window中，回车符由"\r\n"表示
			fw.write("heheheh");
			
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
