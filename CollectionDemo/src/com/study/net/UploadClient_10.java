package com.study.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient_10 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1",10006);
		BufferedReader br = new BufferedReader(new FileReader("system.txt"));
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		String line = null;
		while ((line=br.readLine())!=null){
			out.println(line);
		}
		client.shutdownOutput();//关闭客户端输出流，相当于给流中加一个结束标记
		//out.println("over");
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		line = in.readLine();
		System.out.println(line);
		in.close();
		br.close();
		out.close();
	}

}
