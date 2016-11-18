package com.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * 自定义一个readLine，来模拟bufferedReader
 * 
 *
 */

class MyBufferedReader{
	private FileReader fw;
	public MyBufferedReader(FileReader fw){
		this.fw = fw;
	}
	
	//可以一次读一行的方法
	public String readLine() throws IOException{
		//定义一个临时容器，原BuffereReader封装的是一个字符数组，
		//为了演示方便，定义一个StringBuilder容器，因为最终还是要将数据变成字符串
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch=fw.read())!=-1){
			if (ch=='\r'){
				continue;
			}
			if (ch=='\n'){
				return sb.toString();
			}
			else{
				sb.append((char)ch);
			}
		}
		if (sb.length()!=0) return sb.toString();
		return null;
	}
	
	public void close() throws IOException{
		if (fw!=null){
		    fw.close();
		}
	}
}

class MyBufferedReader1 extends Reader{
	private Reader fw;
	public MyBufferedReader1(Reader fw){
		this.fw = fw;
	}
	
	//可以一次读一行的方法
	public String readLine() throws IOException{
		//定义一个临时容器，原BuffereReader封装的是一个字符数组，
		//为了演示方便，定义一个StringBuilder容器，因为最终还是要将数据变成字符串
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch=fw.read())!=-1){
			if (ch=='\r'){
				continue;
			}
			if (ch=='\n'){
				return sb.toString();
			}
			else{
				sb.append((char)ch);
			}
		}
		if (sb.length()!=0) return sb.toString();
		return null;
	}
	
	public void close() throws IOException{
		if (fw!=null){
		    fw.close();
		}
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return fw.read(cbuf, off, len);
	}
}

public class MyBufferedReaderTest_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBufferedReader br = null;
		BufferedWriter bw = null;
		
		try{
			br = new MyBufferedReader(new FileReader("buf.txt"));
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
