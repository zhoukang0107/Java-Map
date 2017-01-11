package com.study.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 
 *
 * 
 * 
 */



public class TCPServer2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//创建服务端的Socket服务，并监听一个端口
			ServerSocket server = new ServerSocket(10002);
			//通过Accept方法获取连接过来的客户端对象
			Socket client = server.accept();
			System.out.println(client.getInetAddress().getHostAddress()+" connected");
			//获取客户端发过来的数据，那么要使用客户端对象的读取流来读取数据
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			byte[] buff = new byte[1024];
			int len = in.read(buff);
			System.out.println(new String(buff,0,len));
			out.write("客户端，你好！".getBytes());
			//关闭客户端
			client.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
