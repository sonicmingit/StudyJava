package win.sonic.h.polymorphism;

public class Father {
	int age = 50;
	String name = "郝爸爸";

	public void work() {
		System.out.println("父亲的工作方法");
	}

	public void makeMoney() {
		System.out.println("父亲赚钱的方法");
	}

	public static void play() {
		System.out.println("父亲玩的静态方法");
	}
}
