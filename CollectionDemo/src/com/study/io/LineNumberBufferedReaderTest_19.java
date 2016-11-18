package com.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

/**
 * LineNumbeReader
 * 
 * 练习：模拟一个带行号的缓冲区对象
 */
class MyLineNumberReader{
	private Reader r;
	private int lineNumber;
	
	public MyLineNumberReader(Reader r) {
		super();
		this.r = r;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public String readLine() throws IOException{
		lineNumber++;
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while ((ch=r.read())!=-1){
			if (ch=='\r'){
				continue;
			}
			if (ch=='\n'){
				
				return sb.toString();
			}
			sb.append((char) ch);
		}
		if (sb.length()!=0){
			return sb.toString();
		}
		return null;
	}
	
	
	public void close() throws IOException{
		r.close();
	}
}

class MyLineNumberReader1 extends BufferedReader{
	private Reader r;
	private int lineNumber;
	
	public MyLineNumberReader1(Reader r) {
		super(r);
	}
	
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public String readLine() throws IOException{
		lineNumber++;
		return super.readLine();
	}
	
}



public class LineNumberBufferedReaderTest_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*LineNumberReader lnr = null;
	    try {
			FileReader fr = new FileReader("buf.txt");
			lnr = new LineNumberReader(fr);
			String line = null;
			lnr.setLineNumber(3);
			while((line=lnr.readLine())!=null){
				System.out.println(lnr.getLineNumber()+":"+line);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (lnr!=null){
				lnr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		MyLineNumberReader lnr = null;
	    try {
			FileReader fr = new FileReader("buf.txt");
			lnr = new MyLineNumberReader(fr);
			String line = null;
			lnr.setLineNumber(3);
			while((line=lnr.readLine())!=null){
				System.out.println(lnr.getLineNumber()+":"+line);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (lnr!=null){
				lnr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


