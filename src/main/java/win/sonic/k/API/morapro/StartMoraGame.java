package win.sonic.k.API.morapro;

import java.util.Scanner;

public class StartMoraGame {

	public static void main(String[] args) {
		// 选择开始游戏
		System.out.println("这是一个猜拳游戏,有三种对抗模式,请选择:");
		System.out.println("1.人类VS人类\n2.人类VS电脑\n3.电脑VS电脑");
		int use;
		// 输入判断
		while (true) {
			// 异常检测:输入非数字要求重新输入
			try {
				// Scanner放到try循环里防止报异常
				Scanner in = new Scanner(System.in);
				// 结果赋值给out
				use = in.nextInt();
				// 数字检测:输入非1.2.3要求重新输入
				if (use < 1 || use > 3) {
					System.out.println("输入错误,请重新输入!\n只接受1-3的整数,谢谢!");
					continue;
				}
				// in.close();
				break;
			} catch (Exception e) {
				System.out.println("输入错误,请重新输入!\n只接受1-3的整数,谢谢!");
			}
		}
		// 执行相应游戏
		switch (use) {
		case 1:
			WhoVSWho.pVSp();
			break;
		case 2:
			WhoVSWho.cVSp();
			;
			break;
		default:
			WhoVSWho.cVSc();
			break;
		}
	}
}
