package win.sonic.i.inter.compareto;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		//创建需要排序的对象
		Student st1 = new Student("李晓东", 11);
		Student st2 = new Student("朱爱上", 22);
		Student st4 = new Student("王大太", 43);
		Student st3 = new Student("任为", 21);
		Student st5 = new Student("李但是", 12);
		Student st6 = new Student("王速度", 50);
		//把排序对象传入数组
		Student[] s = {st1,st2,st3,st4,st5,st6};
		//用数组的方法去排序,规则根据重写的compareto方法
		Arrays.sort(s);
		for (Student e : s) {
			System.out.println(e);
		}
		//输出结果:		
		/*Student [name=王速度, age=50]
		 *Student [name=王大太, age=43]
		 *Student [name=朱爱上, age=22]
		 *Student [name=任为, age=21]
		 *Student [name=李但是, age=12]
		 *Student [name=李晓东, age=11]*/
	}

}
