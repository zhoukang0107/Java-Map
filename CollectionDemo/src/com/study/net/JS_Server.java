package com.study.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JS_Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(10000);
		Socket client = server.accept();
		InputStream in = client.getInputStream();
		byte[] buff = new byte[1024];
		int len = in.read(buff);
		System.out.println(new String(buff,0,len));
		PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
		pw.println("<font size=7 color=red>×¢²á³É¹¦</font> ");
		client.close();
		server.close();
	}

}
