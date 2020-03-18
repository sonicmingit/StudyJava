package win.sonic.practice.shopping;

import java.util.HashSet;

public class Digital extends NormalGoods implements IPrice<Goods>, IHowUse {
	// 商品名称
	private String name;
	// 商品价值
	private int price;
	// 商品数量
	private int num;
	// 商品类型名称
	public static final String type = "数码";
	// 本类商品总数,用于计算加入购物车类型总数
	private static HashSet<Digital> total = new HashSet<Digital>();

	@Override
	public void howUse() {
		System.out.println("自己看说明书去!");

	}

	@Override
	public int priceto() {
		if (this.price<1000) {
			return 1;
		} else if (this.price>10000) {
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
		// 本类商品数+1
		total.add(this);
	}

	/**
	 * 获取本类商品数量
	 * 
	 * @return
	 */
	public static int getDigitalTNum() {
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
	public Digital(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Digital() {
		super();
	}

}
