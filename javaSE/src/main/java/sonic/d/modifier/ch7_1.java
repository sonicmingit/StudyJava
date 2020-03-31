package sonic.d.modifier;

import java.util.Scanner;

/**
 * ch7
 * @author 郝一鸣
 *
 */

/**
 * 作业1: 将一个给定的整型数组转置输出，例如：源数组：1 2 3 4 5 6，转置之后的数组：6 5 4 3 2 1
 */
public class ch7_1 {
	// 创建一个倒叙的构造方法
	public void bubble(int a[]) {
		System.out.println("原数组为:");
		for (int i : a) {
			System.out.print(i + " ");
		}
		// 根据对称第一项跟最后一项调换,调换长度的一半次,达到倒置
		for (int i = 0; i < (a.length) / 2; i++) {
			int x = a[i];
			a[i] = a[(a.length - 1) - i];
			a[(a.length - 1) - i] = x;
		}
		System.out.println("\n转置后的数组为(方法1,原数组会改变):");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\n原数组现在为:");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\n---------------------");

	}

	public void bubble1(int a[]) {
		System.out.println("原数组为:");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\n转置后的数组为:(方法2,原数组不变)");
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n原数组现在为:");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		ch7_1 test = new ch7_1();
		// 测试一个示例
		int[] a = { 1, 2, 3, 4, 5, 6, 5, 8 };
		int[] b = { 1, 2, 3, 4, 5, 6, 5, 8 };
		System.out.println("输出示例:");
		test.bubble(a);
		test.bubble1(b);
		// 自定义一个数组然后倒置
		// Scanner input =new Scanner(System.in);
		// System.out.println("输入一个数组长度");
		// int use = input.nextInt();
		// int[] useArr = new int[n];
		// for (int i = 0; i < a.length; i++) {
		// }
	}
}
