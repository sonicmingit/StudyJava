package sonic.m.IO.rw;
import java.io.*;

/**
 * 读取写入测试
 * 
 * @author 郝一鸣
 *
 */
public class RW {

	public static void main(String[] args) {
		// 创建一个文件类
		File test = new File("D:\\Desktop\\RW.txt");
		//\\课件\\JAVA\\Day课件\\0504 IO
		// 物理创建文件
		try {
			test.createNewFile();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("-----------------字符写入测试开始-----------------");
		// 创建一个字符写入类
		FileWriter w = null;
		try {
			w = new FileWriter(test);
			// 创建要写入的内容
			String str = "这是要写入的内容1!!!";
			// 覆盖写入
			w.write(str);
			// 添加写入
			w.append(str);

		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				w.close();
				System.out.println("写入测试接口关闭");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println("-----------------字符读取测试开始-----------------");
		FileReader r = null;
		try {
			r = new FileReader(test);
			char[] ch = new char[(int) test.length()];
			//意思是把test文件内容读取到ch字符数组中
			r.read(ch);
			//输出字符数组
			System.out.println(ch);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				r.close();
				System.out.println("读取测试接口关闭");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

}
