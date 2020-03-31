package sonic.o.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		//静态方法,直接使用
		try {
			//通过域名获取ip地址
			InetAddress a = InetAddress.getByName("baidu.com");
			System.out.println(a);	
			System.out.println(InetAddress.getByName("sonicming.win"));
			//获取该IP地址主机ip地址-完全没用啊
			System.out.println(InetAddress.getByName("104.224.133.158"));
			//获取该主机名(如果存在)IP地址-WRGHO-703161359为左边电脑
			System.out.println(InetAddress.getByName("WRGHO-703161359"));
			
			/*获取本地地址,返回主机名和地址*/
			InetAddress b = InetAddress.getLocalHost();
			System.out.println(b);
			
			/*返回IP数组*/
			InetAddress[] by = new InetAddress[255];
			by = InetAddress.getAllByName("104.244.133.0");
			for (InetAddress i : by) {
				System.out.println(i);
			}
			
			/*测试InetAddress其他方法*/
			InetAddress x = InetAddress.getByName("sonicming.win");
			//返回主机原始IP地址,返回byte[]
			byte[] b1 = x.getAddress();
			System.out.println(b1);
			//获取主机IP地址
			System.out.println("x的主机地址:"+x.getHostAddress());
			//获取主机名称
			System.out.println("x的主机名:"+x.getHostName());
			//判断IP地址是否相等
			System.out.println("x与a是否Ip相同:"+x.equals(a));
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
