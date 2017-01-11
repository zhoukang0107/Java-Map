package com.study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 
 *
 * 
 * 
 */



public class TCPServer3_9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		TranServer();
	}

	private static void TranServer() throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(10003);
		Socket client = server.accept();
		System.out.println(client.getInetAddress().getHostAddress()+" connected");
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		String line = null;
		
		
		//PrintWriter out = new PrintWriter(client.getOutputStream());
		
		while ((line=br.readLine())!=null){   //br.readLine()读到回车符才返回数据
			//System.out.println("server recv:"+line);
			//if ("over".equals(line)) break;
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();
			
			//out.println(line.toUpperCase());
		}
		br.close();
		bw.close();
		client.close();
		server.close();
		System.out.println("server closed");
	}

}
