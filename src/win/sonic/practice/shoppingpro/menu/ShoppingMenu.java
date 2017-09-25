package win.sonic.practice.shoppingpro.menu;

import java.sql.ResultSet;

import win.sonic.practice.shoppingpro.dao.*;
import win.sonic.practice.shoppingpro.vo.*;

/**
 * 购物操作菜单
 * 
 * @author 郝一鸣
 *
 */
public class ShoppingMenu extends Menu {
	//用户会员卡号
	private int user_id;
	/*购物车管理员菜单预留*/
	//public void sysCartsMenu();
	/*购物车管理员菜单预留*/

	/*综合购物菜单*/
	public void shoppingMenu() {
		//输出购物菜单
		Boolean y = true;
		do {
			System.out.println("请输入选择开始体验购物:1.开始购物; 2.查看购物车; 3.清空购物车; 4.查看商品列表; 5.结束购物.");
			hr();
			//选择 执行		
			switch (in.next()) {
			case "1":
				System.out.println("欢迎开始购物,购物期间随时输入0停止购物");
				int go = 1;
				while (go != 0) {
					go = addGoodsToCart();
				}
				hr();
				System.out.println("感谢您购物,返回菜单中...");
				hr();
				break;
			case "2":
				viewCart();
				hr();
				System.out.println("返回菜单中...");
				hr();
				break;
			case "3":
				cleanCart();
				hr();
				break;
			case "4":
				gd.showGoods();
				hr();
				break;
			case "5":
				viewCart();
				hr();
				System.out.println("感谢您的光临,欢迎下次光临!");
				y = false;
				break;
			default:
				System.out.println("暂时还没此选项,请重新输入!");
				hr();
				y = true;
				break;
			}
		} while (y);
	}

	/*菜单选项*/
	/**
	 * 1.开始购物菜单
	 * 
	 * @return int 输入的物品编号,返回0跳出购物
	 */
	public int addGoodsToCart() {
		int id = 0, count = 0;
		System.out.println("请输入要购买物品编号(0结束购买):");
		step1: while (true) {
			try {
				id = in.nextInt();
				break step1;
			} catch (Exception e) {
				System.out.println("请输入一个正确的数字");
			}
		}
		if (id == 0) {
			return 0;
		}
		System.out.println("请输入购买数量!");
		step2: while (true) {
			try {
				count = in.nextInt();
				break step2;
			} catch (Exception e) {
				System.out.println("请输入一个正确的数字");
			}
		}
		//调用添加购物车方法
		cd.addGoods(id, count, user_id);
		//返回最后输入的数字
		return id;
	}

	/**
	 * 2.查看用户购物车商品及价格
	 */
	public void viewCart() {
		//输出用户信息
		System.out.println("用户:" + u.getUname() + "\t会员卡号:" + u.getUserid());
		hr();
		//获取用户购物车商品表格
		ResultSet rs1 = cd.showCarts(user_id);
		Object[][] obj1 = JDBC.returnResultSet(rs1);
		//获取用户结算表格
		ResultSet rs2 = cd.accountCarts(user_id);
		Object[][] obj2 = JDBC.returnResultSet(rs2);
		//输出用户结算表格
		if (obj1.length + obj2.length > 0) {
			System.out.println("序号\t商品名称\t单价/元\t数量/件\t类别");
			hr();
			Menu.showForm(obj1);
			hr();
			System.out.println("类别\t数量/件\t价格/元");
			Menu.showForm(obj2);
		} else {
			System.out.println("您的购物车没有商品,请先添加商品!");
		}
	}

	/**
	 * 3.清除当前用户购物车
	 */
	public void cleanCart() {
		int num = cd.clean(user_id);
		if (num > 0) {
			System.out.println("您的购物车商品已清空,删除了" + num + "件商品!");
		} else {
			System.out.println("您的购物车是空的,不需要清空!");
		}
	}

	/**
	 * 创建购物菜单
	 * 
	 * @param u
	 *            操作用户
	 */
	public ShoppingMenu(User u) {
		super();
		this.u = u;
		//获取user_id
		this.user_id = u.getUserid();
	}

	public static void main(String[] args) {
		//UserDao d = new UserDao();
		//User u = d.returnUser(100003);
		//ShoppingMenu s = new ShoppingMenu(u);
	}
}
