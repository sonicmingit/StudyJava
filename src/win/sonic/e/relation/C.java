package win.sonic.e.relation;

/**
 * AC为依赖关系
 * 
 * @author 郝一鸣
 *
 */
public class C {
	// 创建一个c的私有属性
	public String c;
	// 记录被调用次数
	static int num;

	{
		num++;
		System.out.println("C的实例块,说明这是C被实例化了.C被调用了" + num);
		System.out.println("C类的c属性为" + c);
	}

}
