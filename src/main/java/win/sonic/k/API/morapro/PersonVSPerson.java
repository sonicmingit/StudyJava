package win.sonic.k.API.morapro;

import java.util.Scanner;

public class PersonVSPerson {

	public static void main(String[] args) {
		// 提示是否开始游戏
		System.out.println("想开始两人猜拳游戏吗? \n1.开始,任意键退出!");
		// 创建一个输入接口,之后提交输入
		Scanner in = new Scanner(System.in);
		// 用于判断是否循环
		String start = in.next();
		// 输入1开始游戏,其他直接退出
		if (start.equals("1")) {
			System.out.println("请输入玩家1的昵称:");
			String name1 = in.next();
			// 录入并创建Person对象
			Person p1 = new Person(name1);
			System.out.println("请输入玩家2的昵称:");
			String name2 = in.next();
			// 录入并创建Person对象
			Person p2 = new Person(name2);
			// 游戏结束后继续游戏时用到
			while (start.equals("1")) {
				System.out.print("<"+p1.getName() + ">您好,");				
				// 调用Person对象的出拳方法
				int p1out = p1.WhatOut();
				System.out.print("--------------------\n现在轮到<"+p2.getName()+">出拳了!");
				int p2out = p2.WhatOut();				
				// 输出Person对象出拳结果
				System.out.println("--------------------\n<"+p1.getName()+">玩家出的是:" + p1.judge(p1out) + "\n<"+p2.getName()+">玩家出的是:"+p2.judge(p2out));
				// 调用Rules规则输出结果!---传入接口IWhat两个对象<接口和多态>
				String result = Rules.player2(p1, p2);
				// 根据Rules规则输出进行判断,输出结果
				if (result.equals("平局")) {
					System.out.println("本次" + result + "没有获胜者,可以再来一把!");
				} else {
					System.out.println("恭喜<"+result+">玩家获得了本次胜利!");
			}
				// 提示是否需要继续游戏,继续调转到上面的while循环
				System.out.println("--------------------\n是否要再次进行游戏?\n1.继续,任意键退出!");
				start = in.next();
			}
			// 不继续输出结束
			System.out.println("你们本次共进行了" + Rules.count + "局游戏,综合比分:\n<"+p1.getName()+">:<"+p2.getName() +">:"+ Rules.pn1 + "比" + Rules.pn2 + ",平局:"
					+ (Rules.count - Rules.pn1 - Rules.pn2) + "次");
			System.out.println("--------------------\n游戏结束,感谢您的参与!!!");
		} else {
			// 如果一开始没有开始游戏,输出
			System.out.println("希望您下次能否尝试本游戏,感谢运行!");
		}
		in.close();
	}
}
