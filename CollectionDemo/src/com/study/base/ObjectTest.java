package com.study.base;
/**
 * Object类：
 * 是所有对象的直接或间接父类，该类中定义了所有对象都具备的功能
 * 
 * equals:java认为所有对象都具备比较性，都可以进行比较
 * 默认比较的是两个对象的地址
 * 
 * Object类中已经提供了对对象是否相同的比较函数。
 * 如果自定义类中也有比较相同的功能，没有必要重新定义
 * 只要沿袭父类中的功能，建立自己特有比较内容即可，这就是覆盖
 * 
 * toString:所有对象都可以变成字符串打印  所属类@对象hashCode()
 * 
 * 
 * hashCode:
 * 
 * 
 * 
 * 
 * A.class 
 * B.class
 * 这些class文件都有名称
 * 这些文件都有构造函数
 * 一般方法
 * 
 * Class来描述这些class文件      类文件对象
 * getName()  //获取class文件的名称
 */

class Demo{// extends Object{ //隐式包含
	protected int num;
	public Demo(int num) {
		super();
		this.num = num;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Demo){
			return this.num==((Demo) obj).num;
		}
		return false;
	}
}

class SubDemo extends Demo{

	public SubDemo(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "demo:"
				+ ""+num;
	}
}

public class ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Demo d1 = new Demo();
		Demo d2 = new Demo();
		Demo d3 = d1;
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));
		System.out.println(d1==d3);*/
		
		Demo d1 = new Demo(4);
		Demo d2 = new Demo(4);
		System.out.println(d1.equals(d2));
		System.out.println(d1.toString());
		System.out.println(d1.getClass().getName()+"@"+Integer.toHexString(d1.hashCode()));
		
		SubDemo sd1 = new SubDemo(4);
		System.out.println(sd1.toString());
	}

}
