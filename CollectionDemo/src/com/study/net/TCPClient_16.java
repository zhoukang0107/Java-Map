package com.study.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient_16 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1",10008);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		for (int i=0;i<3;i++){
			String name = br.readLine();
			if (name==null) break;
			out.println(name);
			System.out.println(name);
			String info = in.readLine();
			System.out.println(info);
			if (info.contains("»¶Ó­")){
				break;
			}
		}
		
		br.close();
		client.close();
		
	}

}
