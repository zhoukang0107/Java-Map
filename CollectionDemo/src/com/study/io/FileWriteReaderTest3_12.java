package com.study.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 将C盘的一个文件复制到D盘
 * 复制原理：
 * 就是将C盘的一个文件存储到D盘的一个文件
 * 
 * 步骤：
 * 1、在D盘创建一个文件，用于存储C盘文件的数据
 * 2、定义一个读取流和C盘文件关联
 * 3、通过不断的读写完成数据存储
 * 4、关闭资源
 *
 */
public class FileWriteReaderTest3_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Copy_1();
		Copy_2();
	}
	
	//从C盘读一个字符就往D盘写一个字符
	public static void Copy_1(){
		FileWriter fw = null;
		FileReader fr = null;
		try {
			//创建目的地
			fw = new FileWriter("D:\\Copy.java");
			//与已有文件关联
			fr = new FileReader("D:\\Users\\Think\\workspacej2EE\\CollectionDemo\\src\\com\\study\\io\\IO_7.java");
			int ch = 0;
			while((ch=fr.read())!=-1){
				fw.write(ch);
				System.out.print(ch);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if (fw!=null){
					fw.close();
					}
					if (fr!=null){
						fr.close();
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	//从C盘读一个字符就往D盘写一个字符
		public static void Copy_2(){
			FileWriter fw = null;
			FileReader fr = null;
			try {
				//创建目的地
				fw = new FileWriter("D:\\Copy1.java");
				//与已有文件关联
				fr = new FileReader("D:\\Users\\Think\\workspacej2EE\\CollectionDemo\\src\\com\\study\\io\\IO_7.java");
				int len = 0;
				char[] buf = new char[1024];
				while((len=fr.read(buf))!=-1){
					fw.write(buf,0,len);
					System.out.print(buf);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("读写异常");
			}finally {
				
					try {
						if (fw!=null){
						fw.close();
						}
						if (fr!=null){
							fr.close();
							}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}

		
}
