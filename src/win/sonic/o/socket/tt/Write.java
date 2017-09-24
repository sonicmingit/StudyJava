package win.sonic.o.socket.tt;

import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Write extends Thread {
	Socket s;
	String name;

	public Write(Socket s,String name) {
		super();
		this.s = s;
		this.name = name;
	}

	public void run() {
		while (true) {
			try {
				//PrintWriter,接收Socket的输出流
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				//键盘输入
				Scanner s = new Scanner(System.in);
				//输出键盘输入的内容
				pw.println(this.name+s.nextLine());
				//刷
				pw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
