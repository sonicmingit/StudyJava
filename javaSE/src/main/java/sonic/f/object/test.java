package sonic.f.object;

public class test {
	public static void main(String[] args) {
		Equals t1 = new Equals();
		Null t2 = new Null();
		Use t3 = new Use();
		Equals t4 = new Equals();
		Equals t5 = new Equals(2);
		// 1.如果比较的是同一个对象,返回ture
		System.out.println(t1.equals(t1));
		// 2.如果比较的对象不存在,则直接返回false
		System.out.println(t1.equals(t2));
		// 3.如果getClass()值不相同,则返回false
		System.out.println(t1.getClass());
		System.out.println(t3.getClass());
		// t1和t3的类里的值相同,但是getClass()不同;
		// 4.如果比较对象为同一个类时,去比较需要比较的成员变量是否相同
		// t1和t4都为Equals类,且成员变量相同;
		System.out.println(t1.equals(t4));
		// t1和t5的变量i不同
		System.out.println(t1.equals(t5));
	}
}
