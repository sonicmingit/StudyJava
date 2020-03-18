package win.sonic.e.relation;

public class Products {
	// 商品的名称
	private String name;
	// 商品的单价
	int value;
	// 商品的数量,默认1个
	int number = 1;

	/**
	 * 添加商品到购物车,如果已有此商品,数量增加.<br>
	 * 如果购物车已满,返回提示
	 * 
	 * @param cart 需要添加的购物车名
	 */
	public void addCart(Cart cart) {
		if (cart.getNum() <= 9) {
			boolean a = true;
			for (int i = 0; i < cart.getNum(); i++) {
				if (cart.products[i].equals(this)) {
					this.number++;
					a = false;
				}
			}
			if (a) {
				cart.products[cart.getNum()] = this;
				cart.setTotal(value);
				cart.setNum();
			}
		} else {
			System.out.println("<" + this.name
					+ ">添加失败!\n购物车已满(最大容量为10件商品),无法再继续添加商品!\n---------------------------------------------------------");
		}
	}

	/**
	 * 一次添加多件商品的方法<br>
	 * 添加单件商品的重载方法
	 * 
	 * @param cart
	 *            需要添加的购物车名
	 * @param number
	 *            要添加商品的数量
	 */
	public void addCart(Cart cart, int number) {
		if (cart.getNum() <= 9) {
			boolean a = true;
			for (int i = 0; i < cart.getNum(); i++) {
				if (cart.products[i].equals(this)) {
					this.number += number;
					a = false;
				}
			}
			if (a) {
				cart.products[cart.getNum()] = this;
				cart.setTotal(value);
				cart.setNum();
				this.number = number;
			}
		} else {
			System.out.println("<" + this.name + "> ×" + number
					+ "件  添加失败!\n购物车已满(最大容量为10件商品),无法再继续添加商品!\n---------------------------------------------------------");
		}
	}

	/*
	 * 删除方法添加失败!!!! 主要是如果没有这件商品是最后一件时,无法做到删除. public void delCart(Cart cart) {
	 * boolean a = true; for (int i = 0; i < cart.getNum(); i++) { if
	 * (cart.products[i].equals(this)) { if (this.number == 1) {
	 * if(cart.getNum()==1) {cart.products[i] = null;}
	 * 
	 * // for (int j = 0; j <=(cart.getNum()-i); j++) { //
	 * cart.products[i+j+1]=cart.products[i+j]; // }
	 * 
	 * cart.delNum(); if (cart.getNum() != 1) { this.number--; }
	 * 
	 * } else { this.number--; } a = false; } } if (a) {
	 * System.out.println("您的购物车中没有<" + this.getName() + ">,无法删除!"); } }
	 */

	/**
	 * 提取商品的名称
	 * 
	 * @return name 商品的名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 修改商品的名称
	 * 
	 * @param name
	 *            商品的名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 提取商品的单价
	 * 
	 * @return value 商品的单价
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 设置商品的单价
	 * 
	 * @param value
	 *            商品的单价
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * 提取商品的数量
	 * 
	 * @return number 商品的数量
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 方法的重写:判断两个商品是否为同一个<br>
	 * 只要两个商品的名字相同,他们就是同一个商品
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * 添加一个商品类
	 * 
	 * @param name
	 *            商品的名称
	 * @param value
	 *            商品的单价
	 */
	public Products(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}

}
