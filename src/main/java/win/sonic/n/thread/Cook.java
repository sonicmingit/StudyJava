package win.sonic.n.thread;

public class Cook extends Thread {
	// 厨师名
	private int name;
	//烤菜时间
	private long time;

	public Cook(int name, long time, BBQ b) {
		super();
		this.name = name;
		this.time = time;
		this.b = b;
	}

	// 餐厅
	BBQ b = new BBQ();

	/**
	 * @param time
	 *            厨师休息时间
	 */
	public void run() {
		// 当餐厅做菜数大于100则打烊
		while (BBQ.count < 11) {
			synchronized (b) {
				// 随机创建菜名
				String name = "" + (int) (Math.random() * 100);
				// 添加到餐厅
				b.add(name);
				//叫人取菜
				b.notify();
				System.out.println(this.name + "号厨师烤好了" + name + "号菜!");
				try {
					// 休息time秒
					Thread.sleep(time * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
		
	}

}
