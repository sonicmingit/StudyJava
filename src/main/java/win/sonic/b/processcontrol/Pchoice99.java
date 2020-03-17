package win.sonic.b.processcontrol;
import java.util.Scanner;

public class Pchoice99 {

	public static void main(String[] args) {
		while (true) {
			System.out.println("你需要怎样输出九九乘法表？");
			System.out.println("1.正序； 2.倒叙");
			Scanner input = new Scanner(System.in);
			int you = input.nextInt();
			System.out.println("----------------------------");
			if (you == 1) {
				for (int i = 1; i < 10; i++) {
					for (int j = 1; j <= i; j++) {
						int sum = i * j;
						// System.out.print输出不会自动换行
						System.out.print(i + "×" + j + "=" + sum + " ");
					}
					// 外层进行完一次循环后进行换行
					System.out.println("");
				}
				break;
			} else if (you == 2) {
				// 倒叙的乘法表
				System.out.println("倒叙乘法表：");				
				for (int i = 9; i > 0; i--) {
					for (int j = i; j >0 ; j--) {
						int sum = i * j;
						System.out.print(i + "×" + j + "=" + sum + " ");
					}
					System.out.println("");
				}
				break;
			} else {
				System.out.println("输入错误，请重新输入");
				System.out.println("----------------------------");
			}

		}
	}

}
