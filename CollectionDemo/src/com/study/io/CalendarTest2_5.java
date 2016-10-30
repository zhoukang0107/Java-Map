package com.study.io;
/**
 * Calendar:
 * 
 * 获取任一年的二月有多少天
 * calendar.set(year,2,1); //获取某一年的三月一号
 * calendar.add(Calendar.DAY_OF_MONTH,-1)  //向前推一天，就是二月最后一天
 * 
 * 获取昨天的现在这个时刻
 * calendar.add(Calendar.DAY_OF_MONTH,-1)
 */
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar:
 * 
 *
 */

import static java.lang.System.*;

import java.text.SimpleDateFormat;
public class CalendarTest2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//获取
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 2, 22);
		print(calendar);
		calendar.add(Calendar.YEAR,3);
		calendar.add(Calendar.MONTH,3);
		print(calendar);
		calendar.add(Calendar.YEAR,-3);
		print(calendar);
		
	}
	
	public static void print(Calendar calendar){
		String[] months = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
		String[] week = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		//out.println(calendar);
		out.println(calendar.get(Calendar.YEAR)+"年");
		int m = calendar.get(Calendar.MONTH);
		out.println(months[m]);
		out.println(calendar.get(Calendar.DAY_OF_MONTH)+"日");
		int w = calendar.get(Calendar.DAY_OF_WEEK);
		out.println(week[w-1]);
	}

}
