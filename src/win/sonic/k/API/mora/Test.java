package win.sonic.k.API.mora;

import java.util.Scanner;

/**
 * 测试游戏类
 * 
 * @author Administrator
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建玩家对象
		Person p = new Person();
		// 创建电脑对象
		Computer com = new Computer();
		// 创建游戏对象
		Game g = new Game(com, p);

		System.out.println("欢迎进入猜拳游戏......");
		System.out.println("请输入你的姓名：");
		// 玩家输入姓名
		Scanner s = new Scanner(System.in);
		String name = s.next();
		p.setName(name);
		System.out.println(name + "你好，请出拳，0:剪刀，1代表石头，2代表布，请输入...");
		int i = 0;

		boolean bo = true;
		while (bo) {
			// 玩家出拳
			i = s.nextInt();
			// 如果输入小于0或者大于2的数值，退出程序
			exit(i);
			p.setI(i);
			g.play();

			// 判断游戏是否继续
			System.out.println("如需继续请按1，退出请按0");
			int j = s.nextInt();
			exit(j);
			bo = j == 1 ? true : false;
		}
	}

	// 判断玩家出的拳，只能输入0，1，2，否则程序退出
	public static void exit(int i) {
		if (i < 0 || i > 2) {
			System.out.println("输入错误，游戏已结束，本游戏只能输入0，1，2");
			System.exit(0);
		}
	}
}
