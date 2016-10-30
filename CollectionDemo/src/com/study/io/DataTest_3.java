package com.study.io;

import java.util.Date;

/**
 * Data:
 * 表示特定的瞬间，精确到毫秒
 * 
 * 构造函数：
 * Data()
 * Data(Long time)
 * 
 *
 * 
 */
import static java.lang.System.*;

import java.text.SimpleDateFormat;
public class DataTest_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		out.println(d.toString());  //打印的日期看不懂，希望有些格式
		//将模式封装到SimpleDateFormat对象中
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日E hh:mm:ss");
		//调用Format方法让模式格式化指定的Date对象
		String str = sdf.format(d);
		out.print(str);
	}

}
