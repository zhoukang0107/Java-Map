package com.study.io;
/**
 * Math:
 * abs() //取绝对值
 * Ceil  //向上取整（返回大于指定数字的最小整数）
 * floor //向下取整（返回小于指定数字的最大正整数）
 * round //四舍五入
 * pow(a,b)   //幂数运算
 * random   //随机数 大于等于0，小于1的随机数（伪随机数）  （范围：random>=0&&random<1）  java.util.Random
 * 
 */

import static java.lang.System.*;

import java.util.Random;
public class MathTest_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//向上取整
		out.println("向上取整"+Math.ceil(-3.14));
		out.println("向上取整"+Math.ceil(3.14));
		//向下取整
		out.println("向下取整"+Math.floor(-3.14));
		out.println("向下取整"+Math.floor(3.14));
		//四舍五入
		out.println("四舍五入"+Math.round(12.34));
		out.println("四舍五入"+Math.round(12.56));
		//幂数运算
		out.println("幂数运算"+Math.pow(3,3));
		out.println("幂数运算"+Math.pow(2,3));
		//随机数
		out.println("随机数"+Math.random());
		out.println("随机数"+Math.random());
		Random random = new Random();
		out.println("随机数"+random.nextInt(10)+1);

	}

}
