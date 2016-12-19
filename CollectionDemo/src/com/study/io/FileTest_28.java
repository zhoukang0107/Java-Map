package com.study.io;

import java.io.*;

/**
 * 删除一个带内容的目录
 * 删除原理：
 * 在windows当中，删除目录是从里往外删的
 *    
 */

public class FileTest_28 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
		//toBin(20);
		//sop(getSum(8880));
	}
	

	private static void Test1() {
		// TODO Auto-generated method stub
		File f = new File("F:\\delete");
		deleteDir(f);
	}

	static void deleteDir(File dir){
		sop(dir.getName());
		File[] files = dir.listFiles();
		
		if (files==null){
			sop(dir.getName()+" delete dir"+dir.delete());
			return;
		}
		for (File file : files){
			if (file.isFile()){
				sop(file.getName()+" delete file:"+file.delete());	
			}else{
				deleteDir(file);
			}
		}
		sop(dir.getName()+" delete dir"+dir.delete());
	}



	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
	
	
}

//log4j 
