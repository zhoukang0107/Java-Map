package com.study.net;

import java.net.MalformedURLException;
import java.net.URL;
/*
 String	getFile() 
          获取此 URL 的文件名。
 String	getHost() 
          获取此 URL 的主机名（如果适用）。
 String	getPath() 
          获取此 URL 的路径部分。
 int	getPort() 
          获取此 URL 的端口号。
 String	getProtocol() 
          获取此 URL 的协议名称。
 String	getQuery() 
          获取此 URL 的查询部分。
 */
public class URL_19 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("https://www.google.co.jp/?gfe_rd=cr&ei=WlJ2WKvuN8GE2QS70oPgAg");
		sop("getProtocol:"+url.getProtocol());
		sop("getHost:"+url.getHost());
		sop("getPath:"+url.getPath());
		sop("getPort:"+url.getPort());//
		sop("getFile:"+url.getFile());
		sop("getQuery:"+url.getQuery());
		int port = url.getPort();
		if (port==-1){   //getPort()等于-1，则默认端口为80
			port = 80;
		}
	}

	private static void sop(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}

}
