package com.study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 需求：建立一个文本转换服务器
 * 客户端给服务端发送文本，服务端会将文本转换成大写，再返回给客户端，
 * 而且客户端可以不断的进行文本转换，当客户端输入over时，转换结束
 * 
 * 分析：
 * 客户端：
 * 既然是操作设备上的数据，那么就可以使用io技术，并按照io的操作规律来思考
 * 源：键盘录入
 * 目的：网络设备，网络输出流
 * 而且操作的是文本数据,可以选择字符流
 * 
 * 
 * 步骤：
 * 1、建立服务
 * 2、获取键盘录入
 * 3、将数据发给服务端
 * 4、获取服务端返回的大写数据
 * 5、结束，关资源
 * 
 * 
 * 都是文本数据可以使用字符流进行操作，同时提高效率加入缓冲
 * 
 * 
 * 
 * 该例子出现的问题
 * 现象：客户端和服务端都在莫名的等待
 * 为什么呢？
 * 因为客户端和服务端都有阻塞方法，这些方法没有读到结束标记，那么就一直等
 * 而导致两端都在等待
 * 
 */



public class TCPClient3_8 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		TransClient();
	}

	private static void TransClient() throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1", 10003);
		//发送数据相关流
		//定义读取键盘的流数据
		BufferedReader sendbr = new BufferedReader(new InputStreamReader(System.in));
		//定义目的，将数据写入到socket输出流，发送给服务器
		BufferedWriter sendbw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//接收数据相关流
		//定义一个socket读取流，读取服务器返回的大写信息
		BufferedReader recvbr = new BufferedReader(new InputStreamReader(client.getInputStream()));
		//PrintWriter out = new PrintWriter(client.getOutputStream());
		
		String line = null;
		while ((line=sendbr.readLine())!=null){
			sendbw.write(line);
			sendbw.newLine();  //重要   防止无法收到数据
			sendbw.flush();   //重要
			//out.println(line);
			if ("over".equals(line)) break;
			String readLine = recvbr.readLine();
			System.out.println("recv:"+readLine);
		}
		recvbr.close();
		sendbr.close();
		sendbw.close();
		client.close();
		System.out.println("client closed");
		
	}

}
