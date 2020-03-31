package sonic.practice.shopping;

/**
 * 等级数量以及名称;
 * 
 * @author 郝一鸣
 *
 */
public class Level {
	private String name;
	private int cartNum;
	private int myCartNum;

	
	/**
	 * @return cartNum 该品质库存数量
	 */
	public int getCartNum() {
		return cartNum;
	}


	/**
	 * @param cartNum 该品质库存数量
	 */
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}


	/**
	 * @return myCartNum 该品质购物车数量
	 */
	public int getMyCartNum() {
		return myCartNum;
	}


	/**
	 * @param myCartNum 该品质购物车数量
	 */
	public void setMyCartNum(int myCartNum) {
		this.myCartNum = myCartNum;
	}


	/**
	 * @return name 该品质等级
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name 该品质等级
	 */
	public Level(String name) {
		super();
		this.name = name;
	}

}
