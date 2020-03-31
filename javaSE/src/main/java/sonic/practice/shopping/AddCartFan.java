package sonic.practice.shopping;

/**
 * 实现Cart的泛型添加方法
 * 
 * @author 郝一鸣
 *
 * @param <T>
 *            实现Cart的泛型添加方法
 */
public class AddCartFan<T> extends Cart {
	/**
	 * 泛型添加购物车方法
	 * 
	 * @param t
	 *            要添加到购物车的商品
	 */
	public <T> void addCart(T t) {
		// 往购物车添加现有商品的方法
		super.myCart.add((Goods) t);
	}
	/**
	 * 添加到商品库的方法
	 * 
	 * @param t
	 *            要添加到库存商品
	 */
	public <T> void addGoods(T t) {
		// 往商品库添加商品
		super.cart.add((Goods) t);
	}
	

}
