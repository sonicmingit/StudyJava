package sonic.q.jdbc.view;

import sonic.practice.shoppingpro.dao.CartsDao;
import sonic.practice.shoppingpro.dao.GoodsDao;
import sonic.practice.shoppingpro.vo.Goods;
import sonic.q.jdbc.service.UserDao;

import java.sql.SQLException;
import java.util.Scanner;


public class Test {
	static GoodsDao a = new GoodsDao();
	static CartsDao c = new CartsDao();
	static UserDao u = new UserDao();
	static Scanner in = new Scanner(System.in);
	// static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		// 1.开始购物
		// 2.不购物,走人
		startShopping(1);

	}

	/**
	 * 判断并展示购物车
	 */
	public static void showGoods() {
		try {
			if (!a.showGoods().previous()) {
				addGoods();
				a.showGoods();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加商品
	 */
	public static void addGoods() {
		Goods[] g = { new Goods("可口可乐", 3, "饮料"), new Goods("安佳牛奶", 10, "饮料"), new Goods("锤子手机", 2399, "数码"),
				new Goods("雪碧", 2, "饮料"), new Goods("红薯", 1, "食品"), new Goods("面包", 2, "食品"),
				new Goods("面条", 5, "食品") };

		for (int i = 0; i < g.length; i++) {
			a.addGoods(g[i]);
		}

	}

	public static void startShopping(int userid) {
		String use; 
		// 1.查看商品
		showGoods();
		// 2.开始购物
		System.out.println("开始购物喽!");
		
		while (true) {
			System.out.println("请输入操作:\n-c.开始/继续购物,\n-s.查看商品,\n-e.查看购物车,\n-0.清空购物车");
			use= in.next();
			if (use.equals("c")) {
			c:	while (true) {					
					System.out.println("请输入要购买物品编号!");
					use = in.next();
					if(use.equals("s")||use.equals("e")||use.equals("0")){break c;}
					System.out.println("请输入购买数量!");
					int count = in.nextInt();
					c.addGoods(Integer.valueOf(use), count);
					
				}
				u.goodsToUser(userid);
			}
			// 查看商品
			if (use.equals("s")) {
				showGoods();
				continue;
			}
			// 查看购物车
			if (use.equals("e")) {
				u.showUserCarts(userid);
				continue;
			}
			// 清空购物车
			if (use.equals("0")) {
				u.cleanUserCarts(userid);
				continue;
			}
		}
	}
}
