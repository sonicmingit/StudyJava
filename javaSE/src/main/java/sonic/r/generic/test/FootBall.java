package sonic.r.generic.test;

public class FootBall {
	// 名称
	private String name;
	// 价值
	private int price;

	/**
	 * @return name 足球姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return price 足球价值
	 */
	public int getPrice() {
		return price;
	}
	
	public String toString(){
		return "足球的属性: 名称-"+name+" 价值-"+price+"元";
	}

	/**
	 * 足球的构造方法
	 * 
	 * @param name
	 *            足球名称
	 * @param price
	 *            足球价值
	 */
	public FootBall(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}
