package com.studyx.ref;

import java.util.Date;

public class Point {
	public int x;
	private int y;
	Date birthDay = new Date(); 
	public String str1 = "ball";
	public String str2 = "basketball";
	public String str3 = "itcast";
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", str1=" + str1 + ", str2=" + str2 + ", str3=" + str3 + "]";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	

}
