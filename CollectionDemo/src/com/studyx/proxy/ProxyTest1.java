package com.studyx.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 代理
 * jvm动态生成类
 * 
 * 
 * 
 *
 */
public class ProxyTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//参数ClassLoader通常指定为对应接口相同的类加载器
		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(clazzProxy1.getName());
		
		System.out.println("**********constructor list**********");
		Constructor[] constructors = clazzProxy1.getConstructors();
		for (Constructor constructor:constructors){
			StringBuilder sb = new StringBuilder();
			sb.append(constructor.getName());
			sb.append("(");
			
			Class[] clazzParams = constructor.getParameterTypes();
			for (Class clazzParam: clazzParams){
				sb.append(clazzParam.getName()).append(",");
			}
			if (clazzParams.length!=0){
				sb.deleteCharAt(sb.length()-1);
			}
			
			sb.append(")");
			System.out.println(sb.toString());
		}
		
		
		System.out.println("**********method list**********");
		Method[] methods = clazzProxy1.getMethods();
		for (Method method:methods){
			StringBuilder sb = new StringBuilder();
			sb.append(method.getName());
			sb.append("(");
			
			Class[] clazzParams = method.getParameterTypes();
			for (Class clazzParam: clazzParams){
				sb.append(clazzParam.getName()).append(",");
			}
			if (clazzParams.length!=0){
				sb.deleteCharAt(sb.length()-1);
			}
			
			sb.append(")");
			System.out.println(sb.toString());
		}
		
		System.out.println("**********create instance**********");
		try {
			Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
			Collection proxy1 = (Collection) constructor.newInstance(new MyInvocationHandler1());
			System.out.println(proxy1.toString());
			proxy1.clear();
			//proxy1.size();  //java.lang.NullPointerException  at com.sun.proxy.$Proxy0.size(Unknown Source)
			
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*final ArrayList target = new ArrayList();
		Collection collection = (Collection)Proxy.newProxyInstance(
				Collection.class.getClassLoader(),
				new Class[]{Collection.class},
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						
						long beginTime = System.currentTimeMillis();
						//调用目标方法
						Object retVal = method.invoke(target, args);
						System.out.println(method.getName()+" running time:"+(System.currentTimeMillis()-beginTime));
						return retVal;
					}
				});*/
		System.out.println("**********create instance**********");
		final ArrayList target = new ArrayList();
		Collection collection = (Collection) getProxy(target, new MyAdvice());
		
		//对于Object中继承实现的方法，除了hashCode,toString,equals三个方法委托给InvocationHandler代理，其他的自己实现，不进行委托
		collection.add("aaaa");
		collection.add("bbbb");
		collection.add("cccc");
		collection.add("dddd");
		System.out.println(collection.size());
		
		
		
	}
	private static Object getProxy(final Object target, Advice advice) {
		Object obj = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						advice.beforeMethod(method);
						//调用目标方法
						Object retVal = method.invoke(target, args);
						advice.afterMethod(method);
						return retVal;
					}
				});
		return obj;
	}
	static class  MyInvocationHandler1 implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
