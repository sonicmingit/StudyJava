package win.sonic.i.inter;
//ai实现接口,必须实现ai的所有方法
public class Ai implements IA {
//ia接口方法的重载
	@Override
	public String ia() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void iaa() {
		// TODO 自动生成的方法存根

	}
	public static void main(String[] args) {
		//接口IA不能实例化,但是能向上造型多态
		IA ia = new Ai();
		//此时ia可以调用Ai的方法和IA的常量
		System.out.println(ia.a);
		//指向IA的方法
		ia.ia();
		
	}

}
