package win.sonic.b.processcontrol;
/**
 *  4.17学习！
 * @author Sonic
 *
 */
import java.util.Scanner; 
public class L {

	public static void main(String[] args) {
		// if语句
		int a = 0;
		if (a < 1) {
			System.out.println("a<1");
		}

		// if...else语句
		int b = 100;
		if (b > 10) {
			System.out.println("c>10");
		} else {
			System.out.println("c不大于10");
		}
		// switch语句
		double score = 61.0;
		int c = (int) score / 10;
		switch (c) {
		// case 后面跟switch后的表达式值，只能是整型、字符型、字符串，不能是判断语句
		case 10:
			System.out.println("恭喜你得了100分！");
		// 不加break会继续执行后面的语句，只到遇见break
			break;
		case 9:
			System.out.println("成绩非常不错！");
			break;
		case 8:
		case 7:
			System.out.println("还不错");
			break;
		case 6:
			System.out.println("刚及格！");
			break;
			//
		default:
			System.out.println("不及格哦！");
			break;
		}

	}

}
