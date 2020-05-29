package sonic.practice.shoppingpro.view;

import sonic.practice.shoppingpro.dao.JDBC;
import sonic.practice.shoppingpro.menu.GoodsMenu;
import sonic.practice.shoppingpro.menu.ShoppingMenu;
import sonic.practice.shoppingpro.menu.UserMenu;

public class Test {
	public static void main(String[] args) {
		JDBC.LinkMySql();
		//创建商品菜单
		GoodsMenu gm = new GoodsMenu();
		//创建用户菜单
		UserMenu um = new UserMenu();
		//输出选择用户菜单,同时创建购物菜单
		ShoppingMenu sm = new ShoppingMenu(um.ChooseUser());
		//输出商品列表
		gm.showGoods();
		//输出购物菜单
		sm.shoppingMenu();
		//关闭所有接口
		sm.closeAll();
	}
}
