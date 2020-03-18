package win.sonic.i.inter;

/**
 *类只能继承一个父类,但可以实现多个接口
 */
public class Aai extends Ai implements IA, IB{
//继承的父类有接口的方法重写,子类重写接口方法,直接继承父类方法
	@Override
	public void ib() {
		// TODO 自动生成的方法存根

	}
	
	//也可以再重写接口方法,向上造型时被调用
	

}
