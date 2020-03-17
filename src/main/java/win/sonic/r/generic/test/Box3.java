package win.sonic.r.generic.test;

/**
 * 泛型类,可以根据传入泛型参数去对应属性方法
 * 
 * @author 郝一鸣
 *
 * @param <T>
 *            球类
 */
public class Box3<T> {
	// 定义一个泛型
	private T t;

	// 泛型的设置和读取方法
	/**
	 * @return t 球类
	 */
	public T getT() {
		return t;
	}

	/**
	 * @param t
	 *            把球放入盒子
	 */
	public void setT(T t) {
		this.t = t;
	}
	
	public void show(T t){
		System.out.println(t);
	}

}
