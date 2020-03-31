package sonic.c.array;
/**
 * 测试创建一个二维数组，把他合并成以为数组，并去掉重复项
 * 
 * @author Administrator
 *
 */
public class pArray2 {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 4, 6, 9 }, { 6, 2, 4, 9 }, { 9, 5, 1, 7 }, { 2, 6, 9, 7 } };
		int aL = 0;
		for (int i = 0; i < a.length; i++) {
			aL += a[i].length;
		}
		int[] b = new int[aL];
		int bL = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.arraycopy(a[i], j, b, bL, 1);
				bL++;
			}
		}
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
//		// 去掉重复值!!!!
//		int[] c = new int[100];
//		int cL = 0;
//		int[] d={0};
//		for (int i = 0; i < b.length; i++) {
//			for (int j = 1; j < b.length - 1; j++) {
//				if (b[i] == b[j]) {
//					System.arraycopy(d, 0, b, i, 1);
//					cL++;
//				}
//
//			}
//
//		}
//		//System.out.println(cL);
//		for (int i : c) {
//			System.out.print(i + " ");
//		}

	}

}
