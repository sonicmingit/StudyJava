package win.sonic.k.API.morapro;

import java.util.Random;

/**
 * 随机两个电脑进行对决
 * 
 * @author 郝一鸣
 *
 */
public class CpuVSCpu {
	public static void main(String[] args) {
		System.out.println("本次比赛共有10位玩家参加比赛,我们随机挑选两位玩家进行比赛!\n--------------------");
		System.out.println("让我们看看今天出场的是哪两位选手?\n--------------------");
		// 创建随机数对象
		Random c = new Random();
		// 创建两个随机数,当电脑名字,如果相同,重新生成
		int c1 = c.nextInt(10) + 1;
		int c2 = c.nextInt(10) + 1;
		while (c1 == c2) {
			c2 = c.nextInt(10) + 1;
		}
		// 把随机数转换成字符串,创建两个电脑比赛
		Computer cpu1 = new Computer(String.valueOf(c1));
		Computer cpu2 = new Computer(String.valueOf(c2));
		// 比赛开始!!!先展示随机到几号选手,调用他们的名字输出
		System.out.println(cpu1.getName() + "号选手!");
		System.out.println(cpu2.getName() + "号选手!");
		System.out.println("--------------------");
		System.out.println("两位选手要开始对决了!看看他们会出什么???\n--------------------");
		// 调用电脑出拳规则,随机出拳
		System.out.println(cpu1.getName() + "号选手出的是:" + cpu1.judge(cpu1.WhatOut()));
		System.out.println(cpu2.getName() + "号选手出的是:" + cpu2.judge(cpu2.WhatOut()));
		System.out.println("--------------------");
		// 调用规则方法,进行判断
		String result = Rules.player2(cpu1, cpu2);
		// 输出判断结果
		if (result.equals("平局")) {
			System.out.println("本次平局!,没有获胜者");
		} else {
			System.out.println("恭喜 " + result + "号 玩家获得本次胜利!");
		}
	}
}
