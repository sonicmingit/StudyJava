package win.sonic.m.IO.file;

import java.io.*;
import java.util.concurrent.SynchronousQueue;

public class FileTest {
	// /**
	// * @param file
	// * 父文件夹名
	// * @param name
	// * 文件类名
	// * @param fileName
	// * 文件名.类型
	// */
	// public static void mkFile(File file, File name, String fileName) {
	// // 在file文件夹下创建文件
	// name = new File(file, fileName);
	// // 进行判断,如果文件夹存在,直接创建文件,如果不存在,先创建文件夹在创建文件
	// if (file.exists()) {
	// try {
	// name.createNewFile();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// } else {
	// file.mkdir();
	// try {
	// name.createNewFile();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }

	public static void main(String[] args) throws IOException {
		System.out.println("------------测试File类的方法------------------");
		// 创建一个文件类,在项目当前目录
		File file = new File("File测试");
		// 显示文件file的绝对目录
		System.out.println(file.getAbsolutePath());
		File filet = new File(file, "File测试文件.txt");
		File filet1 = new File(file, "File测试文件1.txt");
		File filet2 = new File(file, "File测试文件2.txt");
		File filet3 = new File(file, "File测试文件3.txt");
		File filej = new File(file, "File测试文件.java");
		File filed = new File(file, "File测试文件.doc");
		File filer = new File(file, "File测试文件.rar");
		// 创建文件夹
		file.mkdirs();
		// 删除文件夹
		file.delete();
		// 创建文件,判断文件夹是否存在,如果存在创建文件,不存在,先创建文件夹
		if (file.exists()) {
			filet.createNewFile();
		} else {
			file.mkdirs();
			filet.createNewFile();
		}
		// 创建文件
		filej.createNewFile();
		filed.createNewFile();
		filer.createNewFile();
		filet1.createNewFile();
		filet2.createNewFile();
		filet3.createNewFile();

		/* 测试文件方法 */
		// 判断是否文件
		System.out.println("filet是文件吗?" + filet.isFile());
		// 判断是否文件夹
		System.out.println("file是文件夹吗?" + file.isDirectory());
		System.out.println("filet是文件夹吗?" + filet.isDirectory());
		// 获取文件名
		System.out.println("file的文件名是:" + file.getName());
		System.out.println("filej的文件名是:" + filej.getName());
		// 获取文件路径
		System.out.println("file的文件路径是:" + file.getAbsolutePath());
		// 获取相对路径,以当前目录为基准
		System.out.println("filer的文件路径是:" + filer.getPath());
		// 获取长度
		System.out.println(file.length());// 文件夹是4096个字节
		System.out.println(filet1.length());// 这是一个空文件
		System.out.println("--------------------------------------------------------");
		/* 测试文件数组方法 */
		// 获取文件夹下的文件名,返回一个字符串数组
		System.out.println("file文件夹下的文件名:");
		String[] fileList = file.list(); // 可以封装一个方法,相当于dos命令的dir
		for (String str : fileList) {
			System.out.println(str);
		}
		// 获取文件夹下的所有文件到一个File类数组
		File[] fileAll = file.listFiles();

		/* 获取满足过滤条件的数组 */
		//此方法只过滤文件名,参数必须是实现了FileNameFilter接口的类的对象
		String[] fileTxt = file.list(new Filter_java());
		System.out.println("过滤出的txt文件列表:");
		for (String str : fileTxt) {
			System.out.println(str);
		}
		/*此方法不会用啊*/
		//过滤文件内容列表
//		File[] fileEmpty = file.listFiles(new Filter_java());
	}
}
