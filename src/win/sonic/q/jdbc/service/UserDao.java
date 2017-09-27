package win.sonic.q.jdbc.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import win.sonic.q.jdbc.vo.User;

public class UserDao extends MySqlDao {
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 添加顾客
	 * 
	 * @param name
	 *            顾客姓名
	 * @return
	 */
	public int addUser(User use) {
		try {
			// INSERT INTO `user`
			// VALUES(1userid,2uname,3id,4birthday,5address,6tel)
			ps = con.prepareStatement("INSERT INTO `user` VALUES(?,?,?,str_to_date(?,'%Y%m%d'),?,?)");
			ps.setInt(1, use.getUserid());
			ps.setString(2, use.getUname());
			ps.setString(3, use.getId());
			ps.setString(4, use.getBirthday());
			ps.setString(5, use.getAddress());
			ps.setString(6, use.getTel());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 向购物车商品添加用户id
	 * 
	 * @param use
	 *            用户
	 * @return 修改结果
	 */
	public int goodsToUser(int userid) {
		try {
			ps = con.prepareStatement("UPDATE carts SET userid = ? WHERE userid is NULL");
			ps.setInt(1, userid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public int delGoods(int id) {
		return 0;
	}

	/**
	 * 清空顾客名单 *
	 * 
	 * @return 清空数目
	 */
	public int clean() {
		try {
			ps = con.prepareStatement("TRUNCATE table user");
			// 同时清空用户自增ID
			User.setNum(100000);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 输出单个用户信息抬头
	 * 
	 * @param userid
	 *            用户会员卡号
	 * @param b
	 *            是否输出会员信息(输出true,不输出仅返回false)
	 * @return 用户信息(1userid,2uname,3id,4birthday,5address,6tel)
	 */
	public ResultSet showUser(int userid, Boolean b) {
		// 1userid,2uname,3id,4birthday,5address,6tel
		try {
			ps = con.prepareStatement("SELECT * from `user` where userid= ?");
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			// 循环输出用户信息
			if (b) {
				
				while (rs.next()) {
					System.out.println("会员卡号:" + rs.getInt(1) + "\t会员姓名:" + rs.getString(2));
					System.out.println("========================================");
				}
				if (!rs.previous()) {
					System.out.println("没有该会员!");
				}
			}
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 展示全部用户信息
	 */
	public void showUser() {
		// 1userid,2uname,3id,4birthday,5address,6tel
		try {
			ps = con.prepareStatement("SELECT * from `user`");
			rs = ps.executeQuery();
			// 如果有用户,输入用户信息抬头
			if (rs.next()) {
				System.out.println("会员卡号\t用户姓名\t用户证件号\t\t用户生日\t\t用户电话");
				rs.previous();
			}
			// 循环输出用户信息
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(6) + "\t");
				System.out.println("地址:" + rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户输出购物车
	 * @param userid 用户id
	 */
	public void showUserCarts(int userid){
		CartsDao cd = new CartsDao();		
		try {
			ps = con.prepareStatement("SELECT c.productid,g.name,g.price,c.count,u.uname from goods g join carts c on g.id=c.id join   `user` u on c.userid=u.userid where u.userid=?");
			ps.setInt(1, userid);
			ResultSet r1= ps.executeQuery();
			showUser(userid, true);
			cd.showCarts(r1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 清空指定用户购物车
	 * @param userid 用户会员卡号
	 * @return 操作结果
	 */
	public int cleanUserCarts(int userid) {
		try {
			ps = con.prepareStatement("DELETE FROM carts WHERE userid=?");
			ps.setInt(1, userid);			
			int delnum = ps.executeUpdate();
			System.out.println("已删除"+delnum+"件商品!");
			return delnum;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static void main(String[] args) {
		// 清空用户列表
		UserDao d = new UserDao();
		// d.clean();
		// d.showUser();
		//d.showUser(1, true);
		d.showUserCarts(1);
	}
}
