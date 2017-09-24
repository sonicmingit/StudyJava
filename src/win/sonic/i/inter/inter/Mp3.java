package win.sonic.i.inter.inter;

public class Mp3 extends Device implements IRW, IPlayMusic {

	@Override
	public void playMusic() {
		System.out.println("Mp3开始播放音乐");

	}

	@Override
	public void stopMusic() {
		System.out.println("Mp3停止播放音乐");

	}

	@Override
	public void read() {
		System.out.println("Mp3开始读取数据...");
	}

	@Override
	public void write() {
		System.out.println("Mp3开始写入数据...");
	}

}
