package com.study.io;
import java.io.*;

/**
 * 字符流：
 * FileReader
 * FileWriter
 * 
 * BufferedReader
 * BufferedWriter
 * 
 * 字节流：
 * InputStream
 * OutputStream
 * 需求：需要操作图片数据，这时就需要字节流
 * 
 * 
 * 
 */

public class FileOutputStreamTest_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//writeFile();
		//readerFile();
		//readerFile_2();
		readerFile_3();  
	}
	
	public static void writeFile(){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("fos.txt");
			
			fos.write("abcdefg".getBytes());  //不需要缓存
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if (fos!=null){
				fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void readerFile(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("fos.txt");
			int ch = 0;
			while ((ch=fis.read())!=-1){
				System.out.println((char)ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if (fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	public static void readerFile_2(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("fos.txt");
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len=fis.read(buf))!=-1){
				System.out.println(new String(buf,0, len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if (fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	public static void readerFile_3(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("fos.txt");
			int num = fis.available();
			System.out.println(num);
			byte[] buf = new byte[num];  //定义一个刚刚好的缓存区，不用再循环了,慎用
			fis.read(buf);
			System.out.println(buf);
			System.out.println(new String(buf));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if (fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
}


