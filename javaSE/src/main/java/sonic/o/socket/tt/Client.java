package sonic.o.socket.tt;

import java.io.IOException;
import java.net.*;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("向服务端发送请求1....");
			//创建了一个客户端，去绑定了服务端的ip和端口
			Socket client = new Socket("175.3.21.19", 5555);
			
			new Thread(new Read(client)).start();
			new Thread(new Write(client,"客户1:")).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
