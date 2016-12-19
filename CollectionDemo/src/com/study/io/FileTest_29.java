package com.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**，
 * 练习：
 * 将一个指定目录下的java文件的绝对路径，存储到一个文本文件中
 * 建立一个java文件列表文件
 * 
 * 思路：
 * 1、对指定的目录进行递归
 * 2、获取递归过程中所有的java文件路径
 * 3、将这些路径存储到集合中 
 * 4、将集合中的数据存储到文件中
 * 
 */

public class FileTest_29 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test1();
	}
	

	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(".//");
		ArrayList<File> files = new ArrayList<>();
		fileToList(dir, files);
		sop(files.size());
		WriteToFile(files);
	}
	
	private static void WriteToFile(ArrayList<File> files) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw  = new BufferedWriter(new FileWriter("javafile.txt"));
		for (File file: files){
			bw.write(file.getAbsolutePath());
			sop(file.getAbsolutePath());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}


	public static void fileToList(File dir, List<File> fileList){
		File[] files = dir.listFiles();
		if (files==null) return;
		for (File file:files){
			if (file.isDirectory()){
				fileToList(file, fileList);
			}else{
				if (file.getName().endsWith(".java")){
					fileList.add(file);
				}
			}
		}
	}

	


	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
	
	
}

//log4j 
