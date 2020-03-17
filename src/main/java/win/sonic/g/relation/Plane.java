package win.sonic.g.relation;

public class Plane extends Flyer {

	@Override
	public void takeOff() {
		System.out.println("飞机的起飞方式:慢慢滑向起飞!");
		
	}

	@Override
	public void landing() {
		System.out.println("飞机的着陆方式:轮子着陆,慢慢前行减速!");
		
	}

}
