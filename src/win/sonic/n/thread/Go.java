package win.sonic.n.thread;

public class Go {

	public static void main(String[] args) {
		// 创建餐厅
		BBQ b = new BBQ();
		// 创建厨师
		Cook c1 = new Cook(1, 10, b);
		Cook c2 = new Cook(2, 5, b);
		Cook c3 = new Cook(3, 20, b);
		// 创建顾客
		Customer u1 = new Customer("王先生", b, 1);
		Customer u2 = new Customer("李先生", b, 1);
		Customer u3 = new Customer("武女士", b, 2);
		Customer u4 = new Customer("朱先生", b, 2);
		Customer u5 = new Customer("林女士", b, 3);

		u1.start();
		c1.start();
		c2.start();
		u2.start();
		c3.start();
		u3.start();
		u4.start();
		u5.start();

	}

}
