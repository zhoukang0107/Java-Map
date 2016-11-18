package com.study.io;

import java.io.*;

/**
 * 复制一个图片 思路： 1、用字节读取流对象和图片关联 2、用字节写入流创建一个图片文件，用于存储获取到的图片数据 3、循环读写，完成数据存储 4、关闭资源
 * 
 * 
 */

public class FileOutputStreamTest_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\javain.jpg");
			fos = new FileOutputStream("D:\\javaout.jpg");

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf,0,len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("复制文件失败");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (fos != null) {
					fos.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();throw new RuntimeException("复制文件失败");
			}
		}
	}

}
