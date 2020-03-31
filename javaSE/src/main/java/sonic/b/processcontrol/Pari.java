package sonic.b.processcontrol;
import java.util.Scanner;

/**
 * 计算器程序
 * 
 * @author 郝一鸣
 *
 */
public class Pari {
	public static void main(String[] args) {
		// 创建一个输入对象，用来保存后续输入
		Scanner input = new Scanner(System.in);
		//
		// 创建一个变量接受循环输入关键字，用来判断是否开始程序
		System.out.println("请根据提示输入是否开始运行计算程序：1开始计算；其他任意字符退出计算。");
		String use = input.next();
		// 加入一个循环，用于后期和开始判断是否执行程序
		while (use.equals("1")) {
			// 创建一个变量接受输入的第一个计算数字
			System.out.println("请输入第一个数字：");
			int num1 = input.nextInt();
			// 创建一个字符串变量接收运算符号
			String ari;
			// 用一个循环判断计算方式是否输入正确
			while (true) {
				// 输入运算符号
				System.out.println("输入一种运算方式（本程序支持+、-、*、/）：");
				ari = input.next();
				// 判断输入的运算符号是否正确，如果正确进行计算
				// str.equals("")字符串内置方法，判断字符串是否相等
				if (ari.equals("+") || ari.equals("-") || ari.equals("/") || ari.equals("*") || ari.equals("%")) {
					break;
				}
				// 如果不正确要求用户重新输入
				System.out.println("运算符输入错误，请再次输入：");
			}
			// 创建一个变量接受输入的第二个计算数字
			System.out.println("请输入第二个数字：");
			int num2 = input.nextInt();			
			// 创建一个变量接收结果
			double result = 0;
			// 创建一个字符串用来保存输入符号
			String sym = "0";
			// 判断运算方式
			switch (ari) {
			case "+":
				result = num1 + num2;
				sym = "+";
				break;
			case "-":
				result = num1 - num2;
				sym = "-";
				break;
			case "*":
				result = num1 * num2;
				sym = "×";
				break;
			case "/":
				result = (double) num1 / num2;
				sym = "÷";
				break;
			case "%":
				result = num1 % num2;
				sym = "%";
				break;
			default:
				break;
			}
			// 输出运算结果
			System.out.println("本次计算结果：");
			System.out.println(num1 + sym + num2 + "=" + result);
			System.out.println("--------------------------");
			// 提示用户是否需要再次运行本程序
			System.out.println("输入数字选择是否需要继续计算，1继续，其他任意数字退出。");
			use = input.next();
		}
		// 提示运算结束
		System.out.println("本次运算结束，谢谢！");
	}

}
