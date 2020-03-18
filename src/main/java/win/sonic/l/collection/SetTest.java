package win.sonic.l.collection;

import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		Sonic[] sonic = Sonic.addId(10);
		//不需要泛型传入类实现Comparable方法接口
		Set<Sonic> h = new HashSet<Sonic>();
		h.add(sonic[1]);
		//如果对象已存在,则不再加入集合
		h.add(sonic[1]);
		h.add(sonic[2]);
		
		
		for (Sonic l : h) {
			System.out.println(l);
		}
		//如果对象已存在,则不再加入集合
		System.out.println(h.size());
		
		
		
	System.out.println("--------------------以下是TreeSet测试----------------------");	
		
		//Three方法,泛型传入类里必须要实现Comparable方法,否则报错
		Set<Sonic> t = new TreeSet<Sonic>();
		t.add(sonic[5]);
		t.add(sonic[5]);
		t.add(sonic[1]);
		//输出,根据泛型传入类Sonic的compareto方法进行输出排序
		for (Sonic l : t) {
			System.out.println(l);
		}
		System.out.println(t.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
