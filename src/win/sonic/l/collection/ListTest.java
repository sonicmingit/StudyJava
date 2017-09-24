package win.sonic.l.collection;

import java.util.*;

public class ListTest {

	public static <T>  void showlist(List<T> l){
		for (T a : l) {
			System.out.println(a);
		}
	}
	public static void main(String[] args) {
		// 创建十个类
		Sonic[] sonic = Sonic.addId(10);
		// 创建一个ArrayList数组
		List<Sonic> aList = new ArrayList<Sonic>();

		// 批量添加Sonic类对象到aList
		for (int i = 0; i < sonic.length; i++) {
			aList.add(sonic[i]);
		}
		// 遍历输出aList
		for (Sonic l : aList) {
			System.out.println(l);
		}
		/* ArrayList其他方法 */
		System.out.println("----------测试ArrayList方法----------");
		// 输出aList长度
		System.out.println("aList长度:" + aList.size());
		// 添加到指定位置
		aList.add(5, sonic[5]);
		// 输出展示
		System.out.println("----------添加5到第五个位置----------");
		for (Sonic l : aList) {
			System.out.println(l);
		}
		// 批量添加,创建一个Sonic数组,设置两个值,通过Arrays.aslist()转换,然后批量添加
		Sonic[] s = { new Sonic("999", 999999), new Sonic("888", 888888) };
		aList.addAll(0, Arrays.asList(s));
		// 获取指定位置对象
		System.out.println(aList.get(0));
		// 检查列表中是否包含某项,返回true包含
		aList.contains(sonic[0]);
		// 返回列表中某元素的第一个位置,-1表示没有
		System.out.println(aList.indexOf(sonic[5]));
		// 判断是否为空列表
		aList.isEmpty();
		// 删除某元素(第一个位置的)或者某位置元素
		aList.remove(0);
		aList.remove(sonic[5]);
		// 输出展示
		System.out.println("----------以上操作完输出----------");
		showlist(aList);
		//批量删除
		aList.removeAll(Arrays.asList(s));
		// 删除所有元素
		aList.clear();

		/* 测试LinkedList */
		System.out.println("----------测试LinkedList方法----------");
		// 创建一个LinkedList
		List<Sonic> link = new LinkedList();
	}
}
