package sonic.q.jdbc.lesson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * 执行多条sql，执行insert、update、delete
 * 
 * @author Administrator
 * 
 */
public class AddMoreSql {
	static String driver = "com.mysql.jdbc.Driver";
	static Connection conn = null;
	static Statement state = null;
	static ResultSet rs = null;
	static String url = "jdbc:mysql://localhost:3306/work";
	static String user = "root";
	static String pwd = "root";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			state = conn.createStatement();

			conn.setAutoCommit(false);
			// Statement使用addBatch方法
			state.addBatch("insert into test values (1,'aa')");
			state.addBatch("insert into test values (1,'bb')");
			state.addBatch("insert into test values (1,'cc')");
			// 使用executeBatch方法执行，返回int数组
			int[] i = state.executeBatch();
			System.out.println("共插入" + i.length + "条数据");
			conn.commit();
			
			
			// PreparedStatement使用addBatch方法
			// PreparedStatement ps = conn.prepareStatement("语句一");
			// ps.addBatch();
			// ps.addBatch("语句二");
			// ps.addBatch("语句三");
			// int[] j = ps.executeBatch();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
