package com.studyx.classloader;
/**
 * ¿‡º”‘ÿ∆˜
 * 
 * 
 *
 */
public class ClassLoaderTest2 extends ClassLoader{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ClassLoaderTest2.class.getClassLoader().getClass().getName());  //sun.misc.Launcher$AppClassLoader
		System.out.println(System.class.getClassLoader());  //null   Bootrap
		ClassLoader classLoader = ClassLoaderTest2.class.getClassLoader();
		while(classLoader!=null){
			System.out.println(classLoader.getClass().getName());
			classLoader = classLoader.getParent();
		}
		System.out.println(classLoader);
		/**
		 * sun.misc.Launcher$AppClassLoader
		 * sun.misc.Launcher$ExtClassLoader
		 * null
		 */
		
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.findClass(name);
	}

}
