package win.sonic.c.array;
import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 数组的创建
 * 数组的方法
 * 
 * @author Sonic
 *
 */
public class aArray {

	public static void main(String[] args) {
//一维数组的创建与使用
	// 创建一维数组的三种方法
		// 动态数组
		int[] a1 = new int[5];
		//两种创建静态数组的方法
		int[] a2 = new int[] { 1, 5, 4, 6 };
		int[] a3 = { 1, 5, 6, 8, 41, 0 };
	//创建一个空数组
		int[] a4 =new int[]{};
		
   //利用for循环遍历a1数组，为每一项赋值，并输出
		System.out.print("a1={");
		for (int i = 0; i < a1.length; i++) {
			a1[i]=i;
			System.out.print(a1[i]+", ");			
		}
		System.out.println("}");

	//利用增强for循环遍历数组a3
		//创建一个临时变量x用于存放数组a3的每一项值，然后输出
		System.out.print("a3={");
		for(int x:a3){
			System.out.print(x+", ");
		}System.out.println("}");
		
//二维数组的创建与使用
	//二维数组的创建
		int[][] b1 =new int[5][5];
		int[][] b2 = new int[][]{{4,2,6},{8,7,4,1},{7,2,9,}};
		int[][] b3 ={{4,2,6},{8,7,4,1},{7,2,9,}};
	//创建空数组
		int[][] b4 = new int[][]{};
		
	//利用for循环对二维数组进行遍历赋值及输出
		System.out.print("b1={");
		for (int i = 0; i < b1.length; i++) {
			System.out.print("{");
			for (int j = 0; j < b1[i].length; j++) {
				b1[i][j] = j;
				System.out.print(b1[i][j]+", ");				
			}	
			System.out.print("},");
		}System.out.println("}");

//数组的复制
	
	//复制数组的位数不能超限，否则会报错
		int[] x ={1,2,3,4,5,6,7};
		int[] y ={8,9,10,11,12,0,0};
	//System.arraycopy(src, srcPos, dest, destPos, length);
	//数组复制的方法（被复制数组，从第几项开始，复制的数组，从第几项开始，要复制几位）
	    System.arraycopy(x, 3, y, 5, 2);
	//数组只能用遍历的形式输出，不支持直接输出数组
		for (int i : y) {
			System.out.print(i+", ");
		}
		
		
		
	
		
	}

}
