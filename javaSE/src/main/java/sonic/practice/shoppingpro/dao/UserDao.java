package sonic.practice.shoppingpro.dao;

import sonic.practice.shoppingpro.menu.Menu;
import sonic.practice.shoppingpro.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户表连接数据库的操作方法
 * 
 * @author 郝一鸣
 *
 */
public class UserDao extends JDBC {
	/**
	 * 添加顾客
	 * 
	 * @param
	 *
	 * @return int 操作结果
	 */
	public int addUser(User use) {
		// INSERT INTO `user`
		// VALUES(1userid,2uname,3id,4birthday,5address,6tel)
		/*str_to_date(?,'%Y%m%d')是MySql语句,Orcale为to_date(?,'%Y%m%d') 后期可以加判断添加oracle*/
		sql = "INSERT INTO `user` VALUES(?,?,?,str_to_date(?,'%Y%m%d'),?,?)";
		Object[] obj = { use.getUserid(), use.getUname(), use.getId(), use.getBirthday(), use.getAddress(),
				use.getTel() };
		return executeUpdate(sql, obj);
	}

	/**
	 * 删除指定用户
	 * 
	 * @param userid
	 *            用户会员卡号
	 * @return int 操作结果
	 */
	public int delUser(int userid) {
		sql = "DELETE FROM `user` where userid = ?";
		Object[] obj = { userid };
		return executeUpdate(sql, obj);
		//System.out.println("成功删除会员卡号为"+userid+"的用户");
	}

	/**
	 * 清空顾客名单 
	 * 
	 * @return int 清空数目
	 */
	public int clean() {
		sql = "TRUNCATE table user";
		// 同时清空用户自增ID
		User.setNum(100000);
		return executeUpdate(sql, null);
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
		sql = "SELECT * from `user` where userid= ?";
		Object[] obj = { userid };
		rs = executeQuery(sql, obj);
		Object[][] objout = returnResultSet(rs);
		// 循环输出用户信息
		if (b) {
			if (objout != null) {
				System.out.println("会员卡号\t会员姓名\t");
				Menu.showForm(objout);
				System.out.println("========================================");
			}
			return rs;
		} else {
			System.out.println("没有该会员!");
			return null;
		}
	}

	/**
	 * 展示全部用户信息(管理员)
	 */
	public void showUserSys() {
		// 1userid,2uname,3id,4birthday,5address,6tel
		sql = "SELECT * from `user`";
		rs = executeQuery(sql, null);
		Object[][] obj = returnResultSet(rs);
		// 如果有用户,输入用户信息抬头
		if (obj != null) {
			System.out.println("会员卡号\t姓名\t\t证件号\t\t\t生日\t\t电话\t地址");
			// 循环输出用户信息
			Menu.showForm(obj);
		}
	}

	/**
	 * 展示全部用户卡号,姓名信息
	 */
	public void showUser() {
		// 1userid,2uname,3id,4birthday,5address,6tel
		sql = "SELECT userid,uname from `user`";
		rs = executeQuery(sql, null);
		Object[][] obj = returnResultSet(rs);
		// 如果有用户,输入用户信息抬头
		if (obj.length > 0) {
			System.out.println("会员卡号\t姓名\t");
			// 循环输出用户信息
			Menu.showForm(obj);
		}
	}

	/**
	 * 从数据库读取一个用户
	 * 
	 * @param userid
	 *            用户会员卡号
	 * @return User 用户类
	 */
	public User returnUser(int userid) {
		sql = "SELECT uname,id,address,tel from `user` where userid= ?";
		Object[] obj = { userid };
		rs = executeQuery(sql, obj);
		try {
			while (rs.next()) {
				//防止未设置id用户
				String id = null;
				if (rs.getLong(2) == 0) {
				} else {
					id = rs.getLong(2) + "";
				}
				//String uname, String id, String address, String tel
				User u = new User(rs.getString(1), id, rs.getString(3), rs.getString(4));
				u.setUserid(userid);
				u.setNum(u.getNum() - 1);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {		
		//UserDao d = new UserDao();
	
	}
}
