package com.study.base;
/**
 * 抽象类
 * 当多个类中出现相同功能，但功能的主体不同，
 * 这时可以进行向上抽取，这时只抽取功能定义而不抽取功能主体
 * 
 * 特点：
 * 1、抽象方法一定定义在抽象类中，抽象类中可以没有抽象方法
 * 2、抽象方法和抽象类都必须被abstract关键字修饰
 * 3、抽象类不可以用new创建对象，因为调用抽象方法没有意义
 * 4、抽象类中的方法要被使用，必须要被子类复写所有的抽象方法后，建立子类对象调用
 *    如果子类只覆盖了部分抽象方法，那么该子类还是一个抽象类
 * 
 * 抽象类与一般类没有太大不同，
 * 该如何你描述事物就如何描述事物，只不过事物中出现了一些看不懂的东西，这些不确定的部分，也是该事物的功能
 * 需要明确出现，但无法定义主体，通过抽象方法来表示
 * 
 * 
 * 抽象类比一般类多个抽象函数，就是在类中可以定义抽象方法，抽象类中可以不定义抽象方法
 * 抽象类不可以实例化
 * 
 * 特殊：抽象类中可以不定义抽象方法，这样做仅仅是不让该类建立对象
 * 
 */


import static java.lang.System.*;


abstract class AbsStudent{
	//void study(){}//方法体实际是没有意义的,故使用关键字abstract,不进行定义方法体
	abstract void study();
	void eat(){
		out.println("eat");
	}
}

class BaseStudent extends AbsStudent{
	void study(){
		out.println("BaseStudent");
	}
}

class AdvStudent extends AbsStudent{
	void study(){
		out.println("AdvStudent");
	}
}

public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new AbsStudent();  //抽象类不可创建实例
		new BaseStudent();
	}

}
