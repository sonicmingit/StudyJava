package win.sonic.g.relation;

public class Birds extends Flyer {

	@Override
	public void takeOff() {
		System.out.println("鸟的起飞方式:先扇动翅膀!");
		
	}

	@Override
	public void landing() {
		System.out.println("鸟的着陆方式:脚先着陆!");
		
	}

}
