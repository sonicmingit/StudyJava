
package win.sonic.d.modifier;

import java.util.Scanner;

/**
 * ch1:给出矩形的长与宽，输出面积与周长。
 * 
 * @author Sonic
 *
 */
public class ch1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个对象用来保存输入内容
		Scanner input = new Scanner(System.in);
		// 创建两个变量用来存储用户输入长和宽
		System.out.println("请输入长度:");
		int a = input.nextInt();
		System.out.println("请输入宽");
		int b = input.nextInt();
		// 计算面积并输出
		int S = a * b;
		System.out.println("面积计算公式为S=a×b\n长为" + a + "m,宽为" + b + "m的矩形面积为:" + S + "㎡");
		// 计算周长并输出
		int C = (a + b) * 2;
		System.out.println("周长的计算公式为:C=(a+b)×2\n长为" + a + "m,宽为" + b + "m的矩形周长为:" + C + "m");

	}

}
