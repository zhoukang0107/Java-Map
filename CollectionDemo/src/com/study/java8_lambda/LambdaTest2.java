package com.study.java8_lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * File类中的方法，获取一个目录下的文件
 * File类，listFiles()获取File对象封装的目录
 * ListFiles方法传递文件过滤器
 * ListFiles(FileFilter filter)
 * FileFilter接口，传递接口的实现类对象
 * 只有一个方法public boolean accept(File pathname)
 *
 */


public class LambdaTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test1();
		test2();
	}
	
	public static void test1(){
		File dir = new File(".");
		File[] files = dir.listFiles(new FileTxt());
		for (int i =0;files!=null&&i<files.length;i++){
			System.out.println(files[i]);
		}
	}
	
	
	public static void test2(){
		File dir = new File(".");
		File[] files = dir.listFiles((pathname)->{
			if (pathname.getName().endsWith("txt")){
				return true;	
			}
			else{
				return false;
			}
		});
		for (int i =0;files!=null&&i<files.length;i++){
			System.out.println(files[i]);
		}
	}
}

//定义一个文件过滤器，实现FileFilter接口
class FileTxt implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		System.out.println("*****"+pathname);
		if (pathname.getName().endsWith("txt")){
			return true;	
		}
		else{
			return false;
		}
	}
	
}
