package sonic.d.modifier;

import java.util.Arrays;

/**
 * ch7 作业2:需要按照下面要求进行： 1、class实现有以下两个方法 public int findMaxValue(int[]
 * anyOldOrderValues) ; public int[] findTopNValues(int[] anyOldOrderValues, int
 * n); 2、findMaxValue 返回最大值 且 findTopNValues 返回前n个最大值。
 * 
 */
public class ch7_2 {
	/**
	 * 返回最大值
	 * @param anyOldOrderValues 需要返回最大值的数列
	 * @return 最大值
	 */
	public int findMaxValue(int[] anyOldOrderValues) {
		//正序排列,返回最后一位,及最大值
		Arrays.sort(anyOldOrderValues);
		return anyOldOrderValues[anyOldOrderValues.length - 1];

	}
/**
 * 返回前n个最大值
 * @param anyOldOrderValues 需要返回最大值的数列
 * @param n 需要返回的最大值数量
 * @return 前n个最大值
 */
	public int[] findTopNValues(int[] anyOldOrderValues, int n) {
		//创建一个临时数组,用来接收需要返回的n个最大值
		int a[] = new int[n];
		Arrays.sort(anyOldOrderValues);
		for (int i = 0; i < n; i++) {
			a[i] = anyOldOrderValues[anyOldOrderValues.length - 1 - i];
		}
		return a;
	}

	public static void main(String[] args) {
		// 测试
		int[] a = { 1, 2, 3, 4, 5, 6, 999 };
		ch7_2 test = new ch7_2();
		System.out.println("数组最大值为:" + test.findMaxValue(a));
		System.out.println("前4最大值为:");
		for (int j : test.findTopNValues(a, 4)) {
			System.out.print(j + " ");
		}
	}
}
