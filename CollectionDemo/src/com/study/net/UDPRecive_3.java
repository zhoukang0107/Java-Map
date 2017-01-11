package com.study.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 需求：定义一个应用程序，用于接收UDP协议传输的数据并处理
 * 
 * 定义udp接收端
 * 思路：
 * 1、建立udpsocket服务，通常会监听一个端口，其实就是给这个接收网络应用程序定义数字标识，方便与明确哪些数据过来该应用程序可以处理
 * 2、定义一个数据包，用于存储接收到的字节数据，因为数据包对象中有更多的功能可以提取字节数据中的不同数据信息
 * 3、通过socket服务的receive将接收到的数据存入已定义好的数据包中
 * 4、通过数据包对象的特有功能，将这些不同的数据取出，打印在控制台
 * 5、关闭资源
 *
 */
public class UDPRecive_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
	}
	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		//1、创建UPD服务
		DatagramSocket dSocket = new DatagramSocket(9000);
		boolean flag = true;
		while(flag ){
			
		
		//2、定义一个数据包，用于存储接收到的数据
		byte[] data = new byte[1024];
		DatagramPacket dPacket = new DatagramPacket(data, data.length);
		//3、通过UDPSocket接收数据
		dSocket.receive(dPacket);  //阻塞式方法
		//4、通过数据包的方法取出数据并打印
		sop(dPacket.getAddress().getHostAddress());
		sop(dPacket.getPort());
		sop(new String(dPacket.getData(),0,dPacket.getLength()));
		}
		//5、关闭资源
		dSocket.close();
	}
	static void sop(Object obj){
		System.out.println(obj);
	}
}