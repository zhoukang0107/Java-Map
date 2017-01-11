package com.study.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 演示TCP传输的客户端与服务端互访
 * 需求：客户端给服务端发送数据，服务端收到后，给客户端反馈信息
 * 
 * 
 * 客户端：
 * 1、建立socket服务，指定要连接的主机和端口
 * 2、获取socket流中的输出流，将数据写到该流流中，通过网络发送给服务端
 * 3、获取Socket流中的输入流，将服务端反馈的数据获取到并打印
 * 4、关闭客户端资源
 * 
 */



public class TCPClient2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建客户端的Socket服务
		Socket client = null;
		try {
			client = new Socket("127.0.0.1", 10002);
			//为了发送数据，应该获取Socket流中的输出流
			OutputStream out = client.getOutputStream();
			InputStream in = client.getInputStream();
			out.write("服务端，你好！".getBytes());
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			System.out.println(new String(buf,0,len));
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
