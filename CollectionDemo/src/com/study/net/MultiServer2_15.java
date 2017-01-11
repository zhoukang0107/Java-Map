package com.study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端通过键盘录入用户名
 * 服务端对这个用户名进行校验
 * 
 * 如果存在，服务端显示xxx已登录
 * 并在客户端显示xxx,欢迎光临
 * 
 * 如果该用户不存，在服务端显示xxx尝试登录
 * 客户端显示xxx该用户不存在
 * 
 * 
 * 最多登录三次
 * 
 *
 */

class UserThread implements Runnable {

	private Socket client;
	public UserThread(Socket client) {
		// TODO Auto-generated constructor stub
		this.client = client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String ip = client.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");
		try {
			
			for (int i=0;i<3;i++){
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String name = in.readLine();
				if (name==null) break;
				System.out.println(ip+name);
				PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
				System.out.println(ip);
				
				BufferedReader br = new BufferedReader(new FileReader("users.txt"));
				String line = null;
				boolean flag = false;
				while ((line=br.readLine())!=null){
					
					if (line.equals(name)){
						flag = true;
						break;
					}
				}
				
				if (flag){
					System.out.println(name+",已登录");
					out.println(name+",欢迎光临！");
					break;
				}else{
					System.out.println(name+",尝试登录");
					out.println(name+",用户名不存在！");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("校验失败！"+ip);
		}
	}

}

public class MultiServer2_15 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(10008);
		while (true){
			Socket client = server.accept();
			new Thread(new UserThread(client)).start();
		}
		
		
	}

}

