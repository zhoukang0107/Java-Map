package com.study.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
//IP:127IP与localhost映射就在本机
//DNS：现在本地找，没有再去DNS服务器解析
public class URLConnection_20 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("http://www.baidu.com/");
		URLConnection conn = url.openConnection();   //连接url主机
		InputStream in = conn.getInputStream();  //不用关
		byte[] buff = new byte[1024*1024];
		int len = in.read(buff);
		sop(new String(buff,0,len));
	}
	private static void sop(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}

}
