package win.sonic.k.API;

//引入math的包
import java.lang.*;

public class MathTest {

	public static void main(String[] args) {
		/* 包含各种数学方法 */
		// 含两个静态常量:π和e,保留15位
		System.out.println("π=" + Math.PI);
		System.out.println("e=" + Math.E);
		/* 都是静态方法,都能直接调用 */
		// 三角函数:正弦,余弦,正切,余切等
		double a = 0.5;
		double b = 1.2;
		System.out.println("正弦 "+Math.sin(a));
		System.out.println("余弦 "+Math.cos(a));
		System.out.println("反正弦 "+Math.asin(a));
		System.out.println("反余弦 "+Math.acos(a));
		System.out.println("正切 "+Math.tan(a));

		// 绝对值
		System.out.println("绝对值 "+Math.abs(a));
		// 向上取整
		System.out.println("向上取整 "+Math.ceil(a));
		// 向下取整
		System.out.println("向下取整 "+Math.floor(a));
		// 求两个数中的最大值
		System.out.println("两数最大值 "+Math.max(a, b));
		//两数最小值
		System.out.println("两数最小值 "+Math.min(a,b));
		
		//求开方 根号
		System.out.println("求开方"+Math.sqrt(25));
		//求e的任意次方
		System.out.println("求e的任意次方 "+Math.exp(5));
		//以10为底的对数 
		System.out.println("以10为底的对数 "+Math.log10(a));
		//自然对数 ln(x)或loge(x)
		System.out.println("自然对数 "+Math.log(5));
		//求距离某数最小的整数(按5分开,0.5算0,0.51算1)
		System.out.println("距离某数最小的整数 "+Math.rint(4.49));
		
		//随机数,返回0到1之间
		System.out.println("随机数 "+Math.random());
		//返回指定整数,强转换int*,乘以范围+1的整数
		int r= (int) (Math.random()*5)+1;
		System.out.println("1-5的随机数 "+r);			
	}
}
