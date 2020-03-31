package sonic.k.API.mora;

import java.util.Random;

/**
 * 电脑出拳类
 * @author Administrator
 *
 */
public class Computer {
	public int check() {
		//电脑随机出0，1，2
		Random r = new Random();
		int i = r.nextInt(3);
		//输出电脑出的数值
		System.out.println("电脑出拳为：" + i);
		return i;
	}
}
