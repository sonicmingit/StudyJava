package win.sonic.k.API.mora;

/**
 * 游戏类
 * @author Administrator
 *
 */
public class Game {
	//声明电脑
	Computer com;
	//声明玩家
	Person p;

	//游戏的构造方法
	public Game(Computer com, Person p) {
		super();
		this.com = com;
		this.p = p;
	}

	//玩的方法
	public void play() {
		// 玩家出拳
		int j = p.getI();
		// 机器出拳
		int i = com.check();
		// 出拳进行比较 
		if (j - i == 1 || i - j == 2) {
			System.out.println("玩家赢赢赢赢赢赢");
		}
		else if (i - j == 1 || j - i == 2) {
			System.out.println("电脑赢赢赢赢赢赢");

		} else {
			System.out.println("平局");
		}
	}
}
