package win.sonic.o.socket.tt;

import java.net.Socket;
import java.io.*;

public class Read extends Thread {
	Socket s;

	public Read(Socket s) {
		super();
		this.s = s;
	}

	public void run() {
		while (true) {			 
			try {
				//Socket接收到的流经过处理流包装，在转向处理流
				BufferedReader br = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				System.out.println(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
