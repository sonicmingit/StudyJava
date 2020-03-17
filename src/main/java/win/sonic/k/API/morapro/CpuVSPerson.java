package win.sonic.k.API.morapro;

import java.util.Scanner;

/**
 * 玩家和电脑进行对决
 * 
 * @author 郝一鸣
 *
 */
public class CpuVSPerson {

	public static void main(String[] args) {
		// 提示是否开始游戏
		System.out.println("想开始猜拳游戏吗? \n1.开始,任意键退出!");
		// 创建一个输入接口,之后提交输入
		Scanner in = new Scanner(System.in);
		// 用于判断是否循环
		String start = in.next();
		// 输入1开始游戏,其他直接退出
		if (start.equals("1")) {
			System.out.println("请输入您的昵称:");
			String name = in.next();
			// 录入并创建Person对象
			Person p1 = new Person(name);
			// 游戏结束后继续游戏时用到
			while (start.equals("1")) {
				System.out.print(p1.getName() + ",您好,");
				// in.close();
				/* 输入接口有问题,可能会无法进行下去!!!!重新运行也许能解决 */
				// 调用Person对象的出拳方法
				int p1out = p1.WhatOut();
				// 创建一个Computer对象,并调用出拳方法
				Computer cpu = new Computer();
				int cpuout = cpu.WhatOut();
				// 输出Computer对象出拳结果.---调用父类Player方法进行翻译<继承方法>
				System.out.println("--------------------\n现在到电脑出拳了!\n--------------------\n电脑出的是:" + cpu.judge(cpuout));
				// 输出Person对象出拳结果
				System.out.println("您出的是:" + p1.judge(p1out) + "\n--------------------");
				// 调用Rules规则输出结果!---传入接口IWhat两个对象<接口和多态>
				String result = Rules.player2(p1, cpu);
				// 根据Rules规则输出进行判断,输出结果
				if (result.equals("平局")) {
					System.out.println("本次" + result + "没有获胜者!");
				} else if (result.equals(p1.getName())) {
					System.out.println("恭喜您获得了本次胜利!");
				} else {
					System.out.println("很遗憾," + result + "获得了本次胜利!");
				}
				// 提示是否需要继续游戏,继续调转到上面的while循环
				System.out.println("--------------------\n是否要再次进行游戏?\n1.继续,任意键退出!");
				start = in.next();
			}
			// 不继续输出结束
			System.out.println("您本次共进行了" + Rules.count + "局游戏,综合比分:\n您:电脑:" + Rules.pn1 + ":" + Rules.pn2 + ",平局:"
					+ (Rules.count - Rules.pn1 - Rules.pn2) + "次");
			System.out.println("--------------------\n游戏结束,感谢您的参与!!!");
		} else {
			// 如果一开始没有开始游戏,输出
			System.out.println("希望您下次能否尝试本游戏,感谢运行!");
		}
		in.close();
	}
}
