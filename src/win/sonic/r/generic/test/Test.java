package win.sonic.r.generic.test;

public class Test {

	public static void main(String[] args) {
		//先创建三种球类对象
		FootBall f = new FootBall("黄金足球", 9999);
		BasketBall b = new BasketBall("斯伯丁", 129);
		TableTennis t = new TableTennis("红双喜", 1);
		//第一种麻烦的放入方式Box1
		System.out.println("----------第一个麻烦的盒子----------");
		Box1 box1 = new Box1();
		//把球都放进去
		box1.setB(b);		
		box1.setF(f);
		box1.setT(t);
		System.out.println(box1.b+"\n"+box1.f+"\n"+box1.t);
		System.out.println("非常麻烦,盒子要为每种球类都创建自己的方法!");
		
		//第二种相对方便一些的对象方法Box2,但是需要强制转换类型
		System.out.println("----------第二个盒子,万物皆对象----------");
		Box2 b2 = new Box2();
		//把篮球放入盒子,向上造型.相当于 Box2 b2 = new BasketBall();
		b2.setObj(b);
		//必须向下造型才能转换为篮球对象,使用篮球的方法
		BasketBall bb = (BasketBall) b2.getObj();
		bb.show();
		
		//第三种方法,泛型,直接通过泛型实例化盒子,后期不用手动转换数据类型
		System.out.println("----------第三个盒子,泛型,创建盒子时不用指定类型,使用时确定----------");
		Box3<BasketBall> b3b  =new Box3<BasketBall>();
		b3b.setT(b);
		//调用box3泛型的方法
		b3b.show(b);
		

	}

}
