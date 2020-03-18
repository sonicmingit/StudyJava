package win.sonic.r.generic;

public class Rice {
	String name;
	int price;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
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
	 * @param price
	 *            要设置的 price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	public Rice(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}
