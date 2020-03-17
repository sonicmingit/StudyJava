package win.sonic.m.IO.rw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {

	public static void main(String[] args) {
		// 创建一个文件
		File file = new File("D:\\Desktop\\课件\\JAVA\\Day课件\\0504 IO\\StreamTest.txt");
		// 创建这个文件
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("测试写入");
		// 创建一个写入流
		FileOutputStream f = null;
		// 要写入的内容
		String str = "这是一个测试 这就是个测试 这还是个测试 ";
		// 创建一个字符数组接收写入内容
		byte[] b = str.getBytes();
		// 写入内容传入字符数组
		b = str.getBytes();
		// 创建要写入的文件
		try {
			f = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 字符写入文件
		try {
			f.write(b, 0, b.length);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 始终关闭写入接口
		finally {
			// 关闭写入接口
			try {
				f.close();
				System.out.println("关闭写入接口");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

			System.out.println("测试写入完毕");
		}

		System.out.println("----------------------我是分隔线-----------------------");

		System.out.println("测试读取");
		// 创建一个读取类
		FileInputStream i = null;

		// 读取文件,意思是读取file文件,并把file文件写入到一个新的字节数组里
		try {
			i = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			// 创建一个字符数组,以每13个字符为组循环接收字节输出
			byte[] load = new byte[13];
			while ((i.read(load)) != -1) {
				System.out.println(new String(load, 0, load.length));			
			}
			//设置一个接收字节数组,长度为要读取文件的长度,接受并输出(一个FileInputStream只能读取一次文件,读完就读不了了)
			byte[] load2=new byte[(int) file.length()];
	    	i.read(load2);
	    	System.out.println(new String(load2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 始终关闭读取接口
		finally {
			try {
				i.close();
				System.out.println("读取关闭");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("读取测试完毕");
		}

	}

}
