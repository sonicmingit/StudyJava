package win.sonic.l.collection;

/**
 * 用于测试集合的类
 * 
 * @author 郝一鸣
 *
 */
public class Sonic implements Comparable<Sonic> {
	/**
	 * 帐号
	 */
	private String iD;
	/**
	 * 密码
	 */
	private int password;

	/**
	 * @return iD
	 */
	public String getiD() {
		return iD;
	}

	/**
	 * @return password
	 */
	public int getPassword() {
		return password;
	}

	/**
	 * 自动生成Sonic类数组
	 */
	public static Sonic[] addId(int j) {
		Sonic[] sonic = new Sonic[j];
		// 排序生成帐号,随机生成六位密码
		for (int i = 0; i < j; i++) {
			sonic[i] = new Sonic("帐号" + String.valueOf(i + 1), (int) (Math.random() * 1000000));
		}
		return sonic;
	}

	/**
	 * 构造
	 * 
	 * @param iD
	 * @param password
	 */
	public Sonic(String iD, int password) {
		super();
		this.iD = iD;
		this.password = password;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sonic[帐号=" + iD + ", 密码=" + password + "]";
	}

	// TreeSet方法,泛型类里必须要实现Comparable方法,否则报错
	@Override
	public int compareTo(Sonic o) {
		return this.iD.compareTo(o.iD);		
	}

}
