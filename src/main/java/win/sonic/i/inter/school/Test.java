package win.sonic.i.inter.school;

import java.util.Scanner;

public class Test {

	/**
	 * 传入是谁,输出在哪住,在那吃,吃什么
	 * 
	 * @param 谁的信息
	 */
	public static void who(Identity who) {
		who.whereStay();
		who.WhereEat();
		who.WhatEat();
	}

	public static void main(String[] args) {
		Student stu = new Student();
		Teacher t = new Teacher();
		Parents p = new Parents();
		// 你的身份是什么? 1是....
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你的身份:\n1.学生\n2.老师\n3.学生家长");
		String use = input.next();
		// 显示你的住宿地点 在哪吃 吃什么
		switch (use) {
		case "1":
			Test.who(stu);
			break;
		case "2":
			Test.who(t);
			break;
		case "3":
			Test.who(p);
			break;
		default:
			System.out.println("没有这个选项!");
		}
		System.out.println("程序结束!");
		input.close();
	}
}
