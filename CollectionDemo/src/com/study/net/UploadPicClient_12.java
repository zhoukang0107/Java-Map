package com.study.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 需求：
 * 上传图片
 * 
 * 
 * 客户端：
 * 1、服务端点
 * 2、读取客户端已有的图片文件
 * 3、通过socket输出流将数据发送给服务端
 * 4、读取服务端反馈信息
 * 5、关闭
 * 
 * 
 * 服务端：
 * 
 * 
 * 
 * 
 * 
 */
public class UploadPicClient_12 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		if (args.length!=1){
			System.out.println("请选择一个jpg格式图片");
			return;
		}
		
		File file = new File(args[0]);
		if (file.exists()||file.isFile()){
			System.out.println("图片不存在或者不是一个文件");
			return;
		}
		if (file.getName().endsWith(".jpg")){
			System.out.println("不是jpg格式");
			return;
		}
		if (file.length()>1024*1024*8){
			System.out.println("图片过大");
			return;
		}
		
		Socket client = new Socket("127.0.0.1",10007);
		FileInputStream fis = new FileInputStream("D:\\javain.jpg");
		OutputStream out = client.getOutputStream();
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len=fis.read(buff))!=-1){
			out.write(buff, 0, len);
		}
		//告诉服务端数据已写完
		client.shutdownOutput();
		InputStream in = client.getInputStream();
		byte[] buffin = new byte[1024];
		int num = in.read(buffin);
		System.out.println(new String(buff,0,num));
		
		fis.close();
		client.close();
	}

}
