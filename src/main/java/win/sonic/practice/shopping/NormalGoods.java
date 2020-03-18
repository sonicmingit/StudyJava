package win.sonic.practice.shopping;

/**
 * 正常商品抽象父类
 * 
 * @author 郝一鸣
 *
 */
public abstract class NormalGoods extends Goods {
	// 正常商品总数
	private static int tNum;

	/**
	 * 获取本类商品总数
	 * 
	 * @return tNum
	 */
	public int gettNum() {
		return tNum;
	}

	public NormalGoods() {
		super();
		// 每创建一件商品,正常商品总数+1
		tNum++;
	}
}
