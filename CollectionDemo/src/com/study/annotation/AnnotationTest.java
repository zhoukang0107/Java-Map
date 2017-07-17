package com.study.annotation;
/**
 * 注解：
 * @Override   覆盖父类方法  如果覆盖的方法没有覆盖父类方法编译器报错
 * @SuppressWarnings   
 * @Deprecated    此注解表明该函数已过期，不建议使用
 * 
 * 
 * 注解相当于一种标记，在程序中加了注解就等于为程序打上了某种标记，没加，则等于没有某种标记，
 * 以后，javac编译器，开发工具和其他程序可以用反射来了解你的类以及各种元素上有何种标记，看你
 * 有什么标记就去干相应的事，标记可以加在包，类，方法，方法的参数以及局部变量上
 *
 * 
 * 注解类
 * 引用了注解类的类
 * 对应用了注解类的类进行反射操作的类
 * 
 * 
 * 
 */

@ItcastAnnotation(annotationAttr=@MetaAnnotation("fix"),color="red",value="abc",arrayAttr={1,2,3})
public class AnnotationTest {

	@ItcastAnnotation("abb")   //color已经有了默认值，可以不用写"value="只给value属性设置
	//@SuppressWarnings("deprecated")   //如果只有value属性需要设值时，可以不写"value="
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (AnnotationTest.class.isAnnotationPresent(ItcastAnnotation.class)){
			ItcastAnnotation annotation = AnnotationTest.class.getAnnotation(ItcastAnnotation.class);
			System.out.println(annotation.color());
			System.out.println(annotation.value());
			System.out.println(annotation.arrayAttr().length);
			System.out.println(annotation.annotationAttr().value());
		}
		
		sayHell();
		
	}
	
	/**
	 * @Deprecated
	 * 此注解表明该函数已过期，不建议使用
	 */
	@ItcastAnnotation(annotationAttr=@MetaAnnotation("fix"),color="red",value="abc",arrayAttr=2)   //如果数组中属性只有一个值，那么可以省略大括号
	@Deprecated
	public static void sayHell(){
		
	}

}
