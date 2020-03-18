package win.sonic.h.polymorphism;

public class Test {
	// 传入Father类的对象参数,只要是Father的子类都可以当形参传入
	public static void go(Father fa) {
		// 只要有非静态的方法重载就会执行子类方法
		fa.work();
		// 父类有静态方法,有重载也是调用父类的
		fa.play();
		// 属性直接是调用父类的
		System.out.println(fa.name);
		// 也可以调用父类独有的方法
		fa.makeMoney();
	}

	public static void main(String[] args) {
		/* 向上造型 */
		System.out.println("----------向上造型,除了非静态方法重载,全部指向父类------------");
		// 左边:编译阶段 右边:运行阶段		
		Father f = new Son();
		
		System.out.println("f是Son类吗?"+(f instanceof Son));
		// f只能调用Father的方法,不能调用Son的方法
		// 当方法重载时调用的是Son的方法
		f.work();
		// 当方法重载但Father为静态方法时调用的是父亲的方法
		f.play();
		// 属性调用一定是父亲的属性
		System.out.println(f.name);

		/* 向下造型 */
		System.out.println("----------向下造型,全部指向子类------------");
		// 强制转换为子类Son对象
		Son s = (Son) f;
		// 现在可以调用子类的方法
		s.work();
		s.play();
		s.nothing();
		System.out.println(s.name);

		System.out.println("----------传入父类方法参数相当于向上造型------------");
		// 调用的属性也转变为儿子的
		Daughter d = new Daughter();
		// 传入的参数相当于向上造型 Father f = d = new Daughter();
		Test.go(d);
		
		/*instanceof方法*/
		//子类属于父类,父类不属于子类.向上造型子类父类都属于
		System.out.println("----------instanceof------------");
		System.out.println("s是Son类吗?"+(s instanceof Son));
		System.out.println("s是Father类吗?"+(s instanceof Father));
		System.out.println("d是Father类吗?"+(d instanceof Father));
		System.out.println("f是Father类吗?"+(f instanceof Father));
		System.out.println("f是Son类吗?"+(f instanceof Son));
		Father fi = new Father();
		System.out.println("fi是Son类吗?"+(fi instanceof Son));
		
	}
}
