package win.sonic.d.modifier;
//ttt5yjd-jdd4yh tttyyyyyjd@jddyyyyh
public class test {
public static void main(String[] args) {
//创建一个需要修改的字符串
	String sonic="ttt5yjd-jdd4yh";
	//创建一个SB对象等于之前的
StringBuffer  sonic1 =new StringBuffer(sonic);
//利用for循环去操作

//do{
for (int i = 0; i < sonic.length(); i++) {
	//判断第i为是否为数字
	if (Character.isDigit((sonic.charAt(i)))) {
		//创建一个字符x接收数字位
		char x=sonic.charAt(i);
		//创建一个字符y接收数字的后一位
		char y=sonic.charAt((i+1));
		//把字符x转换为字符对象x1
		Character x1= x;
		//把字符y转换为字符对象也
		Character y1= y;
		//把字符对象x1转换为整型x2
		int x2 =Integer.parseInt(x1.toString()) ;
//		String x3 =String.valueOf(x2);
		//把字符对象y1转换为字符串y2
		String y2 =y1.toString();
		//创建字符串用来保存要替换的字符
		String z="" ;		
		//通过for循环把x2个y2保存到z中
		for (int j = 0; j < x2; j++) {
			z+=y2;			
		}
		//用SB的替换方式替换要替换的内容
		sonic1.replace(i, i+1, z);
//		System.out.println(x);
//		System.out.println(x1);
//		System.out.println(z);
		//System.out.println(sonic1);
		//break;
		//把修改后的SB转换成字符串并赋给sonic;防止SB修改后长度改变,影响原字符串
		sonic = sonic1.toString();
		//System.out.println(sonic);
	}
	
}
sonic = sonic1.toString();
System.out.println(sonic);

	//SB的更改原SB属性导致长度变化,第二次运行错误
//}while(1==1);	

	
	
}
}
