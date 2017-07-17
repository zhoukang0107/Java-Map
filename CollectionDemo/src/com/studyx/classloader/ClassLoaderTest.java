package com.studyx.classloader;
/**
 * 类加载器
 * 1、Java虚拟机中可以安装多个类加载器，系统默认三个主要类加载器，每个
 * 类负责加载特定位置的类：BootStrap,ExtClassLoader,AppClassLoader
 * 2、类加载器也是java类，因此类加载器本身也要被类加载器加载，显然必须有第一个类
 * 加载器不是java类，这正是BootStrap
 * 3、Java虚拟机中的所有的类加载器采用具有父子关系的树形结构来进行组织，在实例化每个类加载器对象时，
 * 需要为其指定一个父级类装载器对象或者采用系统类装载器为其父级类加载器
 * 
 * 类加载器之间父子关系和管辖范围图
 *   BootStrap  --------->  JRE/lib/rt.jar
 *       ^
 *       |
 * ExtClassLoader ------->  JRE/lib/ext/*.jar
 *       ^
 *       |
 * APPClassLoader ------->  CLASSPATH指定的所有jar或目录
 *（System classLoader)
 *       ^
 *       |
 * MyClassLoader / ItCastClassLoader --> 自己指定特殊目录
 *   
 * 
 * 类加载器的委托机制
 * 当java虚拟机要加载一个类时，到底要派出哪个类加载器去加载呢？
 * 1、首先当前线程的类加载器去加载线程中的第一个类。
 * 2、如果A类中引用了B类，java虚拟机将使用加载A类的加载器来加载B类
 * 3、还可以直接调用ClassLoader.loadClass()方法来指定某个类加载器去加载某个类
 * 每个类加载器加载类时，又先委托给其上级类加载器
 * 1、当所有祖宗类加载器偶没有加载到类，回到发起者类加载器，还加载不了，则抛出ClassNotFoundException，
 * 不是再去找发起者类加载器的儿子，因为没有getChild方法，即使有，那么多儿子找哪一个呢？
 * 2、对着类加载器的层次图和委托加载原理，解释先前将ClassLoaderTest输出成jre/lib/ext目录下的itcast.jar包后，运行结果为ExtClassLoader的原因
 * 
 * 
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());  //sun.misc.Launcher$AppClassLoader
		System.out.println(System.class.getClassLoader());  //null   Bootrap
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
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

}
