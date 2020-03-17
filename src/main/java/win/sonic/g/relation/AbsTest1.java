package win.sonic.g.relation;

public class AbsTest1 extends Abs {
	// 必须重写父类抽象类未实现的抽象方法
	@Override
	public void absMethod1() {
		System.out.println("实现ABS的抽象方法absMethod1");

	}

	@Override
	public String absMethod2(String a) {
		System.out.println("实现ABS的抽象方法absMethod2.返回"+a);
		return a;
	}

}
