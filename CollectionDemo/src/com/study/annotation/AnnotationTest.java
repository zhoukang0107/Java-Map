package com.study.annotation;

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
