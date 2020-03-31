package sonic.practice.shoppingpro.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * 通用连接数据库的操作方法
 * 
 * @author 郝一鸣
 */
public class JDBC {
	private static Connection con = null;
	private static Properties p = new Properties();
	private static String s = "src\\win\\sonic\\practice\\shoppingpro\\dao\\sql.properties";
	private static PreparedStatement ps = null;
	protected String sql = null;
	protected Statement st = null;
	protected ResultSet rs = null;
	//创建即连接数据库
//	static {
//		LinkMySql();
//	}

	/**
	 * 连接Oracle数据库
	 */
	public static void LinkOracle() {
		try {
			p.load(new FileInputStream(s));
			Class.forName(p.getProperty("oracle_driver"));
			System.out.println("加载Oracle服务器成功...");
			con = DriverManager.getConnection(p.getProperty("oracle_url"), p.getProperty("oracle_user"),
					p.getProperty("oracle_password"));
			System.out.println("连接Oracle数据库成功...");
		} catch (FileNotFoundException e) {
			System.out.println("找不到配置文件,加载配置失败...");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到启动程序,加载Oracle驱动失败...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接Oracle数据库失败...");
			e.printStackTrace();
		}
	}

	/**
	 * 连接MySql数据库
	 */
	public static void LinkMySql() {
		try {
			p.load(new FileInputStream(s));
			Class.forName(p.getProperty("mysql_driver"));
			System.out.println("加载MySql服务器成功...");
			con = DriverManager.getConnection(p.getProperty("mysql_url"), p.getProperty("mysql_user"),
					p.getProperty("mysql_password"));
			System.out.println("连接MySql数据库成功...");
		} catch (FileNotFoundException e) {
			System.out.println("找不到配置文件,加载配置失败...");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到启动程序,加载MySql驱动失败...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接MySql数据库失败...");
			e.printStackTrace();
		}
	}
	
	/**
	 * 连接MariaDB数据库
	 */
	public static void LinkMariaDB() {
		try {
			p.load(new FileInputStream(s));
			Class.forName(p.getProperty("mariadb_driver"));
			System.out.println("加载MariaDB服务器成功...");
			con = DriverManager.getConnection(p.getProperty("mariadb_url"), p.getProperty("mariadb_user"),
					p.getProperty("mariadb_password"));
			System.out.println("连接MariaDB数据库成功...");
		} catch (FileNotFoundException e) {
			System.out.println("找不到配置文件,加载配置失败...");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到启动程序,加载MariaDB驱动失败...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接MariaDB数据库失败...");
			e.printStackTrace();
		}
	}

	/**
	 * 数据库DQL语句
	 * 
	 * @param sql
	 *            DQL查询语句
	 * @return 表结果
	 */
	public static ResultSet executeQuery(String sql, Object[] obj) {
		try {
			//对只转发结果集的无效操作：last
			//ResultSet.TYPE_SCROLL_INSENSITIVE:常表示为 ResultSet方式，但一般对数据的基础 ResultSet变化不敏感的类型。
			//ResultSet.CONCUR_READ_ONLY:常表示为 ResultSet对象不可更新的并发模式。
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//System.out.println("DQL语句执行成功...");
			// 如果数组为空,则不执行
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					// 有此方法可以根据传入对象设置参数
					ps.setObject(i + 1, obj[i]);
				}
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			//System.out.println("DQL语句执行失败...");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 传入rs以二维数组返回数据库列表
	 * 
	 * @param rs
	 * @return 接收返回值的二维数组[行][列]
	 */
	public static Object[][] returnResultSet(ResultSet rs) {
		try {
			// 获取传入rs的列数
			int ColumnCount = rs.getMetaData().getColumnCount();
			// 获取传入rs的行数
			rs.last();
			int RowCount = rs.getRow();
			// 接收返回值的对象数组[行][列]
			Object[][] obj = new Object[RowCount][ColumnCount];
			// 循环赋值前,先移动到rs第一行
			rs.beforeFirst();
			// 循环赋值,列赋值
			int i = 0;
			while (rs.next()) {
				// 行赋值
				for (int j = 0; j < ColumnCount; j++) {
					obj[i][j] = rs.getObject(j + 1);
				}
				i++;
			}
			return obj;
		} catch (SQLException e) {
			System.out.println("赋值失败!");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 数据库DDL语句
	 * 
	 * @param sql
	 *            DDL语句
	 * @param obj
	 *            占位符需要设置的数组
	 * @return int 执行结果
	 */
	public static int executeUpdate(String sql, Object[] obj) {
		try {
			ps = con.prepareStatement(sql);
			// 如果数组为空,则不执行
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					// 有此方法可以根据传入对象设置参数
					ps.setObject(i + 1, obj[i]);
				}
			}
			//System.out.println("DML语句执行成功...");
			return ps.executeUpdate();
		} catch (SQLException e) {
			//System.out.println("DML语句执行失败...");
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 关闭所有接口
	 * 
	 * @param rs
	 * @param ps
	 * @param conn
	 * @throws SQLException
	 */
	public void closeCon() throws SQLException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e2) {
				throw e2;
			} finally {
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e3) {
					throw e3;
				}
			}
		}
	}

	//	/* 娱乐用 */
	//	/**
	//	 * 输入查询语句,输出表格
	//	 * 
	//	 * @param sql
	//	 *            查询语句
	//	 * @param obj
	//	 *            占位符
	//	 */
	//	public static void test(String sql, Object[] obj) {
	//		showFormHead(executeQuery(sql, obj));
	//		showForm(returnResultSet(executeQuery(sql, obj)));
	//	}
	public static void main(String[] args) throws Exception {
		//LinkMySql();
		//LinkOracle();
		LinkMariaDB();
		// System.out.println("序号\t品名\t单价\\元\t类型");
		//test("SELECT * FROM carts c join goods g ON c.id=g.id", null);
		//test("select * from carts", null);
		//ResultSet rs = executeQuery("SELECT * FROM  goods", null);
		// returnResultSet(rs);
		// 返回列的属性.返回ResultSetMetaData
		// System.out.println("总列数:"+rs.getMetaData().getColumnCount() );
		// rs.last();
		// System.out.println("总行数:"+rs.getRow());
		// rs.beforeFirst();
		// //rs.first();
		// System.out.println("-----------");
		// //rs.previous();
		// while(rs.next()){
		//
		// System.out.println(rs.getObject(1));
		// }
		// System.out.println("-----------");
		// showForm(returnResultSet(rs));
		// while (rs.next()) {
		// System.out.println(rs.getString(3));
		// }
	}
}
