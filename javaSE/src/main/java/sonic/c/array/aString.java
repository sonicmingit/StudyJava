package sonic.c.array;
/**
 * 字符串的方法练习
 * 
 * @author Sonic
 *
 */
public class aString {

	public static void main(String[] args) {
		// 创建一个字符串用来操作
		String[] a = { "123", "456", "abc", "efg", ",254," };

		/* 字符串比较 */
		// .equals() 返回布尔值
		// 判断字符串内容是否相等
		String b = "123";
		System.out.println("a[0]是否等于123:" + a[0].equals("123"));
		System.out.println("a[0]是否等于b:" + a[0].equals(b));

		// .equalsIgnoreCase() 返回布尔值
		// 判断两个字符串是否相等
		String c = "456";
		System.out.println("a[1]是否等于c:" + a[1].equalsIgnoreCase(c));

		// .compareTo() 返回int 返回0相同,返回其他不同
		// 判断两个字符串的ACS码是否相同
		String d = "abc";
		String e = "asd";
		System.out.println("a[2]的ACSⅡ是否与d相同:" + a[2].compareTo(d));
		System.out.println("a[2]的ACSⅡ是否与e相同:" + a[2].compareTo(e));

		// .startsWith() 返回布尔
		// 判断字符串是否以括号内字符串开头
		String f = "e";
		System.out.println("a[3]是否以ef字母开头:" + a[3].startsWith("ef"));
		System.out.println("a[3]是否以字符串f1开头:" + a[3].startsWith(f));

		// .endsWith() 返回布尔
		// 判断字符串是否以括号内字符串结尾
		String g = ",";
		System.out.println("a[4]是否以4,结尾:" + a[4].endsWith("4,"));
		System.out.println("a[4]是否以字符串g结尾:" + a[4].endsWith(g));
		System.out.println("----------------------------------------\n----------------------------------------");

		/* 字符串搜索 */
		String s = "asjdhklj54354 *(&*&*dalkjd 545";
		System.out.println("&第一次出现的位置:" + s.indexOf('&'));
		System.out.println("45第一次出现的位置:" + s.indexOf("54"));
		System.out.println("45最后一次出现的位置:" + s.lastIndexOf("54"));
		System.out.println("----------------------------------------\n----------------------------------------");

		/* 字符串的提取方法 */
		String x = "01234444 5 6789sONIc";
		// 字符提取
		char x1 = x.charAt(5);
		System.out.println("提取位置5的字符:" + x1);
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------");
		// 字符串指定开始位置提取
		String x2 = x.substring(2);
		System.out.println("提取从位置2开始的字符串:"+x2);
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------");
		// 字符串指定区间提取
		String x3 = x.substring(1, 5);
		System.out.println("提取1-5位置的字符串:" + x3);
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------");
		// 字符串连接
		String x4 = "abcd";
		System.out.println("连接x和x4字符串:" + x.concat(x4));
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------");
		// 替换单个字符
		String x5 = x.replace('4', '@');
		System.out.println("把字符4替换为@:" + x5);
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------");
		// 替换指定字符串
		String x6 = x.replace("4", "@@");
		System.out.println("把字符串4替换为@@:" + x6);
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------");
		// 去掉字符串空格
		System.out.println("去掉字符串空格:" + x.trim());
		System.out.println("----------------------------------------");
		// 小写转换为大写
		System.out.println("字符串转换为大写:" + x.toUpperCase());
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------");
		// 大写转换为小写
		System.out.println("字符串转换为小写" + x.toLowerCase());
		System.out.println("原字符串x:" + x);
		System.out.println("----------------------------------------\n----------------------------------------");

		/* StringBuffer方法 */
		System.out.println("StringBuffer方法\n以下方法都会修改原字符串!!!");
		StringBuffer str = new StringBuffer("0123456 abc");
		System.out.println("原字符串为:"+str);		
		System.out.println("----------------------------------------");
		// 任意字符插入字符串
		System.out.println("在第五个位置插入sonic:" + str.insert(5, "sonic"));
		System.out.println("原字符串:" + str);
		System.out.println("----------------------------------------");
		//倒置字符串
		str = new StringBuffer("0123456 abc");		
		System.out.println("倒置字符串:"+str.reverse());
		System.out.println("原字符串:" + str);
		System.out.println("----------------------------------------");
		str = new StringBuffer("0123456 abc");		
		//删除指定区间字符串
		System.out.println("删除从0到6位置的字符串:"+str.delete(0,6));
		System.out.println("原字符串:" + str);
		System.out.println("----------------------------------------");
		str = new StringBuffer("0123456 abc");
		//删除指定位置字符串
		System.out.println("删除位置6的字符串:"+str.deleteCharAt(5));
		System.out.println("原字符串:" + str);
		System.out.println("----------------------------------------");
		str = new StringBuffer("0123456 abc");
		//把指定区间字符串替换新的字符串
		System.out.println("把1-5位置的字符串替换为sonic:"+str.replace(1,5,"sonic"));
		System.out.println("原字符串:" + str);
		System.out.println("----------------------------------------");
		str = new StringBuffer("0123456 abc");
		//替换某移位置字符为指定字符	
		//setCharAt(int,ch)没有返回值,只是修改原字符串
		str.setCharAt(1,'@');
		System.out.println("替换1位置字符为@(此方法没有返回值):"+str);
		System.out.println("原字符串:" + str);
		System.out.println("----------------------------------------");

	}

}
