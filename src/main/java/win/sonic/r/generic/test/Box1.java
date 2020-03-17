package win.sonic.r.generic.test;

/**
 * 普通方法把球放入盒子
 * 
 * @author 郝一鸣
 *
 */
public class Box1 {
	//每有一种球类就得创建次对象
	FootBall f;
	BasketBall b;
	TableTennis t;
	
	/*以及他们的放入及取出方法*/
	
	/**
	 * @return f
	 */
	public FootBall getF() {
		return f;
	}
	/**
	 * @param f 要设置的 f
	 */
	public void setF(FootBall f) {
		this.f = f;
	}
	/**
	 * @return b
	 */
	public BasketBall getB() {
		return b;
	}
	/**
	 * @param b 要设置的 b
	 */
	public void setB(BasketBall b) {
		this.b = b;
	}
	/**
	 * @return t
	 */
	public TableTennis getT() {
		return t;
	}
	/**
	 * @param t 要设置的 t
	 */
	public void setT(TableTennis t) {
		this.t = t;
	}
	


}
