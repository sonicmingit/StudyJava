package win.sonic.practice.shopping;

import java.util.*;

/**
 * 购物车
 * 
 * @author 郝一鸣
 *
 */
public class Cart {
	// 创建购物车现有商品数组
	ArrayList<Goods> cart = new ArrayList<Goods>();
	// 创建加入购物车商品数组
	ArrayList<Goods> myCart = new ArrayList<Goods>();
	//存放物品等级
	static TreeMap<Integer, Level> level = new TreeMap<Integer, Level>();
	static Level l1 = new Level("普通品");
	static Level l2 = new Level("豪华品");
	static Level l3 = new Level("奢侈品");	
	

	// // 创建放入购物车的抽象方法,子类三种加入方法
	// public abstract void addCart();
	//
	// // 用于泛型的添加购物车方法
	// public abstract <T> void addCart(T t);

	/**
	 * 删除库存商品
	 * 
	 * @param num
	 *            目前商品列表编号,showCart()查看
	 */
	public void delCart(int num) {
		cart.remove(num - 1);
	}

	/**
	 * 删除购物车商品
	 * 
	 * @param num
	 *            目前购物车商品列表编号,showMyCart()查看
	 */
	public void delMyCart(int num) {
		myCart.remove(num - 1);
	}

	/**
	 * 展示库存商品的方法
	 */
	public void showCart() {		
		System.out.println("编号\t商品名称\t商品单价\t类型\t品质");
		for (int i = 0; i < cart.size(); i++) {
			// 创建一个临时Goods对象,替代当前商品,减少输入
			Goods g = cart.get(i);
			System.out.print((i + 1) + "\t");
			System.out.print(g.getName() + "\t");
			System.out.print(g.getPrice() + "元\t");
			System.out.print(g.getType() + "\t");
			//展示该商品的品质等级,有点绕
			System.out.print(this.priceLevel(g));
			//该商品品质数量库存+1,有点绕(获取商品的品质类((设置品质类相应数量(获取现有数量+1)))
			level.get(g.priceto()).setCartNum(level.get(g.priceto()).getCartNum()+1);
			System.out.println();
		}
		System.out.println("----------------------------------------");
		/*后期可以加入展示库存现有商品种类总数,和不同品质商品总数*/
		System.out.println("\t共有" + cart.size() + "件商品");		
		System.out.println("----------------------------------------");
	}

	// 展示加入购物车的商品并结算的方法
	public void showMyCart() {	
		// 临时变量,记录购物车总价值
		int d = 0;
		// 临时变量,记录购物车商品总件数
		int num = 0;
		System.out.println("-----------------您的账单---------------------");
		System.out.println("编号\t商品名称\t单价\t数量\t总价\t类型\t品质");
		System.out.println("----------------------------------------------");
		for (int i = 0; i < myCart.size(); i++) {
			// 创建一个临时Goods对象,替代当前商品,减少输入
			Goods g = myCart.get(i);
			// 计算总价
			d += g.getPrice() * g.getNum();
			// 计算总件数
			num += g.getNum();
			System.out.print((i + 1) + "\t");
			System.out.print(g.getName() + "\t");
			System.out.print(g.getPrice() + "元\t");
			System.out.print(g.getNum() + "件\t");
			System.out.print(g.getPrice() * g.getNum() + "元\t");
			System.out.print(g.getType() + "\t");
			System.out.print(this.priceLevel(g));
			//该商品品质数量购物车+1,有点绕(获取商品的品质类((设置品质类相应数量(获取现有数量+1)))
			level.get(g.priceto()).setMyCartNum(level.get(g.priceto()).getMyCartNum()+1);
			System.out.println();
		}
		//展示商品种类:
		System.out.println("----------------------------------------------");
		System.out.println("商品种类:");
		if (Drinks.getDrinksTNum() != 0)
			System.out.println(Drinks.type + "类:\t\t" + Drinks.getDrinksTNum() + "种\t");
		if (Digital.getDigitalTNum() != 0)
			System.out.println(Digital.type + "类:\t\t" + Digital.getDigitalTNum() + "种\t");
		if (Ball.getBallTNum() != 0)
			System.out.println(Ball.type + "类:\t\t" + Ball.getBallTNum() + "种\t");
		if (BasicData.getBasicDataTNum() != 0)
			System.out.println(BasicData.type + "类:\t" + BasicData.getBasicDataTNum() + "种\t");
		if (StringData.getStringDataTNum() != 0)
			System.out.println(StringData.type + "类:\t" + StringData.getStringDataTNum() + "种\t");
		System.out.println("----------------------------------------------");
		//展示商品品质数量
		System.out.println("商品品质:");
		System.out.println(l1.getName()+": \t"+l1.getMyCartNum()+"件");
		System.out.println(l2.getName()+": \t"+l2.getMyCartNum()+"件");
		System.out.println(l3.getName()+": \t"+l3.getMyCartNum()+"件");
		System.out.println("----------------------------------------------");
		System.out.println("商品总数:" + num + "件\t\t\t商品总价值:" + d + "元");
	}
	//构造函数,自动创建品质类
	/**
	 * 创建品质类,三种
	 */
	static{			
		level.put(1, l1);
		level.put(2, l2);
		level.put(3, l3);
	}
	/**
	 * @param t 商品
	 * @return 该商品等级
	 */
	public <T> String priceLevel(IPrice<T> t){	
		return level.get(t.priceto()).getName();
	}

	/**
	 * @return cart
	 */
	public ArrayList<Goods> getCart() {
		return cart;
	}

	/**
	 * @param cart
	 *            要设置的 cart
	 */
	public void setCart(ArrayList<Goods> cart) {
		this.cart = cart;
	}

	/**
	 * @return myCart
	 */
	public ArrayList<Goods> getMyCart() {
		return myCart;
	}

	/**
	 * @param myCart
	 *            要设置的 myCart
	 */
	public void setMyCart(ArrayList<Goods> myCart) {
		this.myCart = myCart;
	}

}
