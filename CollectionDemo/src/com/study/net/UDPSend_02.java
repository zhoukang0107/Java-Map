package com.study.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 需求：通过UDP传输方式，将一段文件数据发送出去
 * 思路：
 * 1、建立udpsocket服务
 * 2、提供数据并将数据封装到数据报包中
 * 3、通过socket服务的发送功能将数据发送出去
 * 4、关闭资源
 *
 */
public class UDPSend_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
	}
	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		//1、创建UPD服务
		DatagramSocket dSocket = new DatagramSocket();
		//2、确定数据，并封装成数据对象
		byte[] data = "udp come".getBytes();
		DatagramPacket dPacket = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9000);
		//通过socket服务将已有的数据发送出去
		dSocket.send(dPacket);
		//关闭资源
		dSocket.close();
	}
	
	static void sop(Object obj){
		System.out.println(obj);
	}
}