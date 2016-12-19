package com.study.io;

import java.io.*;

import java.util.Properties;

/**
 * 将异常信息存入文件
 * 
 */

public class ExceptionInfo_25 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
	}
	

	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		Properties pro = System.getProperties();
		//System.out.println(pro);
		pro.list(System.out);
		pro.list(new PrintStream("system.txt"));
	}
	
}

//log4j 
