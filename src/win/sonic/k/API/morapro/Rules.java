package win.sonic.k.API.morapro;

/**
 * 结果判断规则,利用接口和多态
 * 
 * @author 郝一鸣
 *
 */
public class Rules {
	//总局数
	public static int count = 0;
	//方法传入的第一个对象获胜次数
	public static int pn1 = 0;
	//方法传入的第二个对象获胜次数
	public static int pn2 = 0;

	/**
	 * 2人猜拳的规则,比较后输出获胜方的名字! 平局直接输入平局!
	 * 
	 * @param p1
	 *            玩家1
	 * @param p2
	 *            玩家2
	 * @return 获胜方姓名,平局返回平局
	 */
	public static String player2(IWhat p1, IWhat p2) {
		//开一局,比赛局数+1
		count++;
		// 平局判断
		if (p1.getOut() == p2.getOut()) {
			return "平局";
		}
		// 赢得情况
		else if (p1.getOut() - p2.getOut() == 1 || p1.getOut() - p2.getOut() == -2) {
			//p1获胜+1
			pn1++;
			return p1.getName();
		} else {
			//p2获胜+1
			pn2++;
			return p2.getName();
		}
	}
}
