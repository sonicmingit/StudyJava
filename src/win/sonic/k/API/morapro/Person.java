package win.sonic.k.API.morapro;

import java.util.Scanner;

/**
 * 玩家类,玩家的出拳方式和结果
 * 
 * @author 郝一鸣
 *
 */
public class Person extends Player implements IWhat {
	// 玩家姓名
	private String name;
	// 出拳结果
	private int out;

	@Override
	public int WhatOut() {
		System.out.println("请问您出什么?\n1.剪刀  2.石头  3.布");
		// 利用try catch防止报错
		while (true) {
			// 异常检测:输入非数字要求重新输入
			try {
				// Scanner放到try循环里防止报异常
				Scanner in = new Scanner(System.in);
				// 结果赋值给out
				out = in.nextInt();
				// in.close();
				// 数字检测:输入非1.2.3要求重新输入
				if (out < 1 || out > 3) {
					System.out.println("输入错误,请重新输入!\n只接受1-3的整数,谢谢!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("输入错误,请重新输入!\n只接受1-3的整数,谢谢!");
			}
		}
		// 输出player出拳结果
		return out;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getOut() {
		return this.out;
	}

	/**
	 * 创建玩家类的时候输入玩家姓名
	 * 
	 * @param name
	 *            玩家姓名
	 */
	public Person(String name) {
		super();
		this.name = name;
	}
	// 测试
	/*
	 * public static void main(String[] args) { IWhat a = new Person();
	 * System.out.println(a.WhatOut()); }
	 */
}
