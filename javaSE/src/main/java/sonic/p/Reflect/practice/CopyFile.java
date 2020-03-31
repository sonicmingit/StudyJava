package sonic.p.Reflect.practice;

import java.io.*;

public class CopyFile {
	// 主函数测试
	public static void main(String[] args) {
		// 创建测试文本
		creatTest();
		// 测试文本拷贝
		copy("测试文本.txt", "复制测试文本.txt");
	}

	/**
	 * @param file1
	 *            目标文件:路径/文件名.扩展名
	 * @param file2
	 *            目的文件:路径/文件名.扩展名(扩展名必须一致) *
	 */
	public static void copy(String file1, String file2) {

		long startTime = System.currentTimeMillis();
		// 要复制的目标文件-文件路径/文件名.扩展名
		File str = new File(file1);
		// 创建临时存储字节数组,大小等于目标文件长度
		/// *byte数组最大长度为61858764字节，将近60M,只能拷贝小于此大小文件*/
		byte[] b = new byte[(int) str.length()];
		// 目的-文件路径/文件名.扩展名
		File end = new File(file2);
		System.out.println("开始复制:" + str.getAbsolutePath());
		// 创建目的文件
		try {
			end.createNewFile();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		// 写入目标文件到临时字节数组
		FileInputStream is = null;
		BufferedInputStream bi = null;
		try {
			is = new FileInputStream(str);
			bi = new BufferedInputStream(is);
			bi.read(b);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				bi.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 从临时字节数组读取文件到目的路径文件
		FileOutputStream os = null;
		BufferedOutputStream bo = null;
		try {
			os = new FileOutputStream(end);
			bo = new BufferedOutputStream(os);
			bo.write(b, 0, b.length);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 刷新
				bo.flush();
				os.flush();
				// 关闭
				bo.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("已复制到:" + end.getAbsolutePath());
		long endTime = System.currentTimeMillis();
		System.out.println("文件大小:" + (str.length()) + "字节");
		System.out.println("共用时间：" + (endTime - startTime) + "ms");
		System.out.println("------------------------------------");
	}

	/**
	 * 创建一个测试文本
	 */
	public static void creatTest() {
		// 创建测试文本
		System.out.println("正在创建测试文本...");
		File t = new File("测试文本.txt");
		FileWriter w = null;
		try {
			t.createNewFile();
			w = new FileWriter(t);
			w.write("这是一个测试文本,用来被复制!!!");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				w.flush();
				w.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println("测试文本创建成功!");
		System.out.println("路径:" + t.getAbsolutePath());
		System.out.println("------------------------------------");
	}
}
