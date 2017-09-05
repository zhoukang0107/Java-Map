package com.studyx.jenum;

/**
 * 使用普通类实现枚举
 * @author Zack
 *
 */
public abstract class WeekDay1 {
	private WeekDay1(){}
	public static WeekDay1 SUN = new WeekDay1() {
		
		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return MON;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SUN";
		}
	};

	public static WeekDay1 MON = new WeekDay1() {
		
		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return SUN;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "MON";
		}
	};
	public abstract WeekDay1 nextDay();

}
