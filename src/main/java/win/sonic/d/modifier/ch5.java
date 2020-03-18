package win.sonic.d.modifier;

import java.util.Scanner;
/**
 * 此为把规则1和2分别拆开为不同的方法的类.
 */
/**
 * ch5-2 写一个编程题把前面的格式转换成后面的格式。 ttt5yjd-jdd4yh tttyyyyyjd@jddyyyyh
 * Hsdkf4sd-fsd3tr Hsdkfssssd@fsd3tttr Sf5sd-dsd4wr Sfsssssd@dsdwwwwr *
 * 
 * @author Sonic
 *
 */

/*
 * 题目分析:  1.当字符串中出现数字x,替换为x个x后面的字符.2.把字符串中'-'字符替换为'@';
 */
public class ch5 {
	//创建一个变量,用来接收需要转换的字符串
private String a;
	//创建一个变量,用来接收分析1转换后的字符串
private String a1;
	// 创建一个变量,用于接收最终转换完成的字符串
private String end;

	// 创建一个方法判断a是否为纯数字,如果是纯数字就不执行分析1的转换
	public boolean digit() {
		// 创建一个布尔值作为判断,false=纯数字;true=非纯数字;
		boolean digit = false;
		for (int i = 0; i < a.length(); i++) {
			// 如果有非数字字符,停止循环,并返回true
			if (!Character.isDigit(a.charAt(i))) {
				digit = true;
				break;
			}
		}	
		return digit;
	}

	// 创建一个用于转换分析1的方法
	public String method2() {		
		// 创建一个SB对象等于a,用来使用SB的方法
		StringBuffer aSb = new StringBuffer(a);
		// 利用for循环去操作替换,次数为a的长度
		for (int i = 0; i < a.length(); i++) {
			// 判断字符串a的第i为是否为数字且第i+1位为字母
			if (Character.isDigit((a.charAt(i))) && (Character.isLetter((a.charAt(i + 1))))) {
				// 创建一个字符x接收数字字符
				char x = a.charAt(i);
				// 创建一个字符y接收数字字符的后一位字符
				char y = a.charAt((i + 1));
				// 把字符x转换为字符对象x1
				Character x1 = x;
				// 把字符y转换为字符对象y1
				Character y1 = y;
				// 把字符对象x1转换为整型x2,用于判断十字
				int x2 = Integer.parseInt(x1.toString());
				// 把字符对象y1转换为字符串y2,用于合并字符串
				String y2 = y1.toString();
				// 创建字符串z用来保存要替换的字符
				String z = "";

				// if (x2!=0) {
				// 通过for循环把x2个y2保存到z中
				for (int j = 0; j < x2; j++) {
					z += y2;
				}
				// }
				// 用SB的替换方法,修改原字符串
				aSb.replace(i, i + 2, z);
				// 把修改后的SB转换成字符串并赋给a;防止SB修改后长度改变,影响原字符串
				a = aSb.toString();
				//由于a的位数增加,防止多余的运算
				i+=(x2-1);
			}
		}
		// 最后把修改好的字符串传给a
		a1 = aSb.toString();
		return a1;
	}
	
	// 创建一个用于转换分析2的方法
		public String method1() {			
			end = a1.replace('-', '@');
			return end;
		}
	// 创建一个构造函数,当传入需要转换格式的字符串时,传出转换格式后的字符串	
		public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}
		//创建一个方法去执行分析1和分析2
		public void method(String a){
			//传入用于转换的字符串a			
			setA(a);		
			//如果不是纯数字就执行方法1和方法2,输出转换后的内容
			if(digit()){
				method1();
				method2();
				System.out.println("输入的字符串为: "+a);
				System.out.println("转换后的字符串为:"+end);
			}
			//如果是纯数字,提示不符合转换要求直接输出
			System.out.println("输入的字符串不符合要求,这是一串纯数字!");
		}
	// 创建一个主方法执行类
	public static void main(String[] args) {
		// 创建题目要求的三个字符串
		String str1 = "ttt5yjd-jdd4yh";
		String str2 = "Hsdkf4sd-fsd3tr";
		String str3 = "Sf5sd-dsd4wr";
		//输出作业要求的
		ch5 test = new ch5();
		test.method(str1);			
	}
}
