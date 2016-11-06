package com.study.base.jpackage;
/**
 * package:
 * 1、对类文件进行分类管理
 * 2、给类提供多层次命名空间
 * 3、写在程序文件的第一行
 * 4、类名的全名称是：类名.类名
 * 5、包也是一种封装形式
 * 
 * javac -d . PackageDemo.java  //自动生成包名文件夹  "."当前目录
 * javac -d C:\myclass PackageDemo.java    将生成的类以及包放在C盘的myclass目录下
 * 
 * 包的出现可以将Java的运行文件和源文件想分离
 * set classpath-c:\myclass
 * 
 * 
 * 不同包中的类该如何访问？
 * 1、类名的全名是：包名.类名
 * 2、需要设置classpath告诉jvm到哪里找指定的包（set classpath-c:\myclass）
 * 3、有了包，范围变大，一个包中的类要被访问，必须要有足够大的权限，所以被访问的类要被public修饰
 * 4、类公有后，被访问的成员也要公有才可以被访问
 * 
 * 
 * 
 * 总结：
 *      包与包之间进行访问，被访问的包中的类以及类中的成员，需要public修饰
 *      不同包中的子类，可以直接访问父类中被protected权限修饰的成员
 *      
 * 包与包之间可以直接使用的权限有两种：public和protected
 * 
 *              public       protected       default    private
 * 同一个类中            可以                             可以                                可以                  可以
 * 同一个包中            可以                             可以                                可以                不可以 
 * 子类                           可以                             可以                             不可以              不可以
 * 不同包中                 可以                           不可以                          不可以              不可以  
 *      
 * 一个文件中只能有一个public类，且与文件名相同
 * 
 * 
 * 
 * 为了简化类名的书写，使用一个关键字：import简化类名书写
 * 建议不要写通配符*，需要用到包中的哪个类就导入哪个类
 * 
 * 建议定义包名不要重复，可以使用url来完成定义，因为url是唯一的 
 * com.malalaoshi.demo
 */

public class PackageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
