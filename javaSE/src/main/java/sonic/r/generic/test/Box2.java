package sonic.r.generic.test;

/**
 * 利用传入Object类装盒子
 * 
 * @author 郝一鸣
 *
 */
public class Box2 {
	// 创建一个对象
	Object obj;

	// 不用为每一种球类创建属性和方法
	/**
	 * @return obj 球类
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj
	 *            把球放入盒子
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

}
