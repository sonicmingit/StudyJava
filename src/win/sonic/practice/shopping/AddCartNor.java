package win.sonic.practice.shopping;

/**
 * 第一种方法,加入购物车,需要实例化每种商品,为每种商品添加方法
 * 
 * @author 郝一鸣
 *
 */
public class AddCartNor extends Cart {
	// 必须把每个商品都实例化,才能加入购物车
	// Drinks dr = new Drinks();
	// Digital di = new Digital();
	// Ball ba = new Ball();
	// BasicData bas = new BasicData();
	// StringData str = new StringData();

	// 为每种类创建添加购物车的方法
	public void addCartNor(Drinks dr) {
		super.myCart.add(dr);
	}

	public void addCartNor(Digital di) {
		super.myCart.add(di);
	}

	public void addCartNor(Ball ba) {
		super.myCart.add(ba);
	}

	public void addCartNor(BasicData bas) {
		super.myCart.add(bas);
	}

	public void addCartNor(StringData str) {
		super.myCart.add(str);
	}

	/**
	 * 但是这里有总父类,可以直接向上转型添加进购物车</br>
	 * 以上方法只是为凸显正常添加的麻烦性
	 * 
	 * @param g
	 *            加入购物车的商品
	 */
	public void addCartNor(Goods g) {
		super.myCart.add(g);
	}
}
