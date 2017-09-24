package win.sonic.h.polymorphism;

public class Son extends Father {
	int age = 25;
	String name = "郝儿子";

	public void work() {
		System.out.println("儿子的工作方法");
	}

	public static void play() {
		System.out.println("儿子玩的静态方法");
	}

	public void nothing() {
		System.out.println("儿子发呆的方法");
	}
}
