package com.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 正则表达式的第四个功能
 * 4、获取:将字符串中符合规则的子串取出
 * 
 * 操作步骤：
 * 1、将正则表达式封装成对象
 * 2、将正则对象和要操作的字符串相关联
 * 3、关联后，获取正则匹配引擎
 * 4、通过引擎对符合规则的子串进行操作，比如取出
 * 
 * 
 *      
 * 
 */
public class Regex_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getTest();
	}

	private static void getTest() {
		// TODO Auto-generated method stub
		String str = "";
		String reg = "";
		str="ming tian jiu yao fang jia le";
		reg = "\\b[a-z]{4}\\b";  //"\b"单词边界
		//将规则封装成对象
		Pattern pattern = Pattern.compile(reg);
		//将正则对象和要作用的字符串关联,获取匹配器对象
		Matcher matcher = pattern.matcher(str);
		//
		//matcher.matches();//其实String类中的matches方法就是用Pattern和Matcher对象来完成的，只不过被Sting的方法封装后用起来较为简单，但是功能单一
		//boolean b = matcher.find();   //将规则作用到字符串上，并进行符合规则的子串查找
		//sop(b);
		//sop(matcher.group());  //group用于获取匹配后的结果
		sop(matcher.matches());   //致使匹配指针移动，故下面group()第一个缺少
		while (matcher.find()){
			sop(matcher.group());
			sop(matcher.start());  //位置  头角标
			sop(matcher.end());    //尾角标
		}
		
		
	}
	
	private static void sop(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}
}
