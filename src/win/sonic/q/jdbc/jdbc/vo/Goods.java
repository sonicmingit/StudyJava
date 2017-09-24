package win.sonic.q.jdbc.jdbc.vo;

//商品类
public class Goods {
	//商品编号
	private int id;
	//商品名称
	private String name;
	//商品价值
	private int price;
	//商品类型
	private String type;
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
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price 要设置的 price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type 要设置的 type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Goods(String name, int price, String type) {
		super();		
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public Goods(int id, String name, int price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public Goods() {
		super();
	}
	
	
	
}
