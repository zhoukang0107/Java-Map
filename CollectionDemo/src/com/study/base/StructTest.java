package com.study.base;
/**
 * 对象初始化过程：
 * Person p = new Person("zhangsan", 28);
 * 1、因为new用到了Person.class文件,所以会先找到Person.class文件并加载到内存中
 * 2、执行该类的static代码块，如果有的话，给Person.class类进行初始化
 * 3、在堆内存中开辟空间，分配内存地址
 * 4、在堆内存中建立对象的特有属性，并进行默认初始化（null、0等）
 * 5、对属性进行显式初始化
 * 6、对对象进行构造代码块初始化
 * 7、对对象进行对应的构造函数初始化
 * 8、将内存地址赋给栈中的p变量
 *
 */

class Person{
	private String name;
	private int age;
	private String addr = "beijin";  //显式初始化
	private int id;
	
	{//构造代码块
		id = 1;
		System.out.println("构造代码块:"+"name:"+name+" age:"+age+" addr:"+addr+" id:"+id);
	}
	public Person(String name, int age) {  //构造函数
		super();
		this.name = name;
		this.age = age;
		System.out.println("构造函数:"+"name:"+name+" age:"+age+" addr:"+addr+" id:"+id);
	}
}

public class StructTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("zhangsan", 28);
	}

}
