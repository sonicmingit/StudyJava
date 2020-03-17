package win.sonic.g.relation;

public class TestFlyer {
	//4.25相当于多态的向上造型
	public static void testFlay(Flyer fly) {
		fly.takeOff();
		fly.landing();		
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		Birds bird = new Birds();
		Plane plane = new Plane();
		testFlay(bird);
		testFlay(plane);

	}

}
