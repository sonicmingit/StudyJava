package sonic.practice.shopping;

/**
 * 泛型接口,有一个判断商品等级的方法
 * 
 * @author 郝一鸣
 *
 * @param <T> 商品类
 */
public interface IPrice<T> {
	/**
	 * 创建一个方法,根据不同商品类的价格,判断该件商品在该类商品中的等级
	 * 
	 * @param t
	 *            商品类
	 */
	int priceto();
	//格式:
	//if(t.price<价格1){return 1}  等级1
	//else if(t.price>价格2) {return 3} 等级3
	//else{return 2} //价格1和价格2之间 等级2
}
