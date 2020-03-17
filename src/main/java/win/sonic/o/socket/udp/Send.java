package win.sonic.o.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Send {
	public static void main(String[] args) throws IOException {
		
		int []x[] = {{1,2,3},{1,2,3}};
		for (int i = 0; i < 10; i++) {
		// 创建一个DatagramSocket用来发送
		DatagramSocket ds = new DatagramSocket();
		byte[] b = new byte[100];
		String send = "这是我发送的内容!!!"+i;
		b = send.getBytes();
		// 创建一个DatagramPacket发送
		DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName("127.0.0.1"), 1231);
		System.out.println("开始发送第"+i+"次");
		ds.send(dp);
		}
	}
}
