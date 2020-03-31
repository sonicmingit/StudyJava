package sonic.b.processcontrol;
import java.util.Scanner;

/*dowhile练习题:11.11,3家耐克店打折,每家店每人最多买3件衣服,小王刚发了工资,去买衣服,但是只能买5件。请问小王逛了几家店了几件衣服。
	譬如:
	您现在进入的是第一家店:
	服务员问:先生您买衣服吗? 是
	购买一件衣服成功
	服务员问:先生您还继续购买吗? 是
	购买一件衣服成功
	服务员问:先生您还继续购买吗? 是
	购买一件衣服成功
	您现在进入的是第二家店
	服务员问:先生您买衣服吗? no
	您现在进入的是第三家店
	服务员问:先生您买衣服吗? no
	小王一共逛了3三家店,买了3件衣服！*/

public class P_buy {

	public static void main(String[] args) {
		int num = 0;
		int store = 0;
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		String buy;
		Scanner input = new Scanner(System.in);
		System.out.println("您现在进入第一家店！");
		while (true) {
			if (num >= 5) {
				System.out.println("您在本家店购买的衣服已经超限，欢迎您下次光临！");
				break;
			}
			System.out.println("您买衣服吗？y/n");
			buy = input.nextLine();
			if (buy.equals("y")) {
				++num;
				++s1;
				System.out.println("购买一件衣服成功！");
				while (true) {
					if (s1 >= 3) {
						System.out.println("您已在本家店购买超限了，请进入下一家店");
						break;
					}
					if (num >= 5) {
						System.out.println("您在本商场购买的衣服已经超限，欢迎您下次光临！");
						break;
					}
					System.out.println("您还需要在购买一件衣服吗？y/n");
					buy = input.nextLine();
					if (buy.equals("y")) {
						++num;
						++s1;
					} else if (buy.equals("n")) {
						break;
					} else {
						System.out.println("输入错误，请重新输入：");
						System.out.println("-------------------------");
					}
				}

				break;
			} else if (buy.equals("n")) {
				break;
			} else {
				System.out.println("输入错误！！！");
				System.out.println("-------------------------");
			}
		}

		// 如果在第一家店买衣服了，算是逛过这家店，如果没买，算没逛过。
		if (s1 > 0)
			store++;
		// 第二家店购物开始
		System.out.println("-------------------------");
		System.out.println("您现在进入第二家店！");
		// 开始重复上一个循环
		while (true) {
			if (num >= 5) {
				System.out.println("您在本商场购买的衣服已经超限，欢迎您下次光临！");
				break;
			}
			System.out.println("您买衣服吗？y/n");
			buy = input.nextLine();
			if (buy.equals("y")) {
				++num;
				++s2;
				System.out.println("购买一件衣服成功！");
				while (true) {
					if (s2 >= 3) {
						System.out.println("您已在本家店购买超限了，请进入下一家店");
						break;
					}
					if (num >= 5) {
						System.out.println("您在本商场购买的衣服已经超限，欢迎您下次光临！");
						break;
					}
					System.out.println("您还需要在购买一件衣服吗？y/n");
					buy = input.nextLine();
					if (buy.equals("y")) {
						++num;
						++s2;
					} else if (buy.equals("n")) {
						break;
					} else {
						System.out.println("输入错误，请重新输入：");
						System.out.println("-------------------------");
					}
				}

				break;
			} else if (buy.equals("n")) {
				break;
			} else {
				System.out.println("输入错误！！！");
				System.out.println("-------------------------");
			}
		}
		if (s2 > 0)
			store++;

		// 第三家店购物开始
		System.out.println("-------------------------");
		System.out.println("您现在进入第三家店！");
		// 继续循环
		while (true) {
			if (num >= 5) {
				System.out.println("您在本家店购买的衣服已经超限，欢迎您下次光临！");
				break;
			}
			System.out.println("您买衣服吗？y/n");
			buy = input.nextLine();
			if (buy.equals("y")) {
				++num;
				++s3;
				System.out.println("购买一件衣服成功！");
				while (true) {
					if (s3 >= 3) {
						System.out.println("您已在本家店购买超限了，请进入下一家店");
						break;
					}
					if (num >= 5) {
						System.out.println("您在本家店购买的衣服已经超限，欢迎您下次光临！");
						break;
					}
					System.out.println("您还需要在购买一件衣服吗？y/n");
					buy = input.nextLine();
					if (buy.equals("y")) {
						++num;
						++s3;
					} else if (buy.equals("n")) {
						break;
					} else {
						System.out.println("输入错误，请重新输入：");
						System.out.println("-------------------------");
					}
				}

				break;
			} else if (buy.equals("n")) {
				break;
			} else {
				System.out.println("输入错误！！！");
				System.out.println("-------------------------");
			}
		}
		if (s3 > 0)
			store++;

		System.out.println("--------------------");
		System.out.println("下面是您的购物记录：");
		System.out.println("您一共买了" + num + "衣服；逛了" + store + "家店！");
		System.out.println("第一家店买了" + s1 + "件衣服；第二家店买了" + s2 + "件衣服；第二家店买了" + s3 + "件衣服！");

	}

}
