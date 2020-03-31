package sonic.uuu.test;

import java.util.Scanner;

import win.sonic.uuu.Regex;

public class Regtest {
	public static void main(String[] args) {
		boolean b =false;
		String reg = "(13\\d|14[57]|15[^4,\\D]|17[13678]|18\\d)\\d{8}|170[0589]\\d{7}";
		Scanner in = new Scanner(System.in);
		System.out.println("请输入您的手机号:");
		while (true) {
			String u=in.next();
			b=Regex.regex(reg, u);		
			if (b) {
				System.out.println("手机号输入正确!");
				break;
			}else {
				System.out.println("手机号输入不正确!");
			}		
			
		}
	}
}
