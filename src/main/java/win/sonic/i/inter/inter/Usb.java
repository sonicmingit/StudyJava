﻿package win.sonic.i.inter.inter;

public class Usb extends Device implements IRW {

	@Override
	public void read() {
		System.out.println("USB开始读取数据...");
	}

	@Override
	public void write() {
		System.out.println("USB开始写入数据...");
	}
	public Usb(){
		
	}

}
