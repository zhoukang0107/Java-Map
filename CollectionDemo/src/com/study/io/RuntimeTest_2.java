package com.study.io;

import java.io.IOException;

/**
 * Runtime:每个java应用程序都有一个runtime类实例，使应用程序与其运行的环境相连接，
 * 可以通过getRuntime方法获取当前运行时，应用程序不能创建自己的Runtime类实例
 * 
 * 没有构造函数,不可以new对象，该类中有非静态方法，故类中肯定有静态方法获取该类对象（单例），该方法是getRuntime
 * 
 * 
 * Runtime r = Runtime.getRuntime();
 * 
 * 
 * 
 * 
 */
public class RuntimeTest_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runtime r = Runtime.getRuntime();
		try {
			Process p = r.exec("D:\\Program Files\\Notepad++\\notepad++.exe");
			//r.exec("D:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQScLauncher.exe");
			r.exec("notepad.exe D:\\Users\\Think\\workspacej2EE\\CollectionDemo\\src\\com\\study\\io\\SystemTest.java");
			
			try {
				Thread.sleep(2000);
				p.destroy();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
