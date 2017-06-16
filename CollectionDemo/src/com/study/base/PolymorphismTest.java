package com.study.base;
/**
 * 多态：
 * 可以理解为事物存在的多种体现形态
 * 1、多态的基本体现
 *    父类的引用指向了自己的子类对象
 *    父类的引用也可以接受自己的子类对象
 * 2、多态的前提
 *    必须是类与类之间要有关系，要么继承，要么实现
 *    通常还有一个前提，存在覆盖
 * 3、多态的好处
 *    多态的出现提高了程序的扩展性
 * 4、多态的弊端
 *    提高了扩展性，但是只能使用父类的引用访问子类中成员
 * 4、多态的应用
 * 
 * 
 * 多态成员函数特点(非静态)：
 * 在编译时期，参阅引用型变量所属的类中是否有调用的方法，如果有，编译通过，如果没有编译失败
 * 在运行时期，参阅对象所属的类中是否有调用的方法
 * 
 * 
 * 简单总结：成员函数在多态调用时，编译看左边，运行看右边
 * 
 * 
 * 在多态中成员变量的特别：（静态函数）
 * 无论编译和运行，都参考左边（引用型变量所属的）
 * 
 * 在多态中，静态成员函数的特别，无论编译或运行都参考左边
 *
 */

import static java.lang.System.*;


abstract class Animal{
	int id= 5;
	public abstract void eat();
	
	public static void catchMouse1(){
		out.println("Animal");
	}
}

class Cat extends Animal{
	int id= 8;
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		out.println("吃老鼠"+id);
	}
	
	public void catchMouse(){
		out.println("抓老鼠");
	}
	
	public static void catchMouse1(){
		out.println("Cat");
	}
}

class Dog extends Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		out.println("吃骨头");
	}
	
	public void shout(){
		out.println("狗叫");
	}
}

class Pig extends Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		out.println("猪吃猪饲料");
	}
	
	public void sleep(){
		out.println("猪睡觉");
	}
	
}

public class PolymorphismTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Cat c= new Cat();
		functionCat(c);
		Dog d = new Dog();
		functionDog(d);
		Pig p= new Pig();
		functionPig(p);*/
		
		Animal c= new Cat();  //类型提升
		c.eat();
		//如果想要调用cat的特殊方法如何操作？
		//强制将父类的引用转换成子类类型,向下转型
		//千万不要出现将父类的对象转换为子类类型
		//我们能转换的是父类引用指向子类对象时，该引用是可以被提升的，也可以被强制转换
		//自始至终都是子类对象在转换
		Cat cat = (Cat)c;
		cat.catchMouse();
		functionAnimal(c);
		Animal d = new Dog();
		functionAnimal(d);
		Animal p= new Pig();
		functionAnimal(p);
		
		Animal c1= new Cat();
		out.println(c1.id);
		c1.eat();
		c1.catchMouse1();
		Cat c11= (Cat)c1;
		out.println(c11.id);
		c11.eat();
		c11.catchMouse1();
		Cat c2= new Cat();
		out.println(c2.id);
		c2.eat();
		c2.catchMouse1();
		
	}
	
	public static void functionAnimal(Animal a){
		if (a instanceof Cat){
			((Cat)a).catchMouse();
		}else if (a instanceof Dog){
			((Dog)a).shout();
		}else{
			((Pig)a).sleep();
		}
		a.eat();
	}
	
	/*public static void functionCat(Cat c){
		c.eat();
	}
	
	public static void functionDog(Dog d){
		d.eat();
	}
	

	public static void functionPig(Pig p){
		p.eat();
	}*/
}
