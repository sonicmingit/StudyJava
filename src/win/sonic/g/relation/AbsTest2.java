package win.sonic.g.relation;
//没有完全实现父类抽象方法的子类也必须为抽象类
//这是一个抽象类,他没有抽象方法
public abstract class AbsTest2 extends Abs {
	@Override
	public void absMethod1() {
		System.out.println("实现ABS的抽象方法absMethod1");
	}
	//没有实现方法2
}
