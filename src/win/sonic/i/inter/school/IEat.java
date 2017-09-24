package win.sonic.i.inter.school;

/**
 * 一个吃的接口,包含吃的方法和在哪吃
 * 
 * @author 郝一鸣
 *
 */
public interface IEat {
	// 吃的地方
	String mess = "食堂";
	String hotel = "招待所";
	// 吃的东西
	String milk = "牛奶";
	String porridge = "稀饭";
	String mo = "馍";
	String icepark = "冰峰";
	String meatWithMo = "肉夹馍";
	String liangpi = "凉皮";
	String chicken = "鸡肉";

	/**
	 * 在哪里吃
	 */
	void WhereEat();

	/**
	 * 可以吃什么
	 */
	void WhatEat();
}
