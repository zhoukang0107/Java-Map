package com.studyx.jenum;

public class EnumTest {

	/**
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeekDay1 tady = WeekDay1.MON;
		System.out.println(tady.nextDay().toString());
		
		WeekDay weekday = WeekDay.MON;
		System.out.println(weekday);   //MON
		System.out.println(weekday.name());  //MON
		System.out.println(weekday.ordinal()); //1
		System.out.println(weekday.getClass());  //class com.study.jenum.EnumTest$WeekDay
		System.out.println(WeekDay.valueOf("SUN"));  //SUN   将字符串"SUN"转换成enum对象
		//System.out.println(WeekDay.valueOf("asdf"));  //java.lang.IllegalArgumentException: No enum constant com.study.jenum.EnumTest.WeekDay.asdf
		System.out.println(WeekDay.values());   //获取所有枚举值
	}
	
	public enum WeekDay{
		SUN(1),MON(),TUE,WEB,THI,FRI,SAT;   //每个值相当于一个WeekDay示例对象
		private WeekDay(){  //必须定义在枚举值的后面，且此时枚举值列表以分号结尾  必须是private   默认调用此构造方法，在调用枚举对象之前创建枚举对象
			System.out.println("first");
		}
		private WeekDay(int day){ 
			System.out.println("second");
		}
	}
	
	/**
	 * 含抽象方法的枚举
	 * @author Zack
	 * 枚举只有一个成员时，就可以作为一种单例的实现方式
	 */
	public enum TrafficLamp{
		RED(30) {  //子类调用父类的构造方法
			@Override
			public TrafficLamp nextLamp() {
				// TODO Auto-generated method stub
				return GREEN;
			}
		},
		GREEN(30) {
			@Override
			public TrafficLamp nextLamp() {
				// TODO Auto-generated method stub
				return YELLOW;
			}
		},
		YELLOW(5) {
			@Override
			public TrafficLamp nextLamp() {
				// TODO Auto-generated method stub
				return RED;
			}
		};
		public abstract TrafficLamp nextLamp();
		private int time;  //成员
		private TrafficLamp(int time){  //构造方法
			this.time = time;
		}
	}

}
