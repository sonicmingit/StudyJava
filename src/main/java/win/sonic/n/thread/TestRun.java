package win.sonic.n.thread;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;

//20170816 看编程思想测试多线程
public class TestRun implements Runnable {
	protected int count = 10;
	private static int taskcount=0;
	private final int id = taskcount++;

	public TestRun() {
	}

	public TestRun(int count) {
		super();
		this.count = count;
	}

	public String stat() {
		String n = (count > 0 ? count : "end!")+"";
		return "#" + id + "(" + n + ")";
	}

	@Override
	public void run() {
		while (count-- > 0) {
			System.out.println(stat()+" ");
		//	Thread.yield();
			int n  = (int) (Math.random()*100);
			System.out.println("延时"+n+"秒");
			try {
				TimeUnit.MILLISECONDS.sleep(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new TestRun(5).run();
			//new Thread(new TestRun(5)).start();			
		}		
		System.out.println("1111");
	}
	
	
	
}
