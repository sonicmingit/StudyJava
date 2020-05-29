package sonic.q.jdbc.service;

import sonic.practice.shoppingpro.vo.Goods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GoodsDao extends MySqlDao {
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 添加商品
	 * 
	 * @param g 要添加的商品
	 * @return 操作结果
	 */
	public int addGoods(Goods g) {
		try {
			ps = con.prepareStatement("insert into goods(name,price,type) values (?,?,?)");
			ps.setString(1, g.getName());
			ps.setInt(2, g.getPrice());
			ps.setString(3, g.getType());
			// 执行
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("添加商品失败!");
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public int delGoods(int id) {
		try {
			ps = con.prepareStatement("DELETE FROM Goods WHERE id=?");
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("没有此商品,删除失败!");
			e.printStackTrace();
			return -1;
		}
	}

	/*
	 * public int updateGoods(Goods g) { }
	 */

	/**
	 * 查找商品
	 * 
	 * @param id
	 *            商品id
	 * @return 商品信息(商品编号,商品名称,商品价值,商品类型)
	 */
	public ResultSet findGoods(int id) {
		try {
			ps = con.prepareStatement("SELECT id,name,price,type from goods where id= ?");
			ps.setInt(1, id);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("没有此商品!");
			return null;
		}
	}

	/**
	 * 展示商品列表
	 */
	public ResultSet showGoods() {
		try {
			ps = con.prepareStatement("SELECT id,name,price,type from goods");
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("商品编号\t商品名称\t商品价格\t商品类型\t");
				rs.previous();
			}
			// 循环输出商品
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("price") + "\t"
						+ rs.getString("type") + "\t");
			}
			System.out.println("----------------------------------------------");
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("目前没有商品列表,请添加商品!");
			return null;
		}
	}

	/**
	 * 清空商品列表
	 * 
	 * @return 操作参数
	 */
	public int clean() {
		try {
			ps = con.prepareStatement("TRUNCATE table goods");
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 关闭所有
	 */
	public void closeAll() {
		close(rs);
		close(ps);
		close(con);
	}

	public static void main(String[] args) {
		GoodsDao g  = new GoodsDao();
		g.clean();
	}
	
}
