package win.sonic.i.inter.school;

/**
 * 这是一个学生
 * 
 * @author 郝一鸣
 *
 */
public class Student extends Identity implements IEat, IStay {
	@Override
	public void whereStay() {
		System.out.println("住在" + IStay.dorm + "\n");
	}

	@Override
	public void WhereEat() {
		System.out.println("在" + IEat.mess + "吃\n");

	}

	@Override
	public void WhatEat() {
		System.out.println("你可以吃" + IEat.liangpi + " 或者 " + IEat.meatWithMo + " 或者 " + IEat.icepark + ".\n");
	}
}
