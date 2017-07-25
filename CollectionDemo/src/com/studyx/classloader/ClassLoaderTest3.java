package com.studyx.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader classLoader = ClassLoaderTest3.class.getClassLoader();
		StringBuilder sb = new StringBuilder();
		while (classLoader!=null){
            sb.append(classLoader.getClass().getName()).append("\n");
            URL[] urls = ((URLClassLoader)classLoader).getURLs();
            for (URL url:urls){
                sb.append(url.getPath()).append("\n");
            }
            sb.append("\n");
            classLoader = classLoader.getParent();
        }
		
		
		//BootstrapClassLoader
		try {
			Class launcherClzss = Class.forName("sun.misc.Launcher");
			Method method = launcherClzss.getDeclaredMethod("getBootstrapClassPath", null);
			if (method!=null){
				method.setAccessible(true);
				Object obj = method.invoke(null, null);
				if (obj!=null){
					Method methodURL = obj.getClass().getDeclaredMethod("getURLs", null);
					if (methodURL!=null){
						methodURL.setAccessible(true);
						URL[] urls = (URL[]) methodURL.invoke(obj, null);
						for (URL url:urls){
			                sb.append(url.getPath()).append("\n");
			            }
					}
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
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
		System.out.println(sb.toString());
		
	}

}
