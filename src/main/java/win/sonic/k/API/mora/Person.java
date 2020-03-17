package win.sonic.k.API.mora;

/**
 * 玩家类
 * @author Administrator
 *
 */
public class Person {
	//玩家的姓名
	String name;
	//玩家出的拳
	int i = 0;

	//获得玩家姓名
	public String getName() {
		return name;
	}

	//设置玩家姓名
	public void setName(String name) {
		this.name = name;
	}

	//获得玩家出的拳
	public int getI() {
		return i;
	}

	//设置玩家出的拳
	public void setI(int i) {
		this.i = i;
	}
}
