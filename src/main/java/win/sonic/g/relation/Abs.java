package win.sonic.g.relation;

public abstract class Abs {
	// 抽象方法可以创建成员变量
	String abs;

	// 没有参数没有返回的抽象方法
	public abstract void absMethod1();

	// 有参数的抽象方法,有返回类型也不需要返回
	public abstract String absMethod2(String a);

	// 抽象类可以创建非抽象方法
	public void absMethod3(String a) {
		System.out.println("抽象类可以创建非抽象方法!");
	}

	public Abs() {
		// 可以有构造方法,但是不能实例化
	}
}
