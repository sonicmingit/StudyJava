package win.sonic.c.array;
/**
 * 数组合并//去0
 * @author 郝一鸣
 *
 */
public class pArrMerge {
	public static void main(String[] args) {
		/**
		 * 作业题1: 现给出两个数组 数组A：“1，2，4，5，6” 数组B：“4，6，8，9，0，11” 将以上两个数组合并为一个数组。
		 */
		System.out.println("作业题1:现给出两个数组 数组A：“1，2，4，5，6” 数组B：“4，6，8，9，0，11” 将以上两个数组合并为一个数组。\n");
		// 用数组复制的方法合并两个数组
		// 创建两个数组
		int[] a = { 0, 1, 2, 3, 4, 5 };
		int[] b = { 6, 7, 8, 9, 10 };
		// 创建两个变量用来保存两个数组长度，方便后期使用
		int a1 = a.length;
		int b1 = b.length;
		// 创建一个用来合并a、b的数组c，长度为两数组长度相加
		int[] c = new int[a1 + b1];
		// 运用数组复制的方法分别复制a和b到新数组,a从0位置开始复制a的长度,b从a的最后一个位置开始复制b的长度
		System.arraycopy(a, 0, c, 0, a1);
		System.arraycopy(b, 0, c, a1, b1);
		// 输出新数组
		System.out.print("合并的的数组为: ");
		for (int i : c) {
			System.out.print(i + " ");
		}
		System.out.println("");
		// 用concat()方法合并???
		System.out.println("——————————————————————————————————————————————————————");

		/**
		 * 作业题2:将数组{2，3，0，5，6，0，8，0，9}中非0的值存入到新的数组中。
		 */
		System.out.println("作业题2:将数组{2，3，0，5，6，0，8，0，9}中非0的值存入到新的数组中。\n");
		// 创建需要去0的数组
		int[] x = { 2, 3, 0, 5, 6, 0, 8, 0, 9, 0, 0, 9, 7, 5, 1 };
		//创建一个变量用来保存新数组的长度
		int j = 0;
		//通过判断非0数的个数,计算新数组的长度
		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0) {
				j++;
			}
		}
		//创建一个新数组用来保存去0的数组
		int[] y = new int[j];
		//变量清0,用于复制数组的非0项
		j = 0;
		//循环复制非0项
		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0) {
				System.arraycopy(x, i, y, j, 1);
				j++;
			}
		}
		//输出新数组
		System.out.print("去掉0后的新数组: ");
		for (int i : y) {
			System.out.print(i + " ");
		}
		;

	}
}
