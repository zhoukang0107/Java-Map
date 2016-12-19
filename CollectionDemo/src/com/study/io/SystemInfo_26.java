package com.study.io;

import java.awt.image.SampleModel;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 将异常信息存入文件
 * 
 */

public class SystemInfo_26 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
	}
	

	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		try{
			int[] arr = new int[2];
			System.out.println(arr[3]);
		}catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace(); //== e.printStackTrace(System.out);
			
			/*try {
				e.printStackTrace(new PrintStream("exception.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			try {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
				String str = sdf.format(d);
				PrintStream ps = new PrintStream("exception.log");
				//ps.write(d.toString().getBytes());
				ps.println(str);
				System.setOut(ps);
				e.printStackTrace(System.out);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
}

//log4j 
