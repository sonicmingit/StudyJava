package win.sonic.i.inter;
/**
 * 这是一个接口,关键字为<interface>
 *</br>接口名以大写I开头,接口名第一个字母大写
 */
public interface IA {
	// 接口只能定义常量,前面为默认修饰符,可以省略
	public static final String a = "常量a";
	// 修饰符可以省略
	String b = "修饰符可以省略b";

	/**
	 * A接口的方法,接口必须有抽象方法
	 * 
	 * @return
	 */
	public abstract String ia();

	/**
	 * 接口的抽象方法修饰符[public] [abstract]可以省略,不写时系统会自动添加</ br> 返回值不能省略
	 */
	void iaa();
}
