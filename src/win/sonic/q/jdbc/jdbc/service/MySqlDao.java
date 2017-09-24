package win.sonic.q.jdbc.jdbc.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.chinasofti.jdbc.vo.Goods;

public abstract class MySqlDao {
	private static Properties p = new Properties();
	static Connection con = null;
	// 用静态块加载驱动
	static {
		try {
			// 加载pro
			p.load(new FileInputStream("src/com/chinasofti/jdbc/service/mysql.txt"));
			// 加载驱动
			Class.forName(p.getProperty("driver"));
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
		// 连接数据库
		try {
			con = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USER"), p.getProperty("POSSWORD"));
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
	}

	public abstract int delGoods(int id);

	/**
	 * 关闭ps
	 * 
	 * @param ps
	 */
	public void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭con
	 * 
	 * @param con
	 */
	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭rs
	 * 
	 * @param rs
	 */
	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
