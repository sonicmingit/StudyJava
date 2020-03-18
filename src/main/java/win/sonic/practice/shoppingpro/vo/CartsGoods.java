package win.sonic.practice.shoppingpro.vo;

/**
 * 购物车类
 * @author 郝一鸣
 *
 */
public class CartsGoods {
	// 商品编号
	private int id;
	// 购物车商品编号
	private int productid;
	// 购物车商品数量
	private int count;
	//用户会员卡号
	private int userid;

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return productid
	 */
	public int getProductid() {
		return productid;
	}

	/**
	 * @param productid
	 *            要设置的 productid
	 */
	public void setProductid(int productid) {
		this.productid = productid;
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            要设置的 count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            要设置的 userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
