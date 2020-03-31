package sonic.d.modifier;

import java.util.Scanner;
/**
 * 创建SubString类
 * 实现按需剪切字符串
 * @author Sean Fan
 *
 */
public class SubString {
	
	private String newStr;               //
	private char[] oldStrArray;          //
	
	/**
	 * 创建getNewStr方法，返回截取完成的字符串
	 * @return newStr
	 */
	public String getNewStr(){
		return newStr;
	}
	
	/**
	 * 创建默认剪切构造方法，用户仅需输入待剪切字符串和终止截取位即可完成剪切
	 * @param oldStr
	 * @param endnum
	 */
	public SubString(String oldStr, int endnum) {
		int bgnum = 0;                                                       //设置截取起始位为0
		oldStrArray = oldStr.toCharArray();                                  //将传入的字符串转换为字符数组
		char[] newStrArray = new char[endnum-bgnum];                         //创建与待截取字段大小相同的字符数组newStrArray
		System.arraycopy(oldStrArray, bgnum, newStrArray, 0, endnum-bgnum);  //使用数组copy方法完成相应元素的拷贝，用newStrArray接收
		newStr = String.valueOf(newStrArray);                                //将newStrArray的元素转换为字符串
	}
	
	/**
	 * 创建自定义剪切构造方法，用户需输入待剪切字符串和截取起止位
	 * @param oldStr
	 * @param bgnum
	 * @param endnum
	 */
	public SubString(String oldStr, int bgnum, int endnum) {                  //同上，仅截取起始位为用户自定义
		oldStrArray = oldStr.toCharArray();
		char[] newStrArray = new char[endnum-bgnum];
		System.arraycopy(oldStrArray, bgnum, newStrArray, 0, endnum-bgnum);
		newStr = String.valueOf(newStrArray);
	}
	
	/**
	 * 创建主方法，测试SubString类的使用
	 * @param args
	 */
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("自定义截取需填写截取的起止位，默认从开头截取，仅需填写终止截取位");
		System.out.print("是否自定义截取字符串？[Y/N]");
		SubString subString;
		if(scanner.next().equals("Y")){
			System.out.print("请输入字符串与截取起止位：");
			subString = new SubString(scanner.next(), scanner.nextInt(), scanner.nextInt());
		}else{
			System.out.print("请输入字符串与截取终止位：");
			subString = new SubString(scanner.next().toString(), scanner.nextInt());
		}
		System.out.println(subString.getNewStr());
	}
}
