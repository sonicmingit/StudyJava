package sonic.h.polymorphism;

public class Daughter extends Father {
	int age = 21;
	String name = "郝女儿";

	public void work() {
		System.out.println("女儿的工作方法");
	}

	public static void play() {
		System.out.println("女儿玩的方法");
	}

	public void dance() {
		System.out.println("女儿跳舞的方法");
	}
}
