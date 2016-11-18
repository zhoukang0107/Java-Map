package com.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 为了读取许多不同的数据，定义许多相应的类
 * MyTextReader
 * MyMediaReader
 * 将相应的类向上提取抽象，出现Reader
 * 
 * 
 * 
 * Reader  //叫做专门用于读取数据的类
 *    |--MyTextReader
 *       |--MyBufferedTextReader
 *    |--MyMediaReader
 *       |--MyBufferedMediaReader
 *    |--MyDataReader
 *       |--MyBufferedDataReader
 * 
 * class MyBufferedReader{
 *    
 *     MyBufferedReader(MyBufferedTextReader reader){
 *    
 *     }
 *     
 *     MyBufferedReader(MyBufferedMediaReader reader){
 *    
 *     }
 *     
 *     MyBufferedReader(MyBufferedDataReader reader){
 *    
 *     }
 * }
 * 上面这个类扩展性很差，
 * 找到其参数的共同类型，通过多态的形式，可以提高扩展性
 * class MyBufferedReader extends Reader{
 *     private Reader reader;
 *     MyBufferedReader(Reader reader){
 *         this.reader = reader;
 *     }
 * 
 * 
 * }
 *    
 * Reader  //专门用于读取数据的类
 *     |--MyTextReader
 *     |--MyDediaReader
 *     |--MyDataReader
 *     |--MyBufferedReader
 * 
 * 装饰类比继承更灵活，避免了继承体系臃肿
 * 而且降低了类与类之间的关系
 * 
 * 装饰类因为增强已有对象，具备了和已有对象相同的功能，只不过提供了更强的功能
 * 所以装饰类和被装饰类通常是属于一个体系的
 * 
 * 
 * 
 * 
 * 
 * 
 * 
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


/*class Persion{
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
}*/

//通常Persion和SuperPersion有共同父类

public class BufferedTest_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*Persion p = new Persion();
		p.eat();
		
		SuperPersion sp = new SuperPersion(p);
		sp.superEat();*/
	}

}
