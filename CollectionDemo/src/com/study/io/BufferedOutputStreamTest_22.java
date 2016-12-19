package com.study.io;

import java.io.*;

/**
 * 复制一个图片 思路： 
 * 1、用字节读取流对象和图片关联
 * 2、用字节写入流创建一个图片文件，用于存储获取到的图片数据 
 * 3、循环读写，完成数据存储
 * 4、关闭资源
 * 
 * 通过缓存复制文件
 * 
 */

class MyBufferedInputStream{
	private InputStream is ;
	private byte[] buf = new byte[1024];
	private int pos = 0,count = 0;
	public MyBufferedInputStream(InputStream is) {
		super();
		this.is = is;
	}
	//一次读取一个字节，从缓存区（字节数组）获取
	/*
	 * 读取的是byte，但是返回的是int原因：
	 * 读取byte时会出现"11111111"情况，即-1，与结束标识一致，会导致错误完成信号
	 * 将byte提升为int,将读取的byte至于int最后一个字节，前面的24个字节补0，这样就避免了上述错误，写入的时候再提取int最后8位
	 * 提升方式
	 * step1:byte:11111111
	 * step2:正常提升int:11111111 11111111 11111111 11111111   -1
	 * step3:将int数据与00000000 00000000 00000000 11111111(255)与操作
	 *        11111111 11111111 11111111 [11111111]
	 *        00000000 00000000 00000000  11111111  &
	 *       ------------------------------------------
	 *        00000000 00000000 00000000 [11111111]
	 *        
	 * 最终提升后int:00000000 00000000 00000000 11111111
	 * 
	 * 
	 * 注：此处byte提升int与我们日常byte转为int提升是不一样的
	 * 按照正常转换提升的话
	 * byte：11111111提升为int类型还是-1，这是因为在8个1之前补得是1导致的，即11111111 11111111 11111111 11111111
	 * 那么我只要在前面补0，既可以保留原字节数据不变，又可以避免-1的出现
	 * 怎么补0呢？
	 * 
	 * 11111111 11111111 11111111 11111111
	 * 00000000 00000000 00000000 11111111 &
	 * --------------------------------------
	 * 00000000 00000000 00000000 11111111
	 * 
	 */
	public int read() throws IOException{   //未使用byte返回，byte类型的-1提升为int类型
		//通过is对象读取硬盘上的数据，并存储buf中
		if (count==pos){
			count = is.read(buf);
			if (count==-1){
				return -1;
			}
			pos = 0;
		}
		int b = buf[pos++];  //正常提升，由于int前面24位是补充1，那么当byte是-1时候，b=-1，会导致读取结束的信号，故将前面24位补为0
		//b = b<<24;
		//b = b>>25;
		System.out.println(b);
		b = b&255;
		return b;
	}
	
	public void close() throws IOException{
		if (is!=null){
			is.close();
		}
	}
}

public class BufferedOutputStreamTest_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyBufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new MyBufferedInputStream(new FileInputStream("D:\\javain.jpg"));
			
			bos = new BufferedOutputStream(new FileOutputStream("D:\\javaout.jpg"));
			long s = System.currentTimeMillis();
			int by = 0;
			while ((by=bis.read())!=-1){
				bos.write(by);
			}
			System.out.println(System.currentTimeMillis()-s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("复制文件失败");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();throw new RuntimeException("复制文件失败");
			}
		}
	}

}

/*
 * 字节流读到连续四个1，即-1，提升为int时仍为-1，故读取会停止 
 * byte:-1
 * 1111-1111
 * 提升为int:-1
 * 1111-1111 1111-1111 1111-1111 1111-1111
 * 
 * 
 * 重新提升int,前面补0
 * byte:-1
 * int:00000000 00000000 00000000 11111111     255
 * 
 * 
 */
