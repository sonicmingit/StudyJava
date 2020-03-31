package sonic.p.Reflect.lesson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		/*Class类方法*/
		Test1 t1 = new Test1();
		// Obj对象通过getClass()方法获取Class类
		Class c1 = t1.getClass();
		// 直接类名.class获取Class类
		Class c2 = Test2.class;
		// Class类的静态方法,要抛异常
		Class c3 = Class.forName("com.chinasofti.lesson.Test3");
		//打印输出String的所有方法
		Method[] m = String.class.getMethods();
		System.out.println("-----------------String的方法----------------------");
		for (Method method : m) {
			System.out.println(method);
		}
		System.out.println("---------------String的方法结束--------------------");
		
		/*Contructor类方法*/
		//通过Class类创建Contructor类
		Constructor con = c1.getConstructor(null);
		//获取对象构造器名
		System.out.println(con.getName());
		//获取对象构造器参数
		System.out.println(con.getParameters());
		//使用Contructor创建对象实例,需强制转换
		Test1 cont1=(Test1)con.newInstance(null);
		
		
		/*Method类方法*/
		
		
		/*Filed类方法*/
		
	}

}
