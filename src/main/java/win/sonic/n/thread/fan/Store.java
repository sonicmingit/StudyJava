package win.sonic.n.thread.fan;

import java.util.ArrayList;

/**
 * 创建仓库类，有添加产品、取出产品、获取产品数量等方法
 * @author Sean Fan
 *
 */
public class Store {
	
	//创建泛型列表products类型为Product
	private ArrayList<Product> products = new ArrayList<>();
	
	//创建向仓库添加产品的方法
	public void setProduct(Product product) {
		//使用add方法将product对象添加到列表products中
		products.add(product);
	}

	/**
	 * 从仓库中取走一个产品
	 * @return
	 */
	public Product getProduct() {
		//将列表首位的产品取出返回
		return products.remove(0);
	}

	//获取仓库内产品数量
	public int getNum() {
		return products.size();
	}
}
