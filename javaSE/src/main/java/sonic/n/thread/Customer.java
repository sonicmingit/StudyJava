package sonic.n.thread;

public class Customer extends Thread {
	// 消费者名字
	private String name;
	// 吃饭时间
	private int time;
	// 餐厅
	BBQ b = new BBQ();

	public void run() {
		while (BBQ.count < 11) {
			synchronized (b) {
				// 问菜好了没
				if (b.getCount() == 0) {
					System.out.println("还没烤好,请稍等...");
					try {
						b.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(name + "吃掉了" + b.serving() + "号菜!");
					BBQ.count++;
				}
				try {
					// 休息1秒5
					Thread.sleep(time * 1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		}
	}

	public Customer(String name, BBQ b, int time) {
		super();
		this.name = name;
		this.b = b;
		this.time = time;
	}
}
