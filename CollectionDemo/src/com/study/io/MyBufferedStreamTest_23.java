package com.study.io;

import java.io.*;

/**
 * 复制一个图片 思路： 
 * 1、用字节读取流对象和图片关联
 * 2、用字节写入流创建一个图片文件，用于存储获取到的图片数据 
 * 3、循环读写，完成数据存储
 * 4、关闭资源
 * 
 * 通过缓存复制文件
 * 
 */

public class MyBufferedStreamTest_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Copy_01();
	}
	public static void Copy_01(){

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("D:\\javain.jpg"));
			
			bos = new BufferedOutputStream(new FileOutputStream("D:\\javaout.jpg"));
			
			int by = 0;
			while ((by=bis.read())!=-1){
				bos.write(by);
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
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();throw new RuntimeException("复制文件失败");
			}
		}
	}

	public static void Copy_02(){
		
	}
}
