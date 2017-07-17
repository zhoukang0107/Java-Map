package com.studyx.javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.studyx.ref.Point;

/**
 * Java：特殊的java类
 * 
 * 
 * 
 *
 */
public class JavaBeanTest {

	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		// TODO Auto-generated method stub

		Point pt = new Point(0, 0);
		String propertyName = "x";
		//"x"->"X"->"getX"->MethodGetX->
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, pt.getClass());
		Method mx = pd.getReadMethod();
		Object retVal = mx.invoke(pt);
		System.out.println(retVal);
	
		Method mwx = pd.getWriteMethod();
		mwx.invoke(pt, 7);
		System.out.println(pt.getX());
		
		BeanInfo beaninfo = Introspector.getBeanInfo(pt.getClass());
		PropertyDescriptor[] pds = beaninfo.getPropertyDescriptors();
		for (PropertyDescriptor pdd: pds){
			if (pdd.getName().equals(propertyName)){
				System.out.println(pdd.getReadMethod().invoke(pt));
				break;
			}
		}
		
		//beanutils  还可以操作map
		System.out.println(BeanUtils.getProperty(pt, "x"));
		BeanUtils.setProperty(pt, "x", "9");
		System.out.println(BeanUtils.getProperty(pt, "x"));
		
		BeanUtils.setProperty(pt, "birthDay.time", 1234);
		System.out.println(BeanUtils.getProperty(pt, "birthDay.time"));
		
		//PropertyUtils属性类型必须对应
		PropertyUtils.setProperty(pt, "x", 12);
		System.out.println(PropertyUtils.getProperty(pt, "x"));
	}

}
