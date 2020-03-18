package win.sonic.m.IO.rw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffer {

	public static void main(String[] args) {
		/* 字节流 */
		// 创建一个文件用于测试字节流
		File test1 = new File("D:\\Desktop\\课件\\JAVA\\Day课件\\0504 IO\\Buffer1.txt");
		try {
			test1.createNewFile();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 字节流写入
		System.out.println("-----------------------测试开始-----------------------------");
		System.out.println("----------------------字节流测试开始---------------------------");
		// 创建一个写入类和缓冲类
		FileOutputStream fo = null;
		BufferedOutputStream bo = null;
		// 创建写入
		try {
			fo = new FileOutputStream(test1);
			bo = new BufferedOutputStream(fo);
			String str = "这是一个字节流的测试文档!";
			byte[] b = str.getBytes();
			bo.write(b);
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} finally {
			try {
				// 刷新
				bo.flush();
				fo.flush();
				// 关闭
				bo.close();
				fo.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		// 字节流读取
		System.out.println("------------------------分隔符-----------------------------");
		// 创建读取类和缓冲类
		FileInputStream fi = null;
		BufferedInputStream bi = null;
		// 实例化
		try {
			fi = new FileInputStream(test1);
			bi = new BufferedInputStream(fi);
			// 创建一个字节数组接收,长度等于要接收的文件长度
			byte[] b = new byte[(int) test1.length()];
			// 写入到b
			bi.read(b);
			// 输出b
			System.out.println(new String(b));
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} finally {
			// 关闭接口,需要按里外层顺序关闭
			try {
				bi.close();
				fi.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println("----------------------字节流测试完毕---------------------------");

		/* 字符流 */
		// 创建一个文件用于测试字节流
		File test2 = new File("D:\\Desktop\\课件\\JAVA\\Day课件\\0504 IO\\Buffer2.txt");
		try {
			test2.createNewFile();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 字符流写入
		System.out.println("------------------------分隔符-----------------------------");
		System.out.println("----------------------字符流测试完毕---------------------------");
		// 创建写入用字节流的类和缓冲类
		FileWriter fw = null;
		BufferedWriter bw = null;
		// 实例化
		// TODO 自动生成的 catch 块
		try {
			fw = new FileWriter(test2);
			bw = new BufferedWriter(fw);
			// 创建一个要写入的字符串
			String str = "这是一个字符流的文档测试!";
			bw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 刷新和关闭接口
				bw.flush();
				fw.flush();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		// 字符流读取
		System.out.println("----------------------字符流测试开始---------------------------");
		// 创建字符流接口和缓存接口
		FileReader fr = null;
		BufferedReader br = null;
		// 实例化
		try {
			fr = new FileReader(test2);
			br = new BufferedReader(fr);
			// 输出读取字符
			System.out.println(br.readLine());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				// 关闭接口
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		System.out.println("---------------------所有测试完毕-----------------------------");
	}

}
