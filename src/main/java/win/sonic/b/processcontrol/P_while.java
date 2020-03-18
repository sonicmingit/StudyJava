package win.sonic.b.processcontrol;
/*
 * while练习题:接受键盘的输入,如果输入的exit就退出，否则提示用户继续输入!
	知识点:
	 1)终止循环用break
 	 2)break continue区别? break跳出整个循环,continue	结束本次循环继续下一次循环

 */
import java.util.Scanner; 
public class P_while {

	public static void main(String[] args) {
		//while练习题：
		//接受键盘的输入，如果输入exit就退出，否则要求用户继续输出
		Scanner scan = new Scanner(System.in);
/**
 * 用switch判读输入跳出循环
 * case值满足输入时利用lable跳出while循环
 * default不跳出循环，当输入值都不满足时循环继续
 */
		lab:while(true){
			System.out.println("请输入：");				
			String input = scan.next();			
			switch (input) {
			case "exit":				
				break lab;
			default:
			}
			System.out.println("输入错误，请继续输入：");	
		}

	}

}