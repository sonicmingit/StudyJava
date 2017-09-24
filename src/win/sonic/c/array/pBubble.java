package win.sonic.c.array;
import java.lang.reflect.Array;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @author 郝一鸣
 *
 * 第一次自己编写的方法,缺点就是计算量增加,每一项还会与自己进行比较,有些多余.
 */
public class pBubble {

	public static void main(String[] args) {
		// 创建一个需要排序的数组
		int[] a = { 5, 9, 7, 3, 9, 4, 3, 7, 4, 1, 9, 6 };
		//输出原数组
		System.out.print("未排序前的数组:");
		for (int i : a) {
			System.out.print(i+" ");
		}
		// 利用两次for循环进行前后数比较
		// 第一次现确定第一个比较的数字
		System.out.print("\n最终正序排序结果：");
		for (int i = 0; i < a.length; i++) {
			// 第一个数字确定后，依次跟其他数字比较，包括自己
			for (int j = 1; j < a.length - 1; j++) {
				// 当前一个数小于后一个数时，创建一个临时变量互换位置
				if (a[i] < a[j]) {
					int x = a[i];
					a[i] = a[j];
					a[j] = x;
				}
			}
		}
		// 输出最终结果
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");

		// 倒叙排列
		System.out.print("最终倒叙排序结果：");
		for (int i = 0; i < a.length; i++) {
			// 第一个数字确定后，依次跟其他数字比较，包括自己
			for (int j = 0; j < a.length - 1; j++) {
				// 当前一个数小于后一个数时，创建一个临时变量互换位置
				if (a[i] > a[j]) {
					int x = a[i];
					a[i] = a[j];
					a[j] = x;
				}
			}
//			System.out.print("第"+(i+1)+"次排序：");
//			for (int q : a) {
//				System.out.print(q + " ");
//			}
//			System.out.println("");
		}
		// 输出最终结果
		for (int i : a) {
			System.out.print(i + " ");
		}

		// 数组自带sort方法排序
		System.out.println("\n" + "---------------------------------------------------");
		System.out.print("利用数组自己的方法实现排序：");
		Arrays.sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
