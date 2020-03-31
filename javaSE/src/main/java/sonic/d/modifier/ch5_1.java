package sonic.d.modifier;

import java.util.Scanner;

/**
 * ch5 作业1: 编写截取字符串的方法，传入字符串及参数，然后进行调用验证
 * 
 * @author sonic
 *
 */
public class ch5_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 输入一个字符用于演示字符串截取
		System.out.println("输入一个字符串用来演示截取字符串");
		String use = input.next();
		System.out.println("输入一个数字确定需要截取的开始位置:");
		int a = input.nextInt();		
		System.out.println("输入第二个数字确定需要截取的终止位置(要大于第一个数字且小于" + use.length() + "):");
		int b = input.nextInt();
		System.out.println("输入的字符串为:" + use);
		System.out.println("从" + a + "到" + b + "的位置截取后的字符串为:" + use.substring(a, b + 1));
	}
}
