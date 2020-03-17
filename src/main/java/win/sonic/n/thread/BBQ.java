package win.sonic.n.thread;

import java.util.ArrayList;

public class BBQ {
	// 已考好菜品
	private ArrayList<String> menu = new ArrayList<String>();
	// 本店共做菜数
	public static int count;

	// 上菜
	public String serving() {
		// 烤完库存就不考了
		if (count > 11) {
			System.out.println("本店今天烧烤已卖完~请明天再来!");
			return "";
			// 还没考好,请等待
		} else if (menu.isEmpty()) {
			System.out.println("菜还没烤好,请稍等");
			return "";
		} else {
			return menu.remove(0);
		}
	}

	// 添加烤好的菜
	public void add(String name) {
		menu.add(name);

	}

	// 获取已考好菜品数
	public int getCount() {
		return menu.size();
	}

}
