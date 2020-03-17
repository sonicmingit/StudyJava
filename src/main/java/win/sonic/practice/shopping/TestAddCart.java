package win.sonic.practice.shopping;

/**
 * 测试三种加入购物车的方法
 * 
 * @author 郝一鸣
 *
 */
public class TestAddCart {

	public static void main(String[] args) {
		//实例化商品
		Drinks coca = new Drinks("可乐",2);
		Digital nokia = new Digital("诺基亚",999);
		Ball foot = new Ball("足球",125);
		BasicData i = new BasicData("整型",1);
		StringData str = new StringData("字符串",10);
		//五种商品创建完毕
		System.out.println("-----第一种方法AddCartNor,实例化每种商品,分别加入-----");
		// 第一种方法实例化一个购物车
		AddCartNor nor = new AddCartNor();
		//加入商品
		nor.addCartNor(coca);
		nor.addCartNor(foot);
		nor.addCartNor(i);
		nor.showMyCart();
		//
		System.out.println("\n-----第二种方法AddCartObj,对象加入,但是需要强制转换-----");
		// 第二种方法实例化一个购物车
		AddCartObj obj = new AddCartObj();
		//加入商品
		obj.addCartObj(foot);
		obj.addCartObj(str);
		obj.addCartObj(i);
		obj.showMyCart();
		//
		System.out.println("\n-----第三种方法AddCartFan,很随意的加入,方便-----");
		// 第二种方法实例化一个购物车
		AddCartFan<Goods> fan = new AddCartFan<Goods>();
		fan.addCart(str);
		fan.addCart(nokia);
		fan.showMyCart();
		//三种方法看似一样,实则是因为创建了商品父类,传入对象同类.
		System.out.println("------实际上还是泛型最方便,方法区别看三种方法源码------");

	}

}
