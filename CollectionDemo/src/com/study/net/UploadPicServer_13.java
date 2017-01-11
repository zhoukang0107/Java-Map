package com.study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer_13 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(10007);
		Socket client = server.accept();
		InputStream in = client.getInputStream();
		FileOutputStream fos = new FileOutputStream("D:\\net.jpg");
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len=in.read(buff))!=-1){
			fos.write(buff, 0, len);
		}
		
		OutputStream out = client.getOutputStream();
		out.write("上传成功！".getBytes());
		fos.close();
		client.close();
		server.close();
		
	}

}
