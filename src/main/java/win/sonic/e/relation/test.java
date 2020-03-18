package win.sonic.e.relation;

import java.nio.channels.NetworkChannel;

public class test {
public static void main(String[] args) {
	//A创建,B实例化(组合关系时)
		A a = new A();
		//实例化一个C,用于调用A中的含c方法
		C c = new C();
		//调用A的包含C类对象的方法,C被实例化
		a.methodC(c);
		//改变C的属性,再次调用A的方法会改变
		c.c="C的属性改变了";
		a.methodC(c);
	
}
}
