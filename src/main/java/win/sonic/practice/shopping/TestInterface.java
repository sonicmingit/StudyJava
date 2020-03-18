package win.sonic.practice.shopping;

/**
 * 测试接口使用
 * 
 * @author 郝一鸣
 *
 */
public class TestInterface {
	/**
	 * 测试饮料类的怎么喝接口
	 * 
	 * @param i
	 *            实现接口的类
	 */
	public static void howDrink(IHowDrink i) {
		i.howdrink();
	}

	/**
	 * 测试数码和球怎么用的接口
	 * 
	 * @param i
	 *            实现接口的类
	 */
	public static void howUse(IHowUse i) {
		i.howUse();
	}

	/**
	 * 测试数据类型是什么的接口
	 * 
	 * @param i
	 *            实现接口的类
	 */
	public static void whatIs(IWhatIs i) {
		i.whatIs();
	}

	public static void main(String[] args) {
		Cart c = new Cart();
		System.out.println("-------------测试泛型IWho接口----------------");
		// 挑一个子类实例化IWho接口,测试球
		IPrice<Goods> a = new Ball("1", 999);
		System.out.println(c.priceLevel(a));
		// 测试数据类型
		IPrice<Goods> b = new BasicData("2", 512);
		System.out.println(c.priceLevel(b));

		/* 测试怎么喝接口 */
		// 实例化各类商品
		Drinks dr = new Drinks();
		Digital di = new Digital();
		Ball ba = new Ball();
		BasicData bas = new BasicData();
		StringData str = new StringData();
		System.out.println("--------------测试IHowDrink接口---------------");
		howDrink(dr);
		System.out.println("--------------测试IHowUse接口---------------");
		howUse(di);
		howUse(ba);
		System.out.println("--------------测试IWhatIs接口---------------");
		whatIs(str);
		whatIs(bas);
	}
}
