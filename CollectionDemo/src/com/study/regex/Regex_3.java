package com.study.regex;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 *      
 * 
 */
public class Regex_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test();
		IpTest();
		checkMail();
	}

	private static boolean checkMail() {
		// TODO Auto-generated method stub
		String mail = "abs123@sina.com";
		mail = "1@1.1";
		String reg = "[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";  //较为精确的匹配
		reg = "\\w+@\\w+(\\.\\w+)+"; //相对不太精确的匹配
		//mail.indexOf("@")!=-1
		boolean b = mail.matches(reg);
		sop(b);
		return b;
	}

	/**
	 * 192.168.1.254 102.49.23.13 10.10.10.10 2.2.2.2 8.109.90.30
	 * 将IP地址进行地址段顺序的排序
	 * 
	 * 还按照字符串自然顺序排列，只要他们每一段都是3位即可
	 * 1、按照每一段需要的最多的0进行补齐，那么每一段就会至少保证3位
	 * 2、将每一段只保留3位。这样所有的IP地址都是每一段3位
	 * 
	 * 
	 */
	private static void IpTest() {
		// TODO Auto-generated method stub
		String str= "192.168.1.254 102.49.23.13 10.10.10.10 2.2.2.2 8.109.90.30";
		str = str.replaceAll("(\\d+)", "00$1");
		sop(str);
		str = str.replaceAll("0*(\\d{3})", "$1");
		sop(str);
		
		String[] ips = str.split(" +");
		TreeSet<String> tree = new TreeSet<>();
		for (String s :ips){
			tree.add(s);
		}
		for (String s:ips){
			sop(s.replaceAll("0*(\\d+)", "$1"));
		}
	}


	/*
	 * 需求：
	 * 将下面的字符串转换成：我要学编程
	 * 
	 * 到底用四种功能中的哪一个呢？或者哪几个呢？
	 * 思考方式：
	 * 1、如果只想知道该字符串是对是错，可以使用匹配
	 * 2、想要将已有的字符串变成另一个字符串，替换
	 * 3、想要按照指定的方式将字符串变成多个字符串，切割   获取规则以外的子串
	 * 4、想要拿到符合需求的字符串子串，获取  获取符合规则的子串
	 */
	private static void Test() {
		// TODO Auto-generated method stub
		String str = "我我...我我...我要...要要...要要...学学学...学学...编编编...编程...程.程程...程...程";
		/*
		 * 将已有的字符串变成另一个字符串，使用替换功能
		 * 1、可以先将"."去掉
		 * 2、再将多个重复内容变成单个内容
		 */
		str = str.replaceAll("\\.+","");
		sop(str);
		
		str = str.replaceAll("(.)\\1+", "$1");
		sop(str);
		
		
	}


	private static void sop(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}
}
