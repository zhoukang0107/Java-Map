package com.study.java8_lambda;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

/**
 * 事件中的匿名内部类
 * 活动事件AcyionListenner接口只有一个抽象方法
 * public void actionPerformed(ActionEvent e)
 *
 */


public class LambdaTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}
	
	public static void test1(){
		Frame f = new Frame("我的窗体");
		//窗体定义，x轴，y轴，宽度，高度
		f.setBounds(200,100,500,400);
		//取消布局管理器
		f.setLayout(null);
		f.setVisible(true);
		Button btn = new Button("lambda测试");
		btn.setBounds(100, 50, 100, 30);
		f.add(btn);
		/*btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("按钮点击了");
			}
		});*/
		btn.addActionListener((e)->{;
		    System.out.println("按钮点击了");
		});
	}
	

}

