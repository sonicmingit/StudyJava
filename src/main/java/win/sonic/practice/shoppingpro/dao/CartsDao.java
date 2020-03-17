﻿package win.sonic.practice.shoppingpro.dao;

import java.sql.*;
import win.sonic.practice.shoppingpro.dao.JDBC;

/**
 * 购物车表连接数据库的操作方法
 * 
 * @author 郝一鸣
 *
 */
public class CartsDao extends JDBC {
	//商品方法类
	private GoodsDao g = new GoodsDao();

	/**
	 * 商品添加到购物车
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            商品数量
	 * @return 操作结果
	 */
	public int addGoods(int id, int count) {
		//判断库存是否足够
		if (judgeStock(id, count)) {
			// 如果有直接更新数量
			try {
				if (findGoods(id).next()) {
					return updateGood(id, count);
				} // 如果没有添加
				else {
					return addGoods(id, count);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("操作失败");
				return -1;
			} finally {
				//商品库存能减少
				g.subGoodsStock(id, count);
			}
		} else {
			System.out.println("库存不足,无法添加!");
			return 0;
		}
	}

	/**
	 * 根据用户把商品添加到购物车
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            商品数量
	 * @param user_id
	 *            用户会员卡号
	 * @return int 操作结果
	 */
	public int addGoods(int id, int count, int user_id) {
		//判断库存是否足够
		if (judgeStock(id, count)) {
			// 如果有直接更新数量
			try {
				if (findGoods(id, user_id).next()) {
					return updateGood(id, count, user_id);
				} // 如果没有添加
				else {
					return addNewGood(id, count, user_id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("操作失败");
				return -1;
			} finally {
				//商品库存能减少
				g.subGoodsStock(id, count);
			}
		} else {
			System.out.println("库存不足,无法添加!");
			return 0;
		}
	}

	//	删除商品的方法,预留:public int delGoods(int id);
	/**
	 * 通过商品编号查找购物车商品
	 * 
	 * @param id
	 *            商品编号
	 * @return rs 结果
	 */
	public ResultSet findGoods(int id) {
		sql = "SELECT id,productid,count from carts where id=?";
		Object[] obj = { id };
		return executeQuery(sql, obj);
	}

	/**
	 * 根据用户通过商品编号查找购物车商品
	 * 
	 * @param id
	 *            商品编号
	 * @param user_id
	 *            用户会员卡号
	 * @return rs 结果
	 */
	public ResultSet findGoods(int id, int user_id) {
		sql = "SELECT id,productid,count from carts where id=? and userid=?";
		Object[] obj = { id, user_id };
		return executeQuery(sql, obj);
	}

	/**
	 * 添加新商品
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            商品数量
	 * @return int 操作结果
	 */
	public int addNewGood(int id, int count) {
		sql = "insert into carts(id,count) values (?,?)";
		Object[] obj = { id, count };
		return executeUpdate(sql, obj);
	}

	/**
	 * 更新商品数量
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            商品数量
	 * @return 操作结果
	 */
	public int updateGood(int id, int count) {
		sql = "update carts set count=count+? where id=?";
		Object[] obj = { id, count };
		//商品库存能减少
		g.subGoodsStock(id, count);
		return executeUpdate(sql, obj);
	}

	/**
	 * 根据用户添加新商品
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            商品数量
	 * @param user_id
	 *            用户会员卡号
	 * @return int 操作结果
	 */
	public int addNewGood(int id, int count, int user_id) {
		sql = "insert into carts(id,count,userid) values (?,?,?)";
		Object[] obj = { id, count, user_id };
		return executeUpdate(sql, obj);
	}

	/**
	 * 根据用户更新商品数量
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            商品数量
	 * @param user_id
	 *            用户会员卡号
	 * @return int 操作结果
	 */
	public int updateGood(int id, int count, int user_id) {
		sql = "update carts set count=count+? where id=? and userid=?";
		Object[] obj = { id, count, user_id };
		return executeUpdate(sql, obj);
	}

	/**
	 * 判断商品库存是否足够
	 * 
	 * @param id
	 *            商品编号
	 * @param num
	 *            添加数量
	 * @return b 是否有足够的量可以添加
	 */
	public Boolean judgeStock(int id, int count) {
		if (g.checkGoodsStock(id) >= count) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户结算购物车
	 * 
	 * @param user_id
	 *            用户会员卡号
	 * @return rs 结算列表1.类型2.数量3.总价
	 */
	public ResultSet accountCarts(int user_id) {
		//输出按类型计算总价的表 
		/*MySql语句IFNULL(type,'总价')-GROUP BY type WITH ROLLUP ;Oracle语句NVL(type,'总价')-GROUP BY ROLLUP(type) */
		sql = "SELECT IFNULL(type,'总价'),sum(c.count),SUM(g.price*c.count)  FROM goods g JOIN carts c ON g.id = c.id WHERE c.userid=? GROUP BY type WITH ROLLUP";
		Object[] obj = { user_id };
		return executeQuery(sql, obj);
	}

	/**
	 * 展示购物车物品
	 * 
	 * @return rs 操作结果1.商品编号 2.名称 3.单价 4.数量
	 */
	public ResultSet showCarts() {
		sql = "SELECT c.productid,g.name,g.price,c.count from goods g join carts c on g.id=c.id; ";
		rs = executeQuery(sql, null);
		return rs;
	}

	/**
	 * 根据用户展示购物车物品
	 * 
	 * @param user_id
	 *            用户会员卡号
	 * @return rs 操作结果1.商品编号 2.名称 3.单价 4.数量
	 */
	public ResultSet showCarts(int user_id) {
		sql = "SELECT c.productid,g.name,g.price,c.count,g.type from goods g join carts c on g.id=c.id where c.userid=?";
		Object[] obj = { user_id };
		rs = executeQuery(sql, obj);
		return rs;
	}

	/**
	 * 清空所有购物车同时重置序号
	 * 
	 * @return 操作结果
	 */
	public int cleanAll() {
		sql = "TRUNCATE table carts";
		return executeUpdate(sql, null);
	}

	/**
	 * 清空指定用户购物车
	 * 
	 * @param user_id
	 *            用户会员卡号
	 * @return int 操作结果
	 */
	public int clean(int user_id) {
		sql = "DELETE FROM carts WHERE userid=?";
		Object[] obj = { user_id };
		return executeUpdate(sql, obj);
	}

	public static void main(String[] args) {
		//CartsDao cd = new CartsDao();
		//cd.cleanAll();		
	}
}
//过时代码
/*
	System.out.println("----------------------------------------------");
	// 输出分类商品:
	sql = "select g.type,SUM(c.count) from carts c join goods g on c.id=g.id GROUP by g.type";
	rs = executeQuery(sql, null);
	while (rs.next()) {
		System.out.println("<" + rs.getString(1) + ">\t共有" + rs.getInt(2) + "件");
	}
	System.out.println("----------------------------------------------");
	// 统计共有多少件商品
	sql = "select SUM(count) from carts";
	rs = executeQuery(sql, null);
	while (rs.next()) {
		System.out.println("\t\t\t\t共有" + rs.getInt(1) + "件商品");
	}
	// 输出总价,通过SQL语句计算总价
	sql = "select sum(g.price*c.count) from carts c join goods g on c.id=g.id";
	rs = executeQuery(sql, null);
	while (rs.next()) {
		System.out.println("\t\t\t\t总价:" + rs.getInt(1) + "元");
	}
	return rs;
} catch (SQLException e) {
	e.printStackTrace();
	System.out.println("购物车没有商品,请先添加商品!");
	return null;
}
*/