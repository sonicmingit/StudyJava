package win.sonic.practice.shopping;

/**
 * 非正常商品抽象父类
 * 
 * @author 郝一鸣
 *
 */
public abstract class NonGoods extends Goods {
	// 非正常商品总数
	private int tNum;

	/**
	 * 获取本类商品总数
	 * 
	 * @return tNum
	 */
	public int gettNum() {
		return tNum;
	}

	public NonGoods() {
		// 每创建一件商品,正常商品总数+1
		tNum++;
	}

}
