package win.sonic.b.processcontrol;

/**
 * 九九乘法表
 * 
 * @author 郝一鸣
 *
 */
import java.util.Scanner;

public class P99 {
	public static void main(String[] args) {
		System.out.println("正序乘法表：");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				int sum = i * j;
				// System.out.print输出不会自动换行
				System.out.print(i + "×" + j + "=" + sum + " ");
			}
			// 外层进行完一次循环后进行换行
			System.out.println("");
		}
		System.out.println("————————————————————————————————————————————————————————");
		// 倒叙的乘法表
		System.out.println("倒叙乘法表：");
		for (int i = 9; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				int sum = i * j;
				System.out.print(i + "×" + j + "=" + sum + " ");
			}
			System.out.println("");
		}

		// 来一个自定义数乘法表，输入一个数，自动输出
		System.out.println("————————————————————————————————————————————————————————");
		System.out.println("————————————————————————————————————————————————————————");
		System.out.println("创建一个自定义乘法表，输入一个数：");
		Scanner input = new Scanner(System.in);
		int diy = input.nextInt();
		System.out.println("接下来要展示一个" + diy + "×" + diy + "的乘法表：");
		// 套用九九乘法表，自定义数
		for (int i = 1; i < diy + 1; i++) {
			for (int j = 1; j <= i; j++) {
				int sum = i * j;
				System.out.print(i + "×" + j + "=" + sum + " ");
			}
			System.out.println("");
		}

	}
}