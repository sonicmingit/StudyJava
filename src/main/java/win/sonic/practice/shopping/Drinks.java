package win.sonic.practice.shopping;

import java.util.HashSet;

/**
 * 饮料类</br>
 * 继承正常商品,实现两个接口
 * 
 * @author 郝一鸣
 * @param <T>
 *
 */
public class Drinks extends NormalGoods implements IHowDrink, IPrice<Goods> {
	// 商品名称
	private String name;
	// 商品价值
	private int price;
	// 商品数量
	private int num;
	// 商品类型名称
	public static final String type = "饮料";

	// 本类商品总数,用于计算加入购物车类型总数.HashSet的覆盖性很好的解决了商品类重复的问题
	private static HashSet<Drinks> total = new HashSet<Drinks>();

	@Override
	public void howdrink() {
		System.out.println("饮料打开直接对嘴喝!也可以倒进杯子喝!");
	}

	@Override
	public int priceto() {
		if (this.price<10) {
			return 1;
		} else if (this.price>100) {
			return 3;
		} else {
			return 2;
		}		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPrice() {
		return price;
	}

	/**
	 * 获取本件商品数量
	 * 
	 * @return num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 设置商品加入购物车数量
	 * 
	 * @param num
	 *            要加入的数量
	 */
	public void setNum(int num) {
		// 现有数量+传入数量
		this.num += num;
		total.add(this);
	}

	/**
	 * 获取加入购物车本类商品数量
	 * 
	 * @return
	 */
	public static int getDrinksTNum() {
		return total.size();
	}

	/**
	 * 获取类型
	 * 
	 * @return type 商品类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 创建商品
	 * 
	 * @param name
	 *            商品名称
	 * @param price
	 *            商品价值
	 */
	public Drinks(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Drinks() {
		super();
	}

}
