package win.sonic.practice.shopping;

/**
 * <h3>所有商品的总类<h3></br>所有物品的父类,只含获取商品信息的抽象类.</br>主要用于泛型获取子类属性
 * @author 郝一鸣
 *
 */
public abstract class Goods implements IPrice<Goods>{
	/**
	 * 获取商品名称
	 */
	public abstract String getName();

	/**
	 * 获取商品价值
	 */
	public abstract int getPrice();

	/**
	 * 获取商品类型
	 */
	public abstract String getType();
	/**
	 * 获取购物车物品数量
	 */
	public abstract int getNum();
	/**
	 * 加入购物车数量
	 */
	public abstract void setNum(int num);
}
