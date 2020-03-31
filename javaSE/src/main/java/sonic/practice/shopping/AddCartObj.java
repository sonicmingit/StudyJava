package sonic.practice.shopping;

/**
 * 对方方法加入购物车
 * @author 郝一鸣
 *
 */
public class AddCartObj extends Cart {
	/**
	 * 用对象的方法把商品放入购物车,需要强制转换才能调用方法
	 * @param obj
	 *            把商品放入购物车
	 */
	public void addCartObj(Object obj) {
		super.myCart.add((Goods)obj);
	}

}
