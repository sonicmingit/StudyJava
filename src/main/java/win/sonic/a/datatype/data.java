package win.sonic.a.datatype;

public class data {
//数字转换char
	public data(int a){
		char b = (char) a;
		System.out.println(b);
	}
//char转换数字
	public data(char a){
		int b = a;
		System.out.println(b);
	}
	void char1(char a){
		int b = a;
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		//八种数据类型
		//整型
		byte a = 12;//8
		short b = 23213;//16
		int c = 465;//32
		long d =23213213;//64
		//浮点型
		float e =12.12f;//32 后面必须加f
		double f =12.12;//64
		//字符型
		char g = 'a';//16 必须是单引号
		//布尔型
		boolean h = true;
		
		
		//布尔值转换
		data s = new data(37085);
		data s1 = new data('郝');	
		s1.char1('郝');	
		s1.char1('一');
		s1.char1('鸣');
		System.out.println("输出一个ASCⅡ码\n-------------");
		for(int x=0;x<128;x++){
			char y = (char) x;
			System.out.println("ascⅱ码"+x+"对应："+y);
		}
	}
}
