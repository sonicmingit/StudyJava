package win.sonic.r.generic.test;

public class BasketBall {
	// 名称
	private String name;
	// 价值
	private int price;

	/**
	 * @return name 篮球姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return price 篮球价值
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 篮球的构造方法
	 * 
	 * @param name
	 *            篮球名称
	 * @param price
	 *            篮球价值
	 */
	public BasketBall(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String toString(){
		return "篮球的属性: 名称-"+name+" 价值-"+price+"元";
	}
	public void show(){
		System.out.println("这是一个篮球!");
	}
}
