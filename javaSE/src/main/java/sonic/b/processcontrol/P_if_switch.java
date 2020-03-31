package sonic.b.processcontrol;
import java.util.Scanner;

public class P_if_switch {
	public static void main(String[] args) {	
	Scanner scan = new Scanner(System.in);
	//练习1，一周七天用switch判断显示
	System.out.println("练习1，一周七天用switch判断显示");
	
			lab1: while(true){
			System.out.println("请输入数字1-7来显示星期几：");
			int day = scan.nextInt();
			switch (day) {
			case 1:
				System.out.println("星期一");
				break lab1;
			case 2:
				System.out.println("星期二");
				break lab1;
			case 3:
				System.out.println("星期三");
				break lab1;
			case 4:
				System.out.println("星期四");
				break lab1;
			case 5:
				System.out.println("星期五");
				break lab1;
			case 6:
				System.out.println("星期六");
				break lab1;
			case 7:
				System.out.println("星期天");
				break lab1;
			default:
				System.out.println("请输入正确的星期");
				break;
			}
			}
			
			
	//练习2，用if else判断成绩
			System.out.println("————————————————————————————————————————");	
			System.out.println("练习2，用if else判断成绩");
			System.out.println("---------------------------------------");	
			System.out.println("请输入你的成绩：");
			int s = scan.nextInt();
			if (s==100) {
				System.out.println("恭喜你得了100分！");
			} else if (s>90) {
				System.out.println("你的成绩相当不错！");
			}else if (s>80) {
				System.out.println("还不错，继续加油！");
			}
			else if (s>70) {
				System.out.println("你还可以做的更好！");
			}
			else if (s>60) {
				System.out.println("及格万岁！");
			}
			else {
				System.out.println("要努力啊，你不及格！");
			}

}
}