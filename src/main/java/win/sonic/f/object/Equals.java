package win.sonic.f.object;

import java.util.Arrays;

public class Equals {
	String str = "1";
	int i = 1;
	double d = 1.1;
	int[] id = { 1, 1 };

	/*
	 * （非 Javadoc）
	 * 
	 * @see 重写Equals的equals方法,比较类里的四个参数,如果都相同,判定相同
	 */
	@Override
	public boolean equals(Object obj) {
		// 1.如果比较的是同一个对象,返回ture
		if (this == obj)
			return true;
		// 2.如果比较的对象是空值,则直接返回false
		if (obj == null)
			return false;
		// 3.如果getClass()值不相同,则返回false
		if (getClass() != obj.getClass())
			return false;
		// 将其他类对象强制转换为Equals类
		Equals other = (Equals) obj;
		// 4.此时已都为Equals类对象,去比较需要比较的成员变量是否相同
		// 浮点型对比
		if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d))
			return false;
		// 整型对比
		if (i != other.i)
			return false;
		// 数组对比
		if (!Arrays.equals(id, other.id))
			return false;
		// 字符型对比
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}

	public Equals(int i) {
		super();
		this.i = i;
	}

	public Equals() {
		super();
	}
}
