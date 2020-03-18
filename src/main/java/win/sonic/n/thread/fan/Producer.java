package win.sonic.n.thread.fan;

import java.util.ArrayList;
import java.util.Random;
/**
 * 创建生产者类，为仓库中增补产品
 * @author Sean Fan
 *
 */
public class Producer extends Thread {
	
	//生产者相关的属性
	//公司名称
	private String company;
	//工人名称
	private String[] people;
	
	
	//与产品及仓库相关的属性
	//与仓库建立关联关系
	private Store store;
	//产品列表
	private ArrayList<Product> product = new ArrayList<>();
	//实例化Random对象
	private Random random = new Random();

	/**
	 * Producer类的构造方法，设置公司、职工等属性，并将仓库对象导入
	 * @param company
	 * @param people
	 * @param store
	 */
	public Producer(String company, String[] people, Store store) {
		super();
		//设置公司名
		this.company = company;
		//导入职工列表
		this.people = people;
		//导入仓库对象
		this.store = store;
	}

	//将产品对象放入仓库
	public void setProduct(Product product) {
		this.product.add(product);
	}

	//获取生产商
	public String getCompany() {
		return company;
	}

	//获取生产者
	public String getPeople() {
		//在生产者列表中随机选取一个名字返回
		int i = random.nextInt(people.length);
		return people[i];
	}

	/**
	 * 由于该类继承Thread类，此处重写run方法
	 */
	public void run() {
		//设置int型变量i，用于后期生成随机数
		int i = 0;
		//死循环，使生产者持续生产
		while (true) {
			//随机选取产品进行生产
			i = random.nextInt(this.product.size());
			//线程通信，在仓库对象时锁定资源
			synchronized (store) {
				//向仓库内放置新生产的产品
				store.setProduct(product.get(i));
				//唤醒等待产品的线程
				store.notify();
				//输出当前生产商品的信息
				System.out.println(company + " 公司 "/* 生产的 " */ + getPeople() + " 师傅生产的 " + product.get(i).getType()
						+ " 商品 " + product.get(i).getName() + " 入库了！欢迎各位顾客购买~^O^ ");
				try {
					//让当前进程休眠1000毫秒
					this.sleep(1000);
					//捕获线程中断异常
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
