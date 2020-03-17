package win.sonic.r.generic.test;

public class TableTennis {
	// 名称
	private String name;
	// 价值
	private int price;

	/**
	 * @return name 乒乓球姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return price 乒乓球价值
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 乒乓球的构造方法
	 * 
	 * @param name
	 *            乒乓球名称
	 * @param price
	 *            乒乓球价值
	 */
	public TableTennis(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String toString(){
		return "乒乓球的属性: 名称-"+name+" 价值-"+price+"元";
	}
}
