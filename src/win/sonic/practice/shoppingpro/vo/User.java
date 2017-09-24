package win.sonic.practice.shoppingpro.vo;

/**
 * 用户数据
 * 
 * @author 郝一鸣
 *
 */
public class User {
	// 顾客编号
	private int userid;
	// 会员卡号自增
	private static int num = 100001;
	// 顾客姓名
	private String uname;
	// 顾客身份证
	private String id = null;
	// 顾客生日	
	private String birthday = null;
	// 顾客地址
	private String address = null;
	// 顾客电话
	private String tel = null;

	/**
	 * @return userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @return num
	 */
	public static int getNum() {
		return num;
	}

	/**
	 * @param userid
	 *            要设置的 userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname
	 *            要设置的 uname
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            身份证号 
	 */
	public void setId(String id) {
		this.id = id;
		//根据用户身份证号截取设置生日
		this.birthday = this.birthday.substring(6, 14);
	}

	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 设置生日
	 * 
	 * @param birthday
	 *            字符串生日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            要设置的 tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @param num
	 *            要设置的 num
	 */
	public static void setNum(int num) {
		User.num = num;
	}

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userid=" + userid + ", uname=" + uname + ", id=" + id + ", birthday=" + birthday + ", \naddress="
				+ address + ", tel=" + tel + ",num=" + num + "]";
	}

	/**
	 * 录入用户信息
	 * 
	 * @param uname
	 *            姓名
	 * @param id
	 *            身份证号
	 * @param address
	 *            地址
	 * @param tel
	 *            电话
	 */
	public User(String uname, String id, String address, String tel) {
		super();
		// 每创建一个,会员卡号自增
		num++;
		this.userid = num;
		this.uname = uname;
		this.id = id;
		// 通过身份证号获取生日,id为null时,取消设置
		if (id != null) {
			this.birthday = id.substring(6, 14);
		}
		this.address = address;
		this.tel = tel;
	}

	/**
	 * 简单只录入姓名
	 * 
	 * @param uname
	 */
	public User(String uname) {
		super();
		num++;
		this.userid = num;
		this.uname = uname;
	}

	public User() {
		super();
		num++;
		this.userid = num;
		
	}
}
