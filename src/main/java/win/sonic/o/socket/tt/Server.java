package win.sonic.o.socket.tt;

import java.io.IOException;
import java.net.*;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("服务端启动....");
			// 创建了一个server，打开了一个端口
			ServerSocket server = new ServerSocket(1231);
			// 等待接收客户端发送的请求
			Socket s = server.accept();
			Socket s1 = server.accept();
			
			System.out.println("接收客户端请求....");
			// Read r = new Read(s);
			// Thread th1 = new Thread(r);
			// th1.start();

			new Thread(new Read(s)).start();
			new Thread(new Write(s,"主机:")).start();
			new Thread(new Read(s1)).start();
			new Thread(new Write(s1,"主机:")).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
