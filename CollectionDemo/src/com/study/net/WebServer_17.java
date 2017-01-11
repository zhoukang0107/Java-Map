package com.study.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 演示：客户端和服务端
 * 1、
 * 客户端:浏览器(telnet)
 * 服务端:自定义
 * 
 * 2、
 * 客户端：浏览器
 * 服务端：Tomcat服务器
 * 
 * 3、
 * 客户端：自定义
 * 服务端：Tomcat服务器
 */


public class WebServer_17 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(10009);
		Socket client = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String line = null;
		while ((line=in.readLine())!=null){
			System.out.println(line);
		}
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		out.println("客户端，你好");
		client.close();
		server.close();
		
	}

}
