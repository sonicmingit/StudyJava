package win.sonic.g.relation;

/**
 * <strong>作业 :</strong>
 * 创建抽象类Flyer，定义起飞，着陆抽象方法,创建子类Bird，Plane,定义TestFlyer类，定义如下方法：</br>
 * public void fly(Flyer flyer){} 在该方法中，测试Bird，Plane的起飞，着陆方法。
 * 
 * @author 郝一鸣
 *
 */
public abstract class Flyer {
	/**
	 * 起飞的抽象方法
	 */
	public abstract void takeOff();

	/**
	 * 着陆的抽象方法
	 */
	public abstract void landing();

}
