package com.study.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class WebClient_18 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1",8080);
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		out.println("GET /docs/security-howto.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 127.0.0.1:8080");
		out.println("Connection: close");
		out.println();
		out.println();
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String line = null;
		while ((line=in.readLine())!=null){
			System.out.println(line);
		}
		client.close();
	}

}
