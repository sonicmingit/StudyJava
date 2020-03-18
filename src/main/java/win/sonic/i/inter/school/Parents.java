package win.sonic.i.inter.school;

/**
 * 这是一个家长
 * @author 郝一鸣
 *
 */
public class Parents extends Identity implements IStay, IEat {

	
	@Override
	public void WhereEat() {
		System.out.println("住在" + IStay.hotel + "\n");

	}

	@Override
	public void WhatEat() {
		System.out.println("在" + IEat.hotel + "吃\n");

	}

	@Override
	public void whereStay() {
		System.out.println("你可以吃" + IEat.chicken + " 或者 " + IEat.meatWithMo + " 或者 " + IEat.porridge + ".\n");

	}

}
