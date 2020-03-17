package win.sonic.r.generic;

//创建一个泛型类
public class Fan<E> {
	// 创建一个泛型属性
	private E e;

	// 创建一个泛型方法
	public E set(E e) {
		this.e = e;
		return e;
	}


}
