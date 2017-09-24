package win.sonic.l.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试map
 * 
 *
 */
public class MapTest {

	public static void main(String[] args) {
		// 创建一个sonic对象
		Sonic[] sonic = Sonic.addId(10);
		// 实例化一个map对象
		Map<Integer, Sonic> hm = new HashMap<Integer, Sonic>();
		// 批量把sonic对象放入map中
		for (int i = 0; i < 5; i++) {
			hm.put(i + 1, sonic[i]);
		}
		// 用迭代的方式遍历输出map内value值,迭代器泛型为key值
		Iterator<Integer> i = hm.keySet().iterator();
		while (i.hasNext()) {
			System.out.println(hm.get(i.next()));
		}

		/* keyset()方法,返回一个键值Set集合 */
		System.out.println("----------keyset()方法----------------");
		Set<Integer> ks = hm.keySet();
		for (Integer is : ks) {
			System.out.println(is);
		}

		/* 测试map的entry方法,返回一个泛型<Entry<k,v>>的set数组 */
		System.out.println("----------entry方法----------------");
		Set<Entry<Integer, Sonic>> s = hm.entrySet();
		// 用增强for循环,同时输出map的key和value的值
		for (Entry<Integer, Sonic> entry : s) {
			// 返回的每一项都是entry,且有方法可以获取map的key和value对象
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}

	}

}
