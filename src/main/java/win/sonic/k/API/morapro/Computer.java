package win.sonic.k.API.morapro;

import java.util.*;

/**
 * 电脑类,电脑的出拳方式和结果
 * 
 * @author 郝一鸣
 *
 */
public class Computer extends Player implements IWhat {
	// 电脑的名称,默认电脑
	private String name = "电脑";
	// 出拳结果
	private int out;

	@Override
	public int WhatOut() {
		// 返回一个1~3的随机整数,并保存到出拳结果
		out = (int) (Math.random() * 3) + 1;
		// rabdom方法,相比麻烦
		// Random r = new Random();
		// out=r.nextInt(3) + 1;
		return out;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getOut() {
		return out;
	}

	// 测试
	// public static void main(String[] args) {
	// Computer a = new Computer();
	// System.out.println(a.WhatOut());
	// }
	/**
	 * 可以设置电脑名
	 * 
	 * @param name
	 *            电脑名字
	 */
	public Computer(String name) {
		super();
		this.name = name;
	}

	/**
	 * 可以不设置电脑名
	 */
	public Computer() {
		super();
	}
}
