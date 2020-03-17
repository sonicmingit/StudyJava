package win.sonic.uuu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建一个正则匹配类
 * @author 郝一鸣
 *
 */
public class Regex {
	
	/**
	 * 匹配传入字符串是否符合传入正则
	 * @param reg 正则表达式
	 * @param str 需要验证的字符串
	 * @return b 验证结果
	 */
	public static Boolean regex(String reg, String str) {
		Pattern p = Pattern.compile(reg);
		Matcher m =p.matcher(str);
		return m.matches();
	}
	
}
