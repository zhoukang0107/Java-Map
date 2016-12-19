package com.study.io;

import java.io.*;

/**
 * File类
 * 用来将文件或者文件夹封装成对象
 * 方便对文件与文件夹的属性信息进行操作
 * File对象可以作为参数传递给流的构造函数
 * 
 * File.separator：分隔符
 * 
 * 
 * File类的常见方法
 * 1、创建
 *    boolean createNewFile();在指定位置创建文件，如果该文件已经存在，则不创建，返回false,和输出流不一样，输出流对象一建立创建文件，而且文件已经存在，会覆盖。
 *    createTempFile:创建临时文件
 *    创建文件夹
 *    boolean mkdir()   创建文件夹 只能创建一目录
 *    boolean mkdirs()  创建多级文件夹
 * 2、删除
 *    boolean delete();   删除失败返回false
 *    void deleteOutExit();   在程序退出时，删除指定文件     程序结束时删除指定文件
 * 3、判断
 *    boolean canExecute();  文件是否可执行
 *    boolean exists();      文件是否存在
 *    //在判断一个文件对象是否是文件或者目录时，必须要先判断该文件对象封装的内容是否存在，通过exists判断
 *    boolean isFile();      是否是文件
 *    boolean isDirectory(); 是否是目录
 *    boolean isHidden();    是否是隐藏文件
 *    boolean isAbsolute();  是否是绝对路径,必须是全路径
 * 4、获取信息
 *    String getName();          获取此对象说表示的文件或目录名字
 *    String getPath();          获取路径
 *    String getParent();        获取父目录，如果没有则为null,改方法返回的是绝对路径中的父目录，如果获取的是相对路径的返回null,如果相对路径中有上一层目录，则该目录就是返回结果
 *    String getAbsolutePath();  获取绝对路径
 *    File getAbsoluteFile();    返回此抽象对象的路径的绝对路径名形式,封装成了File对象
 *    long lastModified();       最后一次修改时间
 *    long length();             文件大小
 *    
 * 5、其他函数
 *    boolean renameTo(File dest);  //移动并修改文件名字,有移动的功能
 *    static File listRoot();       //列出可用的文件系统根,返回机器中所有根目录
 *    String[] list();              //获取指定文件夹（该目录必须存在，否则返回数组长度为0）下所有的文件和文件夹,所属的对象封装的对象是文件时，返回null
 *    String[] list(FilenameFilter filter);  文件过滤     FilenameFilter：接口
 *    File[] listFiles();           //返回当前文件夹下的文件以及文件夹的对象
 *    File[] listFiles(FilenameFilter filter);
 *    
 */

public class FileTest_26 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Test1();
		//Test2();
		//Test3();
		//Test4();
		//Test5();
		//Test6();
		//Test7();
		//Test8();
		//Test9();
		//Test10();
		//Test11();
		Test12();
	}
	
	private static void Test12() {
		// TODO Auto-generated method stub
		File dir = new File(".\\");
		File[] files = dir.listFiles();
		for (File file:files)
			sop("listFiles："+file.getName()+":" +file.length());
	}

	private static void Test11() {
		// TODO Auto-generated method stub
		File f = new File(".\\");
		for (String str:f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				File f = new File(dir, name);
				System.out.println("dir:"+dir.getAbsolutePath()+"------>name:"+name);
				//return f.isFile()&&name.endsWith(".txt");
				return f.isDirectory();
				//return false;
			}
		}))
			sop("listRoots："+str);
	}

	private static void Test10() {
		// TODO Auto-generated method stub
		File f = new File("c:\\");
		//File f  = new File("file.txt");
		for (String str:f.list())
			sop("listRoots："+str);
	}

	private static void Test9() {
		// TODO Auto-generated method stub
		for (File f:File.listRoots())
		sop("listRoots："+f);
	}

	private static void Test8() throws IOException {
		// TODO Auto-generated method stub
		File f  = new File("file.txt");
		File f1 = new File("aa//rfile.txt");
		sop("renameTo："+f.renameTo(f1));
	}

	private static void Test7() throws IOException {
		// TODO Auto-generated method stub
		File f = new File("file.txt");
		f.createNewFile();
		sop("getName："+f.getName());
		sop("getPath："+f.getPath());
		sop("getParent："+f.getParent());
		sop("getAbsolutePath："+f.getAbsolutePath());
		sop("lastModified："+f.lastModified());
		sop("length："+f.length());
		
		File f1 = new File("aa//a.txt");
		sop("getParent："+f1.getParent());
		
	}

	private static void Test6() throws IOException {
		// TODO Auto-generated method stub
		File f = new File("file.txt"); //File(C:\\file.txt);
		//f.createNewFile();
		f.mkdir();
		//在判断一个文件对象是否是文件或者目录时，必须要先判断该文件对象封装的内容是否存在，通过exists判断
		sop("mkdir："+f.isDirectory());
		sop("isFile："+f.isFile());
		sop("isAbsolute："+f.isAbsolute());
		
	}

	private static void Test5() {
		// TODO Auto-generated method stub
		File f = new File("file.txt");
		sop("execute："+f.exists());
		//创建文件夹
		File dir = new File("abc\\kk\\cc\\dd\\ss");
		sop("mkdir："+dir.mkdir());
		sop("mkdirs："+dir.mkdirs());
	}

	private static void Test4() {
		// TODO Auto-generated method stub
		File f = new File("file.txt");
		sop("execute："+f.exists());
	}

	private static void Test3() {
		// TODO Auto-generated method stub
		File f = new File("file.txt");
		sop("execute："+f.canExecute());
	}

	private static void Test2() throws IOException {
		// TODO Auto-generated method stub
		File f = new File("file.txt");
		f.deleteOnExit();  //结束后删除该文件
		sop("create:"+f.createNewFile());
		
	}

	//创建File对象
	private static void Test1() throws IOException {
		// TODO Auto-generated method stub
		//将system.txt封装成对象，可以将已有的和未出现的文件或者文件夹封装成对象
		File file1 = new File("c:\\abc\\a.txt");
		
		//
		File file2 = new File("c:\\abc");
		
		//
		File d = new File("c:\\abc");
		File file3 = new File(d, "c.txt");
		sop(file1);
		sop(file2);
		sop(file3);
		File file4 = new File("c:"+File.separator+"abc"+File.separator+"a.txt");
	}

	private static void sop(Object file) {
		// TODO Auto-generated method stub
		System.out.println(file);
	}
	
	
}

//log4j 
