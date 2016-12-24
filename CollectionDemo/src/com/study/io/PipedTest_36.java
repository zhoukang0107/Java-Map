package com.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

/**
 * ， IO包中其他类 RandomAccessFile 随机访问文件，自身具备读写的方法 通过skipBytes(int x),seek(int
 * x)来达到随机访问
 * 
 * 管道流 PipedOutputStream和PipedInputStream 输入输出可以直接进行连接，通过结合线程使用
 * 
 * 连接方式： PipedInputStream(PipedOutputStream piped) 或者
 * PipedInputStream.connect(PipedOutputStream piped)
 * 
 */

class Read implements Runnable {
	private PipedInputStream in;
	Read(PipedInputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte[] buff = new byte[1024];
		int len;
		try {
			System.out.println("读取前没有数据，阻塞线程");
			len = in.read(buff);
			System.out.println("读到数据，阻塞结束");
			String s = new String(buff,0,len);
			System.out.println(s);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("管道输入流失败");
		}
		
	}

}

class Write implements Runnable {
	private PipedOutputStream out;
	Write(PipedOutputStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("开始写入数据等待六秒");
			Thread.sleep(6000);
			out.write("guandaolaile".getBytes());
			out.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("管道输出流失败");
		}
	}

}

public class PipedTest_36 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		pipedStreamTest();
	}

	private static void pipedStreamTest() throws IOException {
		// TODO Auto-generated method stub
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
		
	}

	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
}
