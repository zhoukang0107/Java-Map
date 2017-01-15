package com.study.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 网页爬虫(蜘蛛)
 * 
 *      
 * 
 */
public class Regex_4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//getMails();
		getMails_1();
	}
	private static void getMails_1() throws IOException {
		URL url = new URL("http://mail.qq.com/contact_us.html");
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = null;
		
		String reg = "\\w+@\\w+(\\.\\w+)+";
		Pattern pattern = Pattern.compile(reg);
		while ((line = br.readLine())!=null){
			Matcher matcher = pattern.matcher(line);
			//sop (line);
			while (matcher.find()){
				sop(matcher.group());
			}
		}
	}
	
	/*
	 * 获取指定文档中的邮件地址
	 * 使用获取功能：Pattern Matcher
	 */
	private static void getMails() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(""));
		String line = null;
		
		String reg = "\\w+@\\w+(\\.\\w+)+";
		Pattern pattern = Pattern.compile(reg);
		while ((line = br.readLine())!=null){
			Matcher matcher = pattern.matcher(line);
			sop (line);
			while (matcher.find()){
				sop(matcher.group());
			}
		}
	}

	private static void sop(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}
}
