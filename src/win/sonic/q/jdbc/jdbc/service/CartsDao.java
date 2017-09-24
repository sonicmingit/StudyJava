package win.sonic.q.jdbc.jdbc.service;

import java.sql.*;
import java.util.Scanner;

import com.chinasofti.jdbc.vo.CartsGoods;
import com.chinasofti.jdbc.vo.Goods;

public class CartsDao extends MySqlDao {
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void shopping() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要购买物品编号!");
		int id = in.nextInt();
		System.out.println("请输入购买数量!");
		int count = in.nextInt();
		addGoods(id, count);
	}

	/**
	 * 添加购物车
	 * 
	 * @param id
	 *            商品编号
	 * @param count
	 *            商品数量
	 * @return
	 */
	public int addGoods(int id, int count) {
		try {
			// 如果有直接更新数量
			if (findGoods(id).next()) {
				ps = con.prepareStatement("update carts set count=count+? where id=?");
				ps.setInt(1, count);
				ps.setInt(2, id);
				return ps.executeUpdate();

			} // 如果没有添加
			else {
				ps = con.prepareStatement("insert into carts(id,count) values (?,?)");
				ps.setInt(1, id);
				ps.setInt(2, count);
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delGoods(int id) {
		return 0;
	}

	/**
	 * 通过商品编号查找商品
	 * 
	 * @param id
	 *            商品编号
	 * @return 商品信息
	 */
	public ResultSet findGoods(int id) {
		try {
			ps = con.prepareStatement("SELECT id,productid,count from carts where id=?");
			ps.setInt(1, id);
			return ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("没有此商品!");
			return null;
		}
	}

	/**
	 * 展示购物车物品
	 * 
	 * @return 展示购物车所有商品
	 */
	public ResultSet showGoods() {
		try {
			ps = con.prepareStatement(
					"SELECT c.productid,g.name,g.price,c.count from goods g join carts c on g.id=c.id; ");
			rs = ps.executeQuery();
			showCarts(rs);			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("购物车没有商品,请先添加商品!");
			return null;
		}
	}

	/**
	 * 根据商品展示购物车
	 * @param rs 查询商品信息
	 */
	public void showCarts(ResultSet rs){
		try {
			if (rs.next()) {
				System.out.println("序号\t商品名称\t商品单价\t商品数量\t");
				rs.previous();		
		// 循环输出商品:
		while (rs.next()) {
			System.out.println(
					rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "元\t" + rs.getString(4) + "件\t");
		}
		System.out.println("----------------------------------------------");
		// 输出分类商品:
		ps = con.prepareStatement(
				"select g.type,SUM(c.count) from carts c join goods g on c.id=g.id GROUP by g.type");
		rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("<" + rs.getString(1) + ">\t共有" + rs.getInt(2) + "件");
		}
		System.out.println("----------------------------------------------");
		// 统计共有多少件商品
		ps = con.prepareStatement("select SUM(count) from carts");
		rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("\t\t\t\t共有" + rs.getInt(1) + "件商品");
		}
		// 输出总价,通过SQL语句计算总价
		ps = con.prepareStatement("select sum(g.price*c.count) from carts c join goods g on c.id=g.id");
		rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("\t\t\t\t总价:" + rs.getInt(1) + "元");
		}
			}else {
				System.out.println("购物车是空的,请先添加物品!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 清空购物车
	 * 
	 * @return
	 */
	public int clean() {
		try {
			ps = con.prepareStatement("TRUNCATE table carts");
			int delnum = ps.executeUpdate();
			System.out.println("已删除"+delnum+"件商品!");
			return delnum;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	public static void main(String[] args) {
		//清空购物车
		CartsDao c = new CartsDao();
		c.clean();
	}
}
