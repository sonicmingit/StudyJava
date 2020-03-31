package sonic.o.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端,UDP
 * 
 * @author 郝一鸣
 *
 */
public class Receive {
	public static void main(String[] args) throws IOException {
		
			// 创建一个DatagramSocket,并指定一个接收端口
			DatagramSocket ds = new DatagramSocket(1231);
			// 创建一个DatagramPaket
			byte[] b = new byte[100];
			DatagramPacket dp = new DatagramPacket(b, b.length);
			while (true) {	// 开始接收
			System.out.println("开始接收...");
			ds.receive(dp);
			System.out.println(new String(dp.getData(),0,dp.getLength()));
			
		}
	}
}
