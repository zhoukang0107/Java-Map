package com.study.base;
/**
 * 需求：数据库操作
 * 数据时：用户信息
 * 1、链接数据库  JDBC Hibernate
 * 2、操作数据库
 *    c create r read u update d delete
 * 3、关闭数据库链接
 * 
 * 
 * 
 * 
 * class UserInfoByJDBC{
 * 		public void add(User user){
 * 			1、JDBC链接数据库
 * 			2、使用sql添加数据
 * 			3、关闭连接
 * 		}
 * 
 * 		public void delete(User user){
 * 			1、JDBC链接数据库
 * 			2、使用sql语句删除数据
 * 			3、关闭连接	
 * 		}
 * }
 * 
 * class UserInfoByHibernate{
 * 		public void add(User user){
 * 			1、Hibernate链接数据库
 * 			2、使用sql添加数据
 * 			3、关闭连接
 * 		}
 * 
 * 		public void delete(User user){
 * 			1、Hibernate链接数据库
 * 			2、使用sql语句删除数据
 * 			3、关闭连接	
 * 		}
 * }
 * 
 * 		*
 * 		*
 * 		*
 * 		V
 * 
 * Interface UserInfoDao{
 * 		public void add(User user);
 * 		public void delete(User user)
 * }
 * 
 * class UserInfoByJDBC implements UserInfoDao{
 * 		public void add(User user){
 * 			1、JDBC链接数据库
 * 			2、使用sql添加数据
 * 			3、关闭连接
 * 		}
 * 
 * 		public void delete(User user){
 * 			1、JDBC链接数据库
 * 			2、使用sql语句删除数据
 * 			3、关闭连接	
 * 		}
 * }
 * 
 * class UserInfoByHibernate implements UserInfoDao{
 * 		public void add(User user){
 * 			1、Hibernate链接数据库
 * 			2、使用sql添加数据
 * 			3、关闭连接
 * 		}
 * 
 * 		public void delete(User user){
 * 			1、Hibernate链接数据库
 * 			2、使用sql语句删除数据
 * 			3、关闭连接	
 * 		}
 * }
 * 
 * class DBOperate{
 * 		public static void main(String[] args){
 * 			//UserInfoByJDBC ui = new UserInfoByJDBC();
 * 			//ui.add(user);
 * 			UserInfoDao ui = new UserInfoByHibernate();
 * 			ui.add(user);
 * 		}
 * 
 * 		
 * 
 * 		
 * 
 * 
 * 
 * 
 */

import static java.lang.System.*;

class MainBoard{
	public void run(){
		out.println("MainBoard run");
	}
}



public class PolymorphismTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainBoard m = new MainBoard();
		m.run();
		
	}
}
