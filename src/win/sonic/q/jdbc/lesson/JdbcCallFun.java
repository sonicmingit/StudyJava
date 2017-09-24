package win.sonic.q.jdbc.lesson;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcCallFun {

	/**
	 * 调用函数 {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
	 * 
	 * 函数： -- 输入员工编号(v_empno)，输出工资(v_sal)
	 * 
	 * create or replace function getSalByNo(v_empno in emp.empno%type) return
	 * emp.sal%type
	 * 
	 * is
	 * 
	 * v_sal emp.sal%type;
	 * 
	 * begin
	 * 
	 * select sal into v_sal from emp where empno=v_empno;
	 * 
	 * return v_sal;
	 * 
	 * exception
	 * 
	 * when others then
	 * 
	 * return -1;
	 * 
	 * end;
	 */
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			// 通过COnnection对象的prepareCall()方法创建一个CallableStatement
			// 对象的实例,在使用Connection对象的prepareCall() 方法
			CallableStatement cs = conn.prepareCall("{?=call getSalByNo(?)}");

			cs.setInt(2, 7369);
			// 通过CallableStatement对象的registerOutParameter() 方法注册Out参数
			cs.registerOutParameter(1, Types.DOUBLE);

			cs.execute();

			// 提取返回值
			double sal = cs.getDouble(1);
			System.out.println(sal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
