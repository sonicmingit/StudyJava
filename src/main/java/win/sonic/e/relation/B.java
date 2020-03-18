package win.sonic.e.relation;

/**
 * AB为关联关系
 * 
 * @author 郝一鸣
 *
 */
public class B extends A{
	// 记录被调用次数
	static int num;
	{
		num++;
		System.out.println("B的实例块,说明这时B被实例化了.B被调用了"+num);

	}
	 void method(){
		 super.aaa="asdasd";
	 }
}
