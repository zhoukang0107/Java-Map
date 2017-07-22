package com.studyx.proxy;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {

	long beginTime = 0;
	@Override
	public void beforeMethod(Method method) {
		// TODO Auto-generated method stub
		beginTime = System.currentTimeMillis();
		System.out.println(method.getName()+" is begin running!");
	}

	@Override
	public void afterMethod(Method method) {
		// TODO Auto-generated method stub
		long endTime = System.currentTimeMillis();
		System.out.println(method.getName()+" is end running!");
		System.out.println(method.getName()+" running time:"+(endTime-beginTime));
	}

	

}
