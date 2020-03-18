package win.sonic.i.inter.school;

/**
 * 一个住宿的接口,包含住宿的方法和地点
 * 
 * @author 郝一鸣
 */
public interface IStay {
	// 住的地方
	String dorm = "宿舍";
	String apartment = "教工公寓";
	String hotel = "招待所";

	/**
	 * 住在哪里
	 */
	void whereStay();
}
