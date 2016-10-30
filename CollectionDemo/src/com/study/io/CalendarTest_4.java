package com.study.io;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar:
 * 
 *
 */

import static java.lang.System.*;

import java.text.SimpleDateFormat;
public class CalendarTest_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Date d = new Date();
		out.println(d.toString());
		//只要"年"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		out.print(sdf.format(d));*/
		//获取
		Calendar calendar = Calendar.getInstance();
		String[] months = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
		String[] week = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		out.println(calendar);
		out.println(calendar.get(Calendar.YEAR)+"年");
		int m = calendar.get(Calendar.MONTH);
		out.println(months[m]);
		out.println(calendar.get(Calendar.DAY_OF_MONTH)+"日");
		int w = calendar.get(Calendar.DAY_OF_WEEK);
		out.println(week[w-1]);
		
		
	}

}
