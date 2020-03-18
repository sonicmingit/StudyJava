package win.sonic.b.processcontrol;
import java.util.Scanner;

public class pyCalc {
	public static void main(String[] args) {
		int num1;
		int num2;
		int sum1 = 0;
		double sum2;
		String calc;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入1开始计算器，输入任意字符离开计算！");
		String use = input.next();
		while (use.equals("1")) {
			System.out.println("请输入第一个数字：");
			num1 = input.nextInt();
			System.out.println("请输入第二个数字：");
			num2 = input.nextInt();
			lab: while (true) {
				System.out.println("请输入一个计算方法(支持+、-、×、÷、取余数)：");
				calc = input.next();
				if (calc.equals("+") || calc.equals("-") || calc.equals("*") || calc.equals("/") || calc.equals("%")) {
					switch (calc) {
					case "+":
						sum1 = num1 + num2;
						System.out.println("计算结果为：" + num1 + "+" + num2 + "=" + sum1);
						break lab;
					case "-":
						sum1 = num1 - num2;
						System.out.println("计算结果为：" + num1 + "-" + num2 + "=" + sum1);
						break lab;
					case "*":
						sum1 = num1 * num2;
						System.out.println("计算结果为：" + num1 + "*" + num2 + "=" + sum1);
						break lab;
					case "/":
						sum2 = num1 / num2;
						System.out.println("计算结果为：" + num1 + "/" + num2 + "=" + sum2);
						break lab;
					case "%":
						sum1 = num1 % num2;
						System.out.println("计算结果为：" + num1 + "%" + num2 + "=" + sum1);
						break lab;
					default:

					}
					break;
				} else {
					System.out.println("输入错误，请重新输入支持的计算方式！");
				}

			}
			System.out.println("是否继续使用本计算，输入1继续，输入任意数字结束");
			use = input.next();
		}

		System.out.println("计算结束，谢谢！");
	}
}
