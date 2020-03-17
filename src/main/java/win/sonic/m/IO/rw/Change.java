package win.sonic.m.IO.rw;

import java.io.*;

public class Change {

	public static void main(String[] args) {
		// 提示写入
		System.out.println("请输入要写入文本的内容,回车结束!");
		// 创建转换流
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		// 创建用来接收输入的字符串
		String str = null;
		try {
			//输入的内容写入到str
			str = br.readLine();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				//关闭接口
				br.close();
				in.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		// 创建一个接收文件
		File file = new File("这是你输入的内容.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		/* 把之前输入的字符写入到创建的文本 */
		// 创建一个写入接口和缓存
		FileWriter fw = null;
		BufferedWriter bw = null;
		// 实例化
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			// 写入键盘输入的字符
			bw.write(str);
			System.out.println("写入文本成功!");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			// 刷新关闭接口
			try {
				bw.flush();
				fw.flush();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("文本路径为:" + file.getAbsolutePath());
			System.out.println("-----------程序结束-------------");
		}
	}

}
