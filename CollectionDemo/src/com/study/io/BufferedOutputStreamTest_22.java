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

class MyBufferedInputStream{
	private InputStream is ;
	private byte[] buf = new byte[1024];
	private int pos = 0,count = 0;
	public MyBufferedInputStream(InputStream is) {
		super();
		this.is = is;
	}
	//一次读取一个字节，从缓存区（字节数组）获取
	public int read() throws IOException{
		//通过is对象读取硬盘上的数据，并存储buf中
		if (count==pos){
			count = is.read(buf);
			if (count==-1){
				return -1;
			}
			pos = 0;
		}
		return buf[pos++];
	}
	
	public void close() throws IOException{
		if (is!=null){
			is.close();
		}
	}
}

public class BufferedOutputStreamTest_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyBufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new MyBufferedInputStream(new FileInputStream("D:\\javain.jpg"));
			
			bos = new BufferedOutputStream(new FileOutputStream("D:\\javaout.jpg"));
			long s = System.currentTimeMillis();
			int by = 0;
			while ((by=bis.read())!=-1){
				bos.write(by);
			}
			System.out.println(System.currentTimeMillis()-s);
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

}
