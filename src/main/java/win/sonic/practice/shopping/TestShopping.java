package win.sonic.practice.shopping;

import java.util.Scanner;

public class TestShopping {
	// 创建一个泛型添加到购物车的对象
	private static AddCartFan<Goods> item = new AddCartFan<Goods>();
	// 创建Cart的库存数组和购物车数组,方便输入
	// private static ArrayList<Goods> cart = item.getCart();
	// private static ArrayList<Goods> myCart = item.getMyCart();

	/**
	 * 封装添加物品到购物车的方法
	 * 
	 * @param c
	 *            商品库存编号
	 * @param num
	 *            添加商品数量
	 */
	public static void addMyCarts(int c, int num) {
		// 判断如果购物车存在此件商品,直接设置数量
		if (item.getMyCart().contains(item.getCart().get(c - 1))) {
			item.getCart().get(c - 1).setNum(num);
		} else {
			item.addCart(item.getCart().get(c - 1));
			item.getCart().get(c - 1).setNum(num);
		}
	}

	/**
	 * 往商品库添加库存
	 */
	public static void addGoods() {
		item.addGoods(new Drinks("可乐", 3));
		item.addGoods(new Drinks("雪碧", 2));
		item.addGoods(new Drinks("冰峰", 4));
		item.addGoods(new Digital("锤子手机", 3000));
		item.addGoods(new Digital("苹果电脑", 3000));
		item.addGoods(new Ball("足球", 129));
		item.addGoods(new Ball("篮球", 229));
		item.addGoods(new Ball("乒乓球", 5));
		item.addGoods(new StringData("字符串", 999));
		item.addGoods(new BasicData("整型", 10));
		item.addGoods(new BasicData("浮点型", 111));
		item.addGoods(new Digital("XPS", 7899));
		item.addGoods(new StringData("郝一鸣", 99999));
		// 展示商品库
		// item.showCart();
	}

	public static void main(String[] args) {
		// 创建库存
		addGoods();
		// 创建输入
		Scanner in = new Scanner(System.in);
		// 接收开始输入
		String start;
		// 接受商品编号或者指令
		String u = null;
		// 用于后期商品输入字符串转换成整型
		int u1 = 0;
		// 接受商品数量
		int n = 0;
		// 展示现有商品
		System.out.println("欢迎来到本商场,以下是本商场现有的商品列表:");
		System.out.println("----------------------------------------");
		item.showCart();
		// 购物是否开始
		System.out.println("您是否需要开始购物?y/n");
		start = in.next();
		if (start.equals("y")) {
			System.out.println("购物期间可以随时输入:\n\"show\":查看商品列表;\n\"exit\":结算购物车.");
			lab1: while (true) {
				// 判断输入商品编号时是否出错,并包含查看商品列表show和结算exit的命令
				lab2: while (true) {
					try {
						// 输入商品编号
						System.out.println("请输入您要加入购物车的产品编号:");
						// in = new Scanner(System.in);
						u = in.next();
						// 如果用户忘记商品清单,输入show重新展示商品清单
						if (u.equals("show")) {
							item.showCart();
							continue;
						}
						// 购物完毕输入exit跳出购物阶段,直接结算
						if (u.equals("exit")) {
							break lab1;
						}
						// 如果输入的是商品编号,转换成整型
						u1 = Integer.parseInt(u);
						//临时商品类
						Goods temp = item.getCart().get(u1 - 1);
						System.out.println("商品介绍:");
						//if(temp instanceof IHowDrink ){System.out.println();}
						System.out.println("请输入您要加入<" + temp.getName() + ">的数量");
						break lab2;
					} catch (Exception e) {
						// 获取异常,提示输入错误,重新输入
						System.out.println("您输入的编号不对,请重新输入!");
					}
				}
				// 判断输入商品数量时是否出错!
				lab3: while (true) {
					try {
						in = new Scanner(System.in);
						n = in.nextInt();
						break lab3;
					} catch (Exception e) {
						System.out.println("您输入正确的数量!");
					}
				}
				// 根据用户输入,将商品加入购物车,u1是商品编号,n是数量!
				addMyCarts(u1, n);
			}
			// 结算购物车
			item.showMyCart();
			System.out.println("-----------感谢购物,期待您的下次光临!-----------");
			in.close();
		} else {
			System.out.println("感谢光临,期待您的下次光临!");
			in.close();
		}

		/* 伪代码思路 */
		// 从商品库添加到购物车,并设置数量
		// 结算商品
		// 获取商品类购买总数
		// 选择行为:1.查看商品;2.添加商品到购物车
		// 选择添加几号商品,多少件; 停止按几... (商品库编号转入购物车,在用setnum设置数量)
		// 展示购物车商品和结算清单;
		/* 未加入功能 */
		// 确认与否,是否需要删除商品.(Cart删除方法已完成,懒得加进去了)
		// 不删除,购物结束
		// 扩展还有正常非正常商品总数(这两个类再各加入一个HashSet)
		// 清空购物车
	}
}
