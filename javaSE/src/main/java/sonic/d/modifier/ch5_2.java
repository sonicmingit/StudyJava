package sonic.d.modifier;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * 作业2: 
 * 写一个编程题把前面的格式转换成后面的格式。 
 * ttt5yjd-jdd4yh tttyyyyyjd@jddyyyyh
 * Hsdkf4sd-fsd3tr Hsdkfssssd@fsd3tttr 
 * Sf5sd-dsd4wr Sfsssssd@dsdwwwwr
 */
/*分析:
 * 规则1:替换出现的数字为仅挨着的字母,例"3t"="ttt";
 * 规则2:替换-为@
 * 
 */
/*
 * 直接输出,没有把每个类按方法分开并调用
 */
public class ch5_2 {
	void change(String a){			
		//创建一个方法判断a是否为纯数字,如果是纯数字就不执行规则1
		// 创建一个布尔值作为判断,false=纯数字;true=非纯数字;
				boolean digit = false;
				for (int i = 0; i < a.length(); i++) {
					// 如果有非数字字符,停止循环,并返回true
					if (!Character.isDigit(a.charAt(i))) {
						digit = true;
						break;
					}
				}
			//如果不为纯数字,执行规则1的转换
				if(digit){
					System.out.print("按要求转换格式后:");					
					// 创建一个SB对象等于a,用来使用SB的方法
					StringBuffer aSb = new StringBuffer(a);
					// 利用for循环去操作替换,次数为a的长度
					for (int i = 0; i < a.length(); i++) {
						// 判断字符串a的第i为是否为数字且第i+1位不为数字时
						if (Character.isDigit((a.charAt(i))) && Character.isLetter((a.charAt(i + 1)))&&(a.charAt(i)!='0')) {
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
					a = aSb.toString();
					/*在进行规则2的转换,并直接输出*/
					System.out.println(a.replace('-', '@'));
				}
				
				else {
					System.out.println("这是一个纯数字,不支持转换!");
				}
				
	}	
	
	public static void main(String[] args) {
		// 创建题目要求的三个字符串
				String str1 = "ttt5yjd-jdd4yh";
				String str2 = "Hsdkf4sd-fsd3tr";
				String str3 = "Sf5sd-dsd4wr";
		//创建对象,并传入参数
				ch5_2 test = new ch5_2();
				//调用类方法输出作业字符串转换后的格式
				System.out.println("示例字符串1:"+str1);
				System.out.print("按要求转换格式后:");
				test.change(str1);
				System.out.println("--------------------------------\n示例字符串2:"+str2);
				System.out.print("按要求转换格式后:");
				test.change(str2);
				System.out.println("--------------------------------\n示例字符串3:"+str3);
				System.out.print("按要求转换格式后:");
				test.change(str3);
		//提示输入一个字符串按照要求转换
				String x = "";
				Scanner input =new Scanner(System.in);
				do{				
				System.out.println("请输入一个字符串:");
				String use = input.next();
				System.out.println("输入的字符串为:"+use);				
				test.change(use);
				System.out.println("------------------------------\n输入1继续执行字符串转换,输入其他退出程序!");
				x = input.next();				
				}while(x.equals("1"));
				input.close();
				System.out.println("程序结束!");				
	}
}
