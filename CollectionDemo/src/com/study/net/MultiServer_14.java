package com.study.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多个客户端同时并发访问服务器
 * 
 * 
 * 为每个客户端创建一个线程来处理客户端通讯
 *
 */

class PicThread implements Runnable{
private Socket client;

	public PicThread(Socket client) {
	super();
	this.client = client;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			long time = System.currentTimeMillis();
			
			InputStream in = client.getInputStream();
			FileOutputStream fos = new FileOutputStream("D:\\"+time+"_net.jpg");
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len=in.read(buff))!=-1){
				fos.write(buff, 0, len);
			}
			
			OutputStream out = client.getOutputStream();
			out.write("上传成功！".getBytes());
			fos.close();
			client.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("上传失败");
		}
	}
	
}

public class MultiServer_14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		ServerSocket server = new ServerSocket(10007);
		while (true){
			Socket client = server.accept();
			System.out.println(client.getInetAddress().getHostAddress()+" connected");
			new Thread(new PicThread(client)).start();
		}
	}

}
