package win.sonic.q.jdbc.jdbc.vo;

public class CartsGoods {
	// 商品编号
	private int id;
	// 购物车商品编号
	private int productid;
	// 购物车商品数量
	private int count;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
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
	 * @param productid 要设置的 productid
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
	 * @param count 要设置的 count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
}
