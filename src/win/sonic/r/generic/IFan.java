package win.sonic.r.generic;

/**
 * 泛型接口测试
 * @author 郝一鸣
 *
 */
public interface IFan<T> {	
	void show();
	<T> void fan();
	<E>E fan2();
	<S>S fans(S s);
}
