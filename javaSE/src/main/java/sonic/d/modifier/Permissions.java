package sonic.d.modifier;
/**
 * 包 权限访问修饰符 修饰符 变量的概念
 * @author 郝一鸣
 *
 */
public class Permissions {
	/**
	 * 四种访问权限修饰符
	 */
	// public 可以被任意访问
	public String a;
	// private 只能被本类访问
	private String b;
	// defaul 只能被同包访问
	String c;
	// protected 受保护的属性,只能被同包或者子类访问
	protected int f;

	/**
	 * 权限修饰符
	 */
	// static 静态修饰符,唯一共有
	static int num;
	// final 必须赋值,相当于常量 static能直接被类访问
	final String d = "nihao ";
	// 静态块,只要创建对象就会显示出来,且只显示一次
	static {
		System.out.println("静态块1示例,可以用作日志!");
		System.out.println("对象被创建了!");
	}
	static {
		System.out.println("静态块2,按顺序执行了");
	}

	// 用共有方法读取私有属性,达到封装效果
	String getB() {
		return b;
	}

	// 一个共有方法
	public void method() {
		// 创建一个局部变量,必须赋值
		int a = 0;
	}

	// 静态方法,不需要与任何对象关联,可以直接被类调用
	static void auto() {
		num++;
	}

	// 无参构造方法
	public Permissions() {
		// 创建一个对象静态属性NUM增加一次,共享属性.
		num++;
		System.out.println("这是第" + num + "个对象");
	}

	public static void main(String[] args) {
		// 创建一个类的对象
		Permissions test = new Permissions();
		Permissions test2 = new Permissions();
		//静态属性可以直接被类访问
		System.out.println(Permissions.num);
		//常量属性可以直接被访问,且值一样,不能修改
		System.out.println(test.d);		;
		System.out.println(test2.d);		;

	}
}
