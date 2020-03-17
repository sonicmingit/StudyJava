package win.sonic.c.array;
/**
 * Character类型的方法使用
 * @author Administrator
 *
 */
public class aCharacter {

	public static void main(String[] args) {
		// 测试Character的方法
		// 创建一个包含各种字符的字符型数组
		// 包含数字、大写字母、小写字母、空格
		char[] a = { '1', '2', 'f', ' ', 'D', 's', 'S' };
		
		//利用for循环判断是否为字母
		System.out.println("数组包含的字母有：");
		for (int i = 0; i < a.length; i++) {
			//用Character.isLetter(char)判断是否为字母,返回真假
			if(Character.isLetter(a[i])){
				System.out.print(a[i]+" ");
			}
		}
		System.out.println();
		
		//判断是否为数字
		System.out.println("数组包含的数字有：");
		for (int i = 0; i < a.length; i++) {
			//用Character.isDigit(char)判断是否为数字 ,返回真假
			if(Character.isDigit(a[i])){
				System.out.print(a[i]+" ");
			}
		}
		System.out.println();
		
		//判断是否为大写字母
		System.out.println("数组包含的大写字母有：");
		for (int i = 0; i < a.length; i++) {
			//用Character.isUpperCase(char)判断是否为大写字母 ,返回真假
			if(Character.isUpperCase(a[i])){
				System.out.print(a[i]+" ");
			}
		}
		System.out.println();
		
		//判断是否为小写字母
		System.out.println("数组包含的小写字母有：");
		for (int i = 0; i < a.length; i++) {
			//用Character.isLowerCase(char)判断是否为 ,返回真假
			if(Character.isLowerCase(a[i])){
				System.out.print(a[i]+" ");
			}
		}
		System.out.println();
		
		//判断是否为空格和换行
		System.out.println("数组包含的空格换行有：");
		for (int i = 0; i < a.length; i++) {
			//用Character.isWhitespace判断是否为 ,返回真假
			if(Character.isWhitespace(a[i])){
				System.out.print(a[i]+" ");
			}
		}
		
		
		
		
		
		
		
	}
}
