package com.study.io;

import java.io.*;

/**
 * 读取键盘录入
 * System.out:对应标准的输出设备：控制台
 * System.in:对应标准的输入设备：键盘
 * 
 * 需求：通过键盘录入数据，当录入一行数据后就将该行数据进行打印
 * 如果录入的数据是over,那么停止录入
 * 
 * 通过刚才的键盘录入一行数据并打印其大写，发现其实就是读一行数据的原理
 * 也就是readLine方法
 * 
 * 能不能直接使用readLine方法来完成键盘录入的一行数据的读取呢？
 * readLine方法是BufferedReader类中的方法
 * 而键盘录入的read方法是字节流InputStream的方法
 * 那么能不能将字节流转换成字符流，再使用字符流缓存区readLine方法
 * 
 * 1、
 * 源：键盘录入
 * 目的：控制台
 * 2、
 * 需求：
 * 把键盘录入的数据存储到一个文件中
 * 源：键盘
 * 目的：文件
 * 3、
 * 需求：想要将一个文件的数据打印在控制台上
 * 源：文件
 * 目的：控制台
 * 
 * 流操作的基本规律：
 * 最痛苦的就是流对象有很多，不知道该用哪一个。
 * 
 * 通过三个明确来完成
 * 1、明确源和目的
 *    源：输入流     InputStream Reader
 *    目的：输出流  OutputStream Writer
 * 2、明确操作的数据是否是纯文本
 *    是：字符流
 *    不是：字节流
 * 3、当体系明确后，在明确要使用哪个具体的对象
 *    通过设备来进行区分
 *    源设备：内存，硬盘，键盘
 *    目的设备：内存，硬盘，控制台
 *    
 *    
 * 1、将一个文本文件的数据存储到另一个文件中，复制文件
 *     源：使用读取流InputStream Reader
 *        是不是操作文本文件
 *        是：这时就可以选择Reader
 *        这样体系就明确了
 *        
 *        接下来明确要使用该体系的哪个对象
 *        明确设备：硬盘上一个文件
 *        Reader体系中可以操作文件的对象是FileReader
 *        
 *        是否需要提高效率：是 加入Reader体系中的缓存区BufferedReader
 *        
 *      FileReader fr = new FileReader("a.txt") 
 *      BufferedReader br = new BufferedReader(fr); 
 *        
 *     目的： OutputStream Writer
 *     是否是纯文件
 *     是，Writer
 *     设备：硬盘上的一个文件
 *     Writer体系中可以操作文件的对象FileWriter
 *     是否需要提高效率，是 加入Writer体系中的缓冲区BufferedWriter
 *     FileWriter fw = new FileWriter("b.txt");
 *     BufferedWriter bw = new BufferedWriter(fw);
 *    
 * 练习：将一个图片文件存储到另一个文件中，复制文件，要按照以上格式自己完成三个明确
 * 
 * 2、需求：将键盘录入的数据保存到一个文件中
 *     这个需求中有源和目的都存在
 *     那么分别分析
 *   源：InputStream  Reader
 *     是不是纯文本？ 是  Reader
 *     设备：键盘 对应的对象是System.in
 *     不是选择Reader吗？System.in对应的不是字节流吗？
 *     为了操作键盘的文本数据方便，转成字符流，按照字符串操作是最方便的
 *     所以明确了Reader，那么就将System.in转换成字符流Reader
 *     用到了Reader体系中的转换流，InputStreamReader
 *     
 *     InputStreamReader isr = new InputStreamReader(System.in);
 *     
 *     需要提高效率吗？需要，BufferedReader
 *     BufferedReader buff = new BufferedReader(isr);
 *   目的：OutputStream Writer
 *     是否是纯文本？ 是 Writer
 *     设备：硬盘，一个文件  使用FileWriter
 *     FileWriter fw = new FileWriter("a.txt");
 *     需要提高效率吗？需要  BufferedWriter
 *     BufferedWriter buffw = new BufferedWriter(fw); 
 *   
 *   
 * 扩展：想要把录入的数据按照指定的编码表（utf-8），将数据存到文件中
 *   目的：OutputStream Writer
 *     是否是纯文本？ 是 Writer
 *     设备：硬盘，一个文件  使用FileWriter
 *     但是FileWriter是使用的默认编码表
 *     但是存储时，需要加入指定的编码表（utf-8），而指定的编码表只有转换流可以指定。
 *     所以要使用的对象是OutputStreamWriter
 *     而该转换流对象要接收一个字节输出流，而且还可以操作文件的字节输出流，FileOutputStream
 *     OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStreamReader("d.txt"),"UTF-8");
 *     
 *     需要高效吗？需要
 *     BufferedWriter bufw = new BufferedWriter(osw);
 *     
 *     所以，记住，转换流什么时候使用，字符和字节之间的桥梁，通常涉及到字符编码转换时，
 *     需要用到转换流
 * 
 * 练习：将一个文本数据打印在控制台上，按照以上格式完成三个明确
 * 
 * 
 */

public class ReadIn_24 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//Test1();
		//Test2();
		//Test3();
		//Test4();
		//Test5();
		//Test6();
		Test7();
	}
	
	private static void Test7() throws UnsupportedEncodingException, FileNotFoundException {
		// TODO Auto-generated method stub
		//修改输入流对象
		//System.setIn(new FileInputStream("filewriter.txt"));
		//修改输出
		//System.setOut(new PrintStream("e.txt"));
		
		BufferedReader buffr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d1.txt"),"UTF-8"));
		String str;
		try {
			while((str = buffr.readLine())!=null){
				if ("over".equals(str)){
					break;
				}
				buffw.write(str);
				buffw.newLine();
				buffw.flush();
		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void Test6() throws FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream("out.txt")));
		BufferedWriter buffW = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		try {
			while((str = buff.readLine())!=null){
				if ("over".equals(str)){
					break;
				}
				buffW.write(str);
				buffW.newLine();
				buffW.flush();
		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Test5() throws FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter buffW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
		String str;
		try {
			while((str = buff.readLine())!=null){
				if ("over".equals(str)){
					break;
				}
				buffW.write(str);
				buffW.newLine();
				buffW.flush();
		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Test4() {
		// TODO Auto-generated method stub
		//获取键盘录入对象
		InputStream in = System.in;
		//将字节流对象转换成字符流对象，使用转换留，InputStreamReader
		InputStreamReader isr = new InputStreamReader(in);
		//将字符流传入字符流缓存区
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out);
		
		BufferedWriter bw = new BufferedWriter(osw);
		
		String str;
		try {
			while((str = br.readLine())!=null){
				if ("over".equals(str)){
					break;
				}
				bw.write(str);
				bw.newLine();
				bw.flush();
				//osw.write(str+"\r\n");
				//osw.flush(); 
				//System.out.println(str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void Test3() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		try {
			int by1 = 0;
			StringBuilder sb = new StringBuilder();
			while(true){
				int ch = in.read();
				if (ch=='\r'){
					continue;
				}
				if (ch=='\n'){
					String str = sb.toString();
					if ("over".equals(str)){
						break;
					}
					System.out.println(str.toUpperCase());
					sb.delete(0, sb.length());
				}
				sb.append((char)ch);
				//System.out.println(by1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Test2() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		try {
			int by1 = 0;
			while((by1=in.read())!=-1){
				System.out.println(by1);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Test1() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		try {
			int by1 = in.read();
			int by2 = in.read();
			int by3 = in.read();
			System.out.println(by1);
			System.out.println(by2);
			System.out.println(by3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
