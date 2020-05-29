package sonic.practice.shoppingpro.menu;

import sonic.practice.shoppingpro.dao.CartsDao;
import sonic.practice.shoppingpro.dao.GoodsDao;
import sonic.practice.shoppingpro.dao.UserDao;
import sonic.practice.shoppingpro.vo.Goods;
import sonic.practice.shoppingpro.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 综合菜单和菜单公用方法
 * 
 * @author 郝一鸣
 *
 */
public class Menu {
	//输出项
	protected Scanner in = new Scanner(System.in);
	//购物车操作菜单
	protected CartsDao cd = new CartsDao();
	//商品操作菜单
	protected GoodsDao gd = new GoodsDao();
	//用户操作菜单
	protected UserDao ud = new UserDao();
	//商品类
	protected Goods g = new Goods();
	//用户类
	protected User u = new User();

	/*管理员综合菜单预留*/
	//public void sysMenu();
	/*管理员综合菜单预留*/
	/**
	 * 对齐输出表二维数组
	 * 
	 * @param obj
	 *            导入表数据的二维数组
	 * @return int 操作结果,1成功输出,0未输出
	 */
	public static int showForm(Object[][] obj) {
		if (obj.length > 0) {
			for (Object[] o2 : obj) {
				for (Object o1 : o2) {
					System.out.print(o1 + "\t");
				}
				System.out.println("");
			}
			return 1;
		}
		return 0;
	}

	/**
	 * 输出rs表头
	 * 
	 * @param rs
	 *            数据库一张表
	 * @throws SQLException
	 */
	public static void showFormHead(ResultSet rs) {
		try {
			if (rs.next()) {
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getMetaData().getColumnName(i + 1) + "\t");
				}
			}
			System.out.println("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭所有打开的接口
	 */
	public void closeAll() {
		try {
			//关闭连接数据库接口
			gd.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭输入接口
		in.close();
	}

	/**
	 * 输出换行
	 */
	public void hr() {
		System.out.println("----------------------------------------");
	}
}
