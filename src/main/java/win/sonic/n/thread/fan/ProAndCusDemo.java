package win.sonic.n.thread.fan;
/**
 * 创建一个测试类，测试生产者与消费者模型
 * @author Sean Fan
 *
 */
public class ProAndCusDemo {
	public static void main(String[] args){
		
		//创建仓库对象
		Store store = new Store();
		
		//创建生产者人名集合
		String[] name1 = {"老王","小李","小余","大张"};
		String[] name2 = {"老王","小花","小强","张狗"};
		//创建消费者人名集合
		String[] name3 = {"小华","雯雯","丽丽","小马哥","笑笑","强仔","铁铁"};
		
		//创建生厂商线程对象
		Producer producer1 = new Producer("双汇", name1, store);
		Producer producer2 = new Producer("思念", name2, store);
		
		//创建产品对象
		Product product1 = new Product(producer1, "生鲜", "猪后腿", 1, 28.5);
		Product product2 = new Product(producer1, "生鲜", "牛板筋", 1, 43.6);
		Product product3 = new Product(producer1, "肠类", "玉米肠", 1, 13.9);
		Product product4 = new Product(producer1, "肠类", "王中王火腿肠", 1, 13.9);
		Product product5 = new Product(producer2, "中餐", "速冻馄饨", 0.5, 13.9);
		Product product6 = new Product(producer2, "中餐", "手打水饺", 0.5, 23.9);
		Product product7 = new Product(producer2, "西点", "烤牛排", 1, 75.00);
		Product product8 = new Product(producer2, "西点", "微波炉披萨", 0.5, 33.9);
		
		//将产品对象导入生产商
		producer1.setProduct(product1);
		producer1.setProduct(product2);
		producer1.setProduct(product3);
		producer1.setProduct(product4);
		producer2.setProduct(product5);
		producer2.setProduct(product6);
		producer2.setProduct(product7);
		producer2.setProduct(product8);
//		producer2.setProduct(product5);
//		producer1.setProduct(product);
		
		//创建消费者线程对象
		Customer customer1 = new Customer(name3[1], store);
		Customer customer2 = new Customer(name3[2], store);
		Customer customer3 = new Customer(name3[3], store);
		Customer customer4 = new Customer(name3[4], store);
		Customer customer5 = new Customer(name3[5], store);
		Customer customer6 = new Customer(name3[6], store);
		Customer customer7 = new Customer(name3[0], store);
//		Customer customer8 = new Customer(name3[2], store);
//		Customer customer9 = new Customer(name3[2], store);
		
		//启动生产商线程
		producer1.start();
		producer2.start();
		
		//启动消费者线程
		customer1.start();
		customer2.start();
		customer3.start();
		customer4.start();
		customer5.start();
		customer6.start();
		customer7.start();
			
	}
}
