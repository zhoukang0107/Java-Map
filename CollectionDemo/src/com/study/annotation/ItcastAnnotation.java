package com.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention
 * 注解的生命周期：
 * RetentionPolicy.SOURCE
 * 源文件：Javac可能将源文件中的注解去掉
 * RetentionPolicy.CLASS
 * class文件：类加载器可能将class中的注解去掉
 * RetentionPolicy.RUNTIME
 * 内存中的字节码
 *
 * 默认保留在CLASS中
 * 
 * 
 * @Target({ElementType.METHOD,ElementType.TYPE})
 * 定义注解可以作用的对象
 * 
 * 
 * 注解的属性：
 * 
 * 
 * 
 * 
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ItcastAnnotation {
	//定义属性
	String color() default "blue";  //color属性设置默认值
	String value();
	int[] arrayAttr() default {2,3,4};
	ElementType getElementType() default ElementType.METHOD;  //枚举类型属性
	MetaAnnotation annotationAttr() default @MetaAnnotation("value");
}
