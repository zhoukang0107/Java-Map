package com.study.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP传输
 * Socket和ServerSocket
 * 建立客户端和服务端
 * 建立连接后通过Socket中的IO流进行数据的传输
 * 关闭Socket
 * 同样客户端和服务端是两个独立的应用程序
 * 
 * 
 * 演示TCP传输
 * 1、TCP分客户端和服务端
 * 2、客户端对应的对象是Socket
 *    服务端对应的对象是ServerSocket
 *    
 * 
 * 
 * 
 * 客户端：
 * 通过查阅Socket对象发现在该对象建立时就可以连接指定主机
 * 因为TCP是面向连接的，所以在建立Socket服务时，就要有服务端存在，并连接成功，形成通路后，在该通道进行数据传输
 * 
 * 
 * 
 * 需求：
 * 给服务端发送一个文本数据
 * 
 * 
 * 步骤：
 * 1、创建Socket服务并指定要连接主机和端口
 * 2、
 * 
 * 
 * 
 * 服务端：
 * 1、建立服务端的socket服务，ServerSocket()
 *    并监听一个端口
 * 2、获取；连接过来的客户端对象
 *    通过ServerSocket的Accpet方法，没有连接就等待，所以这个方法是阻塞式的
 * 3、客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据
 *    并打印在控制台
 * 4、关闭服务（可选）
 * 
 * 
 * 需求：
 * 定义端点接收数据，并打印在控制台上
 * 
 * 
 */



public class TCPClient_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建客户端的Socket服务
		Socket client = null;
		try {
			client = new Socket("127.0.0.1", 10001);
			//为了发送数据，应该获取Socket流中的输出流
			OutputStream out = client.getOutputStream();
			out.write("tcp client".getBytes());
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
