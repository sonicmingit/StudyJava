package sonic.m.IO.rw;

import java.io.*;

public class Out {

	public static void main(String[] args) {
		// 提示写入
		System.out.println("请输入要写入文本的内容,回车结束!");
		// 创建转换流
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		// 创建用来接收输入的字符串
		String str = null;
		try {
			// 输入的内容写入到str
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭接口
				br.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 创建一个接收文件
		File file = new File("这是你输入的内容.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* 把之前输入的字符写入到创建的文本 */
		// 创建转换和缓冲
		FileOutputStream fo = null;
		OutputStreamWriter out = null;
		BufferedWriter bw = null;
		try {
			// 创建写入类
			fo = new FileOutputStream(file);
			out = new OutputStreamWriter(fo);
			bw = new BufferedWriter(out);
			bw.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 刷新,关闭
				bw.flush();
				out.flush();
				fo.flush();
				bw.close();
				out.close();
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("文本路径为:" + file.getAbsolutePath());
		System.out.println("-----------程序结束-------------");
	}
}
