package sonic.e.relation;

public class Cart {
	// 创建一个商品类数组,用于保存添加到购物车的商品,最大容量为10
	Products[] products = new Products[10];
	// 创建一个num用来保存商品的添加种类个数
	private int num = 0;
	// 创建一个total用来保存购物车里所有商品的总价
	int total;
	// 创建一个totalNum用来保存所有添加到购物车里的商品总件数
	int totalNum;

	/**
	 * 
	 * @return num 目前商品数
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 每添加一个商品,num自加1
	 */
	public void setNum() {
		num++;
	}

	/*
	 * 删除商品相关属性,暂时没用 public void delNum() { num--; }
	 */

	/**
	 * 
	 * @return total 购物车商品总价值
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * 商品价格累计计算
	 * 
	 * @param value
	 *            商品单价
	 */
	public void setTotal(int value) {
		total += value;
	}

	/**
	 * 结算购物车,显示最终价格及商品数量</br>
	 * </br>
	 * 例:</br>
	 * 购物车中的商品有:</br>
	 * 商品: 111 数量:1件 单价:9999元</br>
	 * 商品: 222 数量:2件 单价:120元</br>
	 * 商品: 333  数量:1件 单价:239元</br>
	 * 商品: 444  数量:1件 单价:239元</br>
	 * ---------------------------------</br>
	 * 总共: 4种商品 4件 总价: 21314元 </br>
	 */
	public void accunt() {
		// 购物车为空时,提示
		if (num == 0) {
			System.out.println("购物车是空的,请先添加物品!\n-------------------------------------------------");
		} else {
			// 显示购物车内商品信息
			System.out.println("购物车中的商品有:");
			for (int i = 0; i < num; i++) {
				System.out.print("商品: " + products[i].getName() + "  数量:" + products[i].getNumber() + "件  单价:"
						+ products[i].getValue() + "元\n");
				this.setTotal(products[i].getValue() * products[i].getNumber());
				totalNum += products[i].getNumber();
			}

			System.out.println("---------------------------------\n总共: " + num + "种商品 " + totalNum + "件  总价: " + total
					+ "元\n-------------------------------------------------");
		}

	}

}
