package com.study.utils.collections;



/**
 * 静态导入：StaticImport  导入的是类中所有的静态成员
 * 当类名重名时，需要指定具体的包名
 * 当方法重名时，需要指定具体所属对象或者类
 *
 *import java.lang.System.*
 *
 * packa/Demo.class
 * packb/Demo.class
 * 
 * import packa.*
 * import packb.*
 * 
 * new Packa.Demo()
 * new Packb.Demo()
 */

import static java.lang.System.*;
import java.util.Arrays;
import static java.util.Arrays.*;   //导入的是Arrays中所有的静态成员方法
public class StaticImportTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] arr = {2,4,1,4,3};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));*/
		int[] arr = {2,4,1,4,3};
		sort(arr);
		//System.out.println(toString(arr)); //与Object中的toString重名
		out.println(Arrays.toString(arr));
		
	}

}
