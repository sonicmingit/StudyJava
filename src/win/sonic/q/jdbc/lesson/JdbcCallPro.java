package win.sonic.q.jdbc.lesson;
import java.sql.*;

/**
 * 调用存储过程 {call <procedure-name>[(<arg1>,<arg2>, ...)]}
 * 
 * 1.通过COnnection对象的prepareCall()方法创建一个CallableStatement对象的实例,
 * 在使用Connection对象的prepareCall() 方法
 * 
 * 2.通过CallableStatement对象的registerOutParameter() 方法注册Out参数
 * 
 * 3.通过CallableStatement对象的setXxx()方法设定IN或In out 参数，若想将参数设为null，可以使用setNUll()
 * 
 * 4.通过CallableStatement对象的execute()方法执行存储过程
 * 
 * 5.如果所调用的是带返回参数的存储过程没还需要通过CallableStatement对象的getXxx()函数进行获取
 */

/**
 * 存储过程： -- 输入员工号(v_empno)、输出姓名(v_ename)和工资(v_sal)
 * 
 * create or replace procedure getNameSalByNo(v_empno in emp.empno%type,v_ename
 * out emp.ename%type,v_sal out emp.sal%type)
 * 
 * is
 * 
 * begin
 * 
 * select ename,sal into v_ename,v_sal from emp where empno=v_empno;
 * 
 * end;
 */
public class JdbcCallPro {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			// 通过Connection对象的prepareCall()方法创建一个CallableStatement
			// 对象的实例,在使用Connection对象的prepareCall() 方法
			CallableStatement cs = conn
					.prepareCall("{call getNameSalByNo(?,?,?)}");

			// 通过CallableStatement对象的setXxx()方法设定IN或In out
			// 参数，若想将参数设为null，可以使用setNUll()
			cs.setInt(1, 7369);

			// 通过CallableStatement对象的registerOutParameter() 方法注册Out参数
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.DOUBLE);

			// 通过CallableStatement对象的execute()方法执行存储过程
			cs.execute();

			// 如果所调用的是带返回参数的存储过程没还需要通过CallableStatement对象的getXxx()
			String name = cs.getString(2);
			double sal = cs.getDouble(3);
			System.out.println(name + "\t" + sal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
