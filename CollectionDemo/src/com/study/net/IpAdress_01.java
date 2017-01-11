package com.study.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAdress_01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		Test1();
	}

	private static void Test1() throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress inetAddress = InetAddress.getLocalHost();
		sop(inetAddress.toString());
		sop(inetAddress.getHostName());
		sop(inetAddress.getHostAddress());
		InetAddress address = InetAddress.getByName("www.baidu.com");
		sop(address.toString());
		sop(address.getHostName());
		sop(address.getHostAddress());
		
		InetAddress[] arr = InetAddress.getAllByName("www.baidu.com");
		for (int i = 0;i<arr.length;i++){
			sop(arr[i].toString());
			sop(arr[i].getHostName());
			sop(arr[i].getHostAddress());
		}
		

	}

	static void sop(Object obj){
		System.out.println(obj);
	}
}
