package win.sonic.d.modifier;

import java.util.Scanner;

/**
 * ch8:创建ch8类，定义一个方法，能统计创建的ch8类对象的个数。
 * 
 * @author sonic
 *
 */
// 创建一个类

public class ch8 {
	// 创建一个静态变量用于统计创建ch8类对象的个数
	static int num;

private  ch8() {
		num++;		
		// 没创建一个ch8类的对象,就增加一个计数对象
	}

	// 创建一个主函数用于创建ch8类对象
	public static void main(String[] args) {
		 //创建一个输入对象,用于后期输入内容
		 Scanner input = new Scanner(System.in);
		 // 创建一个变量,用于接收用户输入个数
		 System.out.println("请输入一个数字,确定要创建多少个ch8类!");
		 int i = input.nextInt();
		 //结束输入
		 input.close();
		 //创建一个ch8类数组
		 ch8[] x = new ch8[i];
		 //为数组的每一项创建一个ch8类对象
		 for (int j = 0; j < i; j++) {
		 x[j] = new ch8();
		 }
		System.out.println("共创建了" + ch8.num + "个ch8类对象");

	}
}
