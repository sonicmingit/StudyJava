package win.sonic.e.relation;

/**
 * B是A的属性 AB属于关联关系 C是A的一个方法的属性 AC属于依赖关系
 * 
 * @author 郝一鸣
 *
 */
public class A {
	// 创建一个B类对象b,他是是A的一个属性;
	// 此时只创建,没有实例化,AB为聚合关系
	B b;
	// 此时实例化了对象B,AB为组合关系
	B b1 = new B();
	static String aaa = "sdasd";

	// 创建一个A的方法,其中C类的对象c为一个方法参数
	void methodC(C c) {

		System.out.println("C类对象c是A的一个方法参数,AC为依赖关系.C类的属性:" + c.c);
	}

}
