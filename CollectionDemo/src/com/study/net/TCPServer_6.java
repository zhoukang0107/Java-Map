package com.study.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
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
 *
 * 
 * 
 */



public class TCPServer_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//创建服务端的Socket服务，并监听一个端口
			ServerSocket server = new ServerSocket(10001);
			//通过Accept方法获取连接过来的客户端对象
			Socket client = server.accept();
			System.out.println(client.getInetAddress().getHostAddress()+" connected");
			//获取客户端发过来的数据，那么要使用客户端对象的读取流来读取数据
			InputStream in = client.getInputStream();
			byte[] buff = new byte[1024];
			int len = in.read(buff);
			System.out.println(new String(buff,0,len));
			//关闭客户端
			client.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
