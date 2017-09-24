package win.sonic.n.thread;

public class Dish {
	private String name;
	private int num;

	public Dish(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num 要设置的 num
	 */
	public void addThis() {
		num++;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	
}
