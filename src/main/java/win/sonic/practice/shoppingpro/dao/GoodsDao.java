package win.sonic.practice.shoppingpro.dao;

import java.sql.*;

import win.sonic.practice.shoppingpro.vo.Goods;
import win.sonic.practice.shoppingpro.dao.JDBC;
import win.sonic.practice.shoppingpro.menu.Menu;

/**
 * 商品表连接数据库的操作方法
 * 
 * @author 郝一鸣
 *
 */
public class GoodsDao extends JDBC {
	/**
	 * 添加商品
	 * 
	 * @param g
	 *            要添加的商品
	 * @return int 操作结果
	 */
	public int addGoods(Goods g) {
		//添加商品SQL语句
		String sql = "INSERT INTO goods(name,price,type,stock) VALUES(?,?,?,?)";
		//传入商品
		Object[] obj = { g.getName(), g.getPrice(), g.getType(), g.getStock() };
		//调用语句
		return executeUpdate(sql, obj);
	}

	/**
	 * 减少商品库存
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            减少数量
	 * @return int 操作结果
	 */
	public int subGoodsStock(int id, int count) {
		String sql = "update goods SET stock =stock-?  WHERE id=?";
		Object[] obj = { id, count };
		return executeUpdate(sql, obj);
	}

	/**
	 * 删除商品
	 * 
	 * @param id
	 *            商品编号
	 * @return int 操作结果
	 */
	public int delGoods(int id) {
		sql = "DELETE FROM Goods WHERE id=?";
		Object[] obj = { id };
		return executeUpdate(sql, obj);
	}

	//更新商品 public int updateGoods(Goods g) { }
	 
	/**
	 * 通过单品编号查找商品
	 * 
	 * @param id
	 *          商品编号
	 * @return rs 商品信息(1.商品编号,2.名称,3.价值,4.类型)
	 */
	public ResultSet findGoods(int id) {
		sql = "SELECT id,name,price,type from goods where id= ?";
		Object[] obj = { id };
		return executeQuery(sql, obj);
	}

	/**
	 * 展示商品列表 
	 * @return rs 商品信息(1.商品编号,2.名称,3.价值,4.类型,5.库存)
	 */
	public ResultSet showGoods() {
		sql = "SELECT * from goods";
		rs = executeQuery(sql, null);
		Object[][] obj = returnResultSet(rs);
		if (obj != null) {
			System.out.println("商品编号\t商品名称\t商品价格\t商品类型\t商品库存");
			Menu.showForm(obj);
		} else {
			System.out.println("目前没有商品");
		}
		return rs;
	}

	/**
	 * 清空商品列表
	 * 
	 * @return int 操作参数
	 */
	public int clean() {
		String sql = "TRUNCATE table goods";
		return executeUpdate(sql, null);
	}

	/**
	 * 查看商品库存
	 * 
	 * @param id
	 *            商品编号
	 * @return int 商品库存量
	 */
	public int checkGoodsStock(int id) {
		sql = "SELECT stock from goods where id =? ";
		Object[] obj = { id };
		rs = executeQuery(sql, obj);
		try {
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 给库存小于1的商品补货
	 * 
	 * @param n
	 *            补货数
	 * @return int 补货成功商品数
	 */
	public int addGoodsStock(int n) {
		//补货商品数
		int num = 0;
		sql = "SELECT id,stock from goods";
		rs = executeQuery(sql, null);
		try {
			while (rs.next()) {
				//如果商品数小于1件,开始补货
				if (rs.getInt(2) < 1) {
					String sql = "UPDATE goods SET stock=stock+? WHERE id= ?";
					Object[] obj = { n, rs.getInt(1) };
					executeUpdate(sql, obj);
					num++;
				}
			}
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return num;
		}
	}

	public static void main(String[] args) {
		LinkMySql();
		//GoodsDao gd = new GoodsDao();
		//CartsDao cd = new CartsDao();
	}
}
