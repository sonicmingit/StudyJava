﻿package win.sonic.n.thread.fan;
/**
 * 创建顾客类，实现当仓库中有产品时从仓库买走产品，如果仓库中暂无产品，则等待
 * @author Sean Fan
 *
 */
public class Customer extends Thread {
	
	//创建消费者属性
	private String people;
	//与仓库建立关联关系
	private Store store;

	/**
	 * 创建Customer类的有参构造方法
	 * @param people
	 * @param store
	 */
	public Customer(String people, Store store) {
		super();
		//设置消费者
		this.people = people;
		//导入仓库对象
		this.store = store;
	}

	//获取消费者
	public String getPeople() {
		return people;
	}

	/**
	 * 由于该类继承Thread类，此处重写run方法
	 */
	public void run() {
		//死循环，实现消费者的持续消费
		while (true) {

			//当消费者对仓库进行操作时，将仓库对象锁定
			synchronized (store) {
				//若仓库中产品数量不为零
				if (store.getNum() > 0) {
					//从仓库中取出一件产品
					Product products = store.getProduct();
					//输出消费者及其消费产品的信息
					System.out.println("消费者 " + people + " 已将 " + products.getCompany() + " 生产的商品 " + products.getName()
							+ " 买走~~");
					try {
						//完成消费后，让消费者休息5000毫秒
						this.sleep(5000);
						//捕获线程中断异常
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					//若仓库内无库存，输出无货提示
					System.out.println("仓库暂时无货，请稍等~~");
					try {
						//让该线程等待，当仓库内有新产品出现时再被唤醒
						store.wait();
						//捕获线程中断异常
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
