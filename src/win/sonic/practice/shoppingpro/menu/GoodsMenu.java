﻿package win.sonic.practice.shoppingpro.menu;

import java.sql.SQLException;

import win.sonic.practice.shoppingpro.vo.Goods;
import win.sonic.practice.shoppingpro.dao.GoodsDao;

/**
 * 商品库操作菜单
 * @author 郝一鸣
 *
 */
public class GoodsMenu extends Menu {
	/*库存商品管理员菜单*/
	GoodsDao gd = new GoodsDao();
	/**
	 * 管理员管理商品
	 */
	public void sysGoodsMenu() {
		menu: while (true) {
			System.err.println("您已进入管理员菜单: ");
			System.err.println("-1.查看目前商品-");
			System.err.println("-2.自动添加商品-");
			System.err.println("-3.手动添加商品-");
			System.err.println("-4.补货-"); 
			//System.err.println("-删除指定商品-"); 
			//System.err.println("-清空商品-"); 
			System.err.println("-0.结束操作-");
			hr();
			switch (in.next()) {
			case "1":
				gd.showGoods();
				hr();
				break;
			case "2":
				addGoodsAuto();
				hr();
				break;
			case "3":
				System.out.println("此功能正在开发中...");
				//addGoodsByM();
				hr();
				break;
			case "4":
				System.out.println("请输入要补库存的件数:");
				addGoodsStock(in.nextInt());
				hr();
				break;
			case "0":
				System.out.println("您已离开管理员菜单!");
				break menu;
			default:
				System.out.println("目前还没有此选项,请重新选择!");
				hr();
				break;
			}
		}
	}

	/**
	 * 1.判断并展示商场商品
	 */
	public void showGoods() {
		System.out.println("以下是目前现有的商品,欢迎选购!");
		hr();
		try {
			//先判断商品库是否有商品
			if (!gd.showGoods().previous()) {
				//如果没有先添加商品,在展示
				addGoodsAuto();
				gd.showGoods();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		hr();
	}

	/*以下是管理员菜单*/
	/**
	 * 2.管理员补货
	 * 
	 * @param n
	 *            一次补货件数
	 */
	public void addGoodsStock(int n) {
		int num = gd.addGoodsStock(n);
		if (num > 0) {
			System.err.println("成功给" + num + "件商品补货,各补货" + n + "件.");
		} else {
			System.out.println("货源充足,没有商品需要补货!");
		}
	}

	/**
	 * 1.管理员添加商品
	 */
	public void addGoodsAuto() {
		Goods[] g = { new Goods("可口可乐", 3, "饮料"), new Goods("安佳牛奶", 10, "饮料"), new Goods("锤子手机", 2399, "数码"),
				new Goods("雪碧", 2, "饮料"), new Goods("红薯", 1, "食品"), new Goods("面包", 2, "食品"),
				new Goods("面条", 5, "食品") };
		for (int i = 0; i < g.length; i++) {
			gd.addGoods(g[i]);
		}
		System.out.println("成功添加" + g.length + "件商品");
		//添加完商品后补库存
	}

	public static void main(String[] args) {
		GoodsMenu gm = new GoodsMenu();
	
		//gm.addGoodsStock(10);
		gm.sysGoodsMenu();
	}
}
