﻿package win.sonic.n.thread.fan;
/**
 * 创建产品类，包含产品的一些属性，以及获取这些属性的方法
 * @author Sean Fan
 *
 */
public class Product {
	
	//设置产品相关的属性
	//类型
	private String type = "";
	//名称
	private String name;
	//重量
	private double weight;
	//价格
	private double price;
	//生产企业
	private String company;

	//Product类的空构造
	public Product() {
		super();
	}

	/**
	 * Product类的有参构造方法，设置产品的生产企业，类型，名称，重量，价格等
	 * @param producer
	 * @param type
	 * @param name
	 * @param weight
	 * @param price
	 */
	public Product(Producer producer, String type, String name, double weight, double price) {
		super();
		//设置产品类别
		this.type = type;
		//设置产品名称
		this.name = name;
		//设置产品重量
		this.weight = weight;
		//设置产品价格
		this.price = price;
		//设置产品生产企业
		this.company = producer.getCompany();
	}

	//获取产品类型
	public String getType() {
		return type;
	}

	//获取产品名称
	public String getName() {
		return name;
	}

	//获取产品重量
	public double getWeight() {
		return weight;
	}

	//获取产品价格
	public double getPrice() {
		return price;
	}

	//获取产品生产企业
	public String getCompany() {
		return company;
	}

}
