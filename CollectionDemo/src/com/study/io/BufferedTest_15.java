package com.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 通过缓存区复制一个java文件
 * 
 *
 */


public class BufferedTest_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try{
			br = new BufferedReader(new FileReader("buf.txt"));
			bw = new BufferedWriter(new FileWriter("tempBuf.txt"));
			String s = null;
			while ((s=br.readLine())!=null){
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if (br!=null){
					    br.close();
					}
					if (bw!=null){
						bw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

}
