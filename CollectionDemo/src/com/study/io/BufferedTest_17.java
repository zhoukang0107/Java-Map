package com.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 装饰设计模式
 * 当想要对已有的对象进行功能增强时，
 * 可以定义类，将已有对象传入，基于已有的功能，并提供加强功能
 * 那么自定义的该类称为装饰类
 * 
 * 
 * 装饰类通常会通过构造方法接受被装饰的对象
 * 并基于被装饰对象的功能提供更强的功能
 * 
 * 
 *
 */


class Persion{
	public void eat(){
		System.out.println("吃饭");
	}
}

class SuperPersion{
	private Persion p;
	SuperPersion(Persion p ){
		this.p = p;
	}
	
	public void superEat(){
		System.out.println("开胃酒");
		p.eat();
		System.out.println("甜点");
		System.out.println("来一根");
	}
}

//通常Persion和SuperPersion有共同父类

public class BufferedTest_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Persion p = new Persion();
		p.eat();
		
		SuperPersion sp = new SuperPersion(p);
		sp.superEat();
	}

}
