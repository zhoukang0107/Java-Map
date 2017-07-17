package com.studyx.ref;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.print.attribute.HashAttributeSet;

/**
 * 字节码  Class类
 * 
 * 得到一个类的字节码：
 * Class cls1 = Data.class;
 * Class cls2 = Class.forName("java.lang.String");
 * Class cls3 = data.getClass();
 *
 * 九个预定义的Class示例对象
 * 8个基本数据类型+void.class
 * 
 * 在源程序中出现的类型都有各自的Class示例对象，例如：int[].class;void.class
 * 
 * 
 * 反射：
 * 反射就是把java类中的各种成分映射成相应的java类
 * Medthod,Contructor，Package,Field
 * 
 * Contructor:代表某个类的一个构造方法
 * 
 * 
 * 框架与工具类
 * 框架调用用户的代码，工具类是被用户调用的
 * 
 * 
 * 
 */

public class RefTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, IOException {
		// TODO Auto-generated method stub
		String str = "abc";
		Class cls1 = str.getClass();
		Class cls2 = Class.forName("java.lang.String");
		Class cls3 = String.class;
		System.out.println(cls1==cls2);                  //true
		System.out.println(cls1==cls3);                  //true
		System.out.println(cls1.isPrimitive());          //false
		System.out.println(int.class.isPrimitive());     //true  原始类型
		System.out.println(int.class==Integer.class);    //false
		System.out.println(int.class==Integer.TYPE);     //true
		System.out.println(int[].class.isPrimitive());   //false
		System.out.println(int[].class.isArray());       //true
	
		//new STring(new StringBuffer("abc"))   构造函数创建对象
		//String.class.getConstructor(StringBuffer.class,int.class);
		String str1 = String.class.getConstructor(StringBuffer.class).newInstance(new StringBuffer("abc"));
		System.out.println(str1);
		
		//Class.newInstance创建对象  调用不带参数的构造方法
		String str2 = String.class.newInstance();
		System.out.println(str2);
		
		//Field
		Point pt1 = new Point(2,3);
		Field filedx = pt1.getClass().getField("x");  //
		System.out.println(filedx.get(pt1));
		//Field filedY = pt1.getClass().getField("y");  //此方法不能访问私有变量
		//System.out.println(filedY.get(pt1));             //此方法不能访问私有变量
		Field filedY = pt1.getClass().getDeclaredField("y"); 
		filedY.setAccessible(true);  //暴力反射
		System.out.println(filedY.get(pt1));
		System.out.println(pt1);
		changeStringValue(pt1);
		System.out.println(pt1);
		
		//Method
		String strM = "abc";
		Method method = String.class.getMethod("charAt", int.class);
		System.out.println(method.invoke(strM, 1));   //如果第一个参数为null，则这个方法是静态的
		
		Method mainMethod = Class.forName("com.studyx.ref.MyMain").getMethod("main", String[].class);
		//mainMethod.invoke(null, new String[]{"aaa","bbb","ccc"});  //应该是为了兼容1.4，此时会将数据中的元素展开
		
		mainMethod.invoke(null, new Object[]{new String[]{"aaa","bbb","ccc"}});  //应该是为了兼容1.4，此时会将数据中的元素展开
		mainMethod.invoke(null, (Object)new String[]{"aaa","bbb","ccc"});  //应该是为了兼容1.4，此时会将数据中的元素展开

		//数：具有相同类型和相同维度的数组，字节码相同
		System.out.println("数组");
		int[] a1 = new int[]{1,2,3};
		int[] a2 = new int[4];
		int[][] a3 = new int[3][4];
		String[] a4 = new String[]{"asd","zxcv","qwee"};
		System.out.println(a1.getClass()==a2.getClass());   //true
		//System.out.println(a1.getClass()==a3.getClass());   //error
		//System.out.println(a1.getClass()==a4.getClass());   //error
		System.out.println(a1.getClass().getName());  //[I
		System.out.println(a2.getClass().getName());  //[I
		System.out.println(a3.getClass().getName());  //[[I
		System.out.println(a4.getClass().getName());  //[Ljava.lang.String;
		System.out.println(a1.getClass().getSuperclass().getName());  //java.lang.Object
		System.out.println(a3.getClass().getSuperclass().getName());  //java.lang.Object
		System.out.println(a4.getClass().getSuperclass().getName());  //java.lang.Object
		
		Object aObj1 = a1;
		Object aObj2 = a4;
		//Object[] aObj3 = a1;
		Object[] aObj3 = a3;
		Object[] aObj4 = a4;
		
		Object aObj5 = new int[6];
		System.out.println(aObj5.getClass().getName());  //[I
		System.out.println(aObj5.getClass()==Integer.class);   //false
		
		System.out.println(a1);
		System.out.println(a4);
		
		System.out.println(Arrays.asList(a1));  //[[I@70dea4e]  JDK 1.5可变参数中，将整个数组当做了一个对象
		System.out.println(Arrays.asList(a4));  //[asd, zxcv, qwee]
		
		
		printObject(new Object());
		
		
		loadFrame();
		
	}

	private static void loadFrame() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		//InputStream is = new FileInputStream("config.properties");
		//InputStream is = RefTest.class.getClassLoader().getResourceAsStream("com/studyx/ref/config.properties")
		InputStream is = RefTest.class.getResourceAsStream("config.properties");
		//InputStream is = RefTest.class.getResourceAsStream("res/config.properties");
		//InputStream is = RefTest.class.getResourceAsStream("com/studyx/ref/res/config.properties");

		Properties config = new Properties();
		config.load(is);
		is.close();
		String className = config.getProperty("className");
		Class cls = Class.forName(className);
		Collection collection = (Collection) cls.newInstance();
		System.out.println(cls.getName());
	}

	//没有办法得到数组中元素的类型
	private static void printObject(Object object) {
		// TODO Auto-generated method stub
		Class cls = object.getClass();
		if (cls.isArray()){
			
		}else{
			
		}
	}

	private static void changeStringValue(Point pt) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Field[] fields = pt.getClass().getFields();
		for (Field field : fields){
			if (field.getType()==String.class){
				String strValue = (String) field.get(pt);
				String newValue = strValue.replace('b', '#');
			    field.set(pt, newValue);
			    
			}
		}
	}

}


class MyMain{
	public static void main(String[] args) {
		for (String str : args){
			System.out.println(str);
			
		}
	}
}
