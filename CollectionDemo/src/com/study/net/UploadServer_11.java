package com.study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer_11 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(10006);
		Socket client = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//BufferedWriter bw = new BufferedWriter(new FileWriter("client_system.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("client_system.txt"));
		String line = null;
		while ((line=in.readLine())!=null){
			//if ("over".equals(line)) break;
			pw.println(line);
		}
		out.write("´«ÊäÍê³É£¡");
		out.newLine();
		out.flush();
		out.close();
		pw.close();
		in.close();
		
	}

}
