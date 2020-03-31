
package sonic.k.API.morapro;

/**
 * 创建一个玩家父类(包括电脑和人类)</b> 创建一个父类方法,判断出的拳是什么,从int转换String(相当于翻译)
 * 
 * @author 郝一鸣
 *
 */
public class Player {
	/**
	 * 把传入的int转换成字符串,相当于翻译
	 * 
	 * @param out
	 *            传入子类出拳结果
	 * @return 转换后的字符串
	 */
	public String judge(int out) {
		switch (out) {
		case 1:
			return "剪刀";
		case 2:
			return "石头";
		default:
			return "布";
		}
	}
	/*
	 * public static void main(String[] args) { Player p = new Player();
	 * System.out.println(p.judge(1)); }
	 */
}
