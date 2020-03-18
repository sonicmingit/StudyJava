package win.sonic.practice.shoppingpro.menu;

import java.sql.*;
import java.util.Random;

import win.sonic.practice.shoppingpro.dao.JDBC;
import win.sonic.practice.shoppingpro.vo.User;

/**
 * 用户库操作菜单
 * @author 郝一鸣
 *
 */
public class UserMenu extends Menu {
	//随机数,用来生成随机用户编号
	private Random r = new Random();
	/*用户管理员菜单预留*/
	//public void sysUserMenu();
	/*用户管理员菜单预留*/

	/*提示菜单*/
	//选择用户,先展示,在选择	
	//创建新户用流程
	//创建匿名账户 ,name=临时顾客 userid= 临时编号,  用完删除
	/**
	 * 选择用户菜单
	 * 
	 * @return User 当前用户
	 */
	public User ChooseUser() {
		boolean y = false;
		do {
			System.out.println("欢迎光临,请输入选择: 1.创建用户 ;2选择用户; 3.临时用户");
			switch (in.next()) {
			case "1":
				return createNewUser();
			case "2":
				System.out.println("目前用户有:");
				ud.showUser();
				hr();
				System.out.println("请输入您的会员卡号:");
				return ud.returnUser(Integer.parseInt(in.next()));
			case "3":
				return createTempUser();
			default:
				System.out.println("没有此选项,请重新选择!");
				hr();
				y = true;
				break;
			}
			hr();
		} while (y);
		return null;
	}

	/*创建用户的方法*/
	/**
	 * 创建一个临时用户并添加到数据库
	 * 
	 * @return User 临时用户
	 */
	public User createTempUser() {
		int id = 100000 + r.nextInt(10000);
		u = new User("临时用户");
		u.setUserid(id);
		ud.addUser(u);
		System.out.println("您是临时用户,您的临时编号是:" + id);
		hr();
		return u;
	}

	/**
	 * 根据提示创建一个新用户并添加到数据库
	 * 
	 * @return User 创建好的用户
	 */
	public User createNewUser() {
		//String uname, String id, String address, String tel		 
		System.out.println("请输入您的姓名:");
		String uname = in.next();
		System.out.println("请输入您的身份证号(跳过输入 n):");
		String id = skip(in.next());
		//如果没有跳过,判断位数
		if (id != null) {
			while (true) {
				//十八位结束循环
				if (id.length() == 18) {
					break;
				}
				//否则要求重新输入
				System.out.println("您输入的长度不对,请重新输入(长度为18位).");
				id = in.next();
				//后期需要验证,这块一错创建用户自动获取生日就错
			}
		}
		System.out.println("请输入您的地址(跳过输入 n):");
		String address = skip(in.next());
		System.out.println("请输入您的电话(跳过输入 n):");
		String tel = skip(in.next());
		//创建一个新用户
		User u = new User(uname, id, address, tel);
		//添加进数据库
		ud.addUser(u);
		System.out.println("恭喜您成功加入会员,您的会员卡号为:" + u.getUserid());
		return u;
	}

	/**
	 * 清空临时用户
	 * 
	 * @return int 清空条数
	 */
	public int cleanTempUser() {
		String sql = "SELECT userid FROM `user` where uname = '临时用户'";
		ResultSet rs = JDBC.executeQuery(sql, null);
		//删除条数
		int num = 0;
		try {
			//判断是否有临时用户
			while (rs.next()) {
				//清空临时购物
				cd.clean(rs.getInt(1));
				//删除临时用户
				ud.delUser(rs.getInt(1));
				//成功删除+1
				num++;
			}
			if (num > 0) {
				System.out.println("已清空临时用户,共" + num + "个!");
			}
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*创建用户的方法*/

	/*重复偷懒方法*/
	/**
	 * 用户判断,输入n就跳过此步
	 * 
	 * @param in
	 *            输入值
	 * @return String 输出值
	 */
	public String skip(String in) {
		if (in.equals("n")) {
			return null;
		} else {
			return in;
		}
	}

	public static void main(String[] args) {
		//UserMenu um = new UserMenu();
	}
}
