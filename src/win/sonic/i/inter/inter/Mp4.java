package win.sonic.i.inter.inter;
public class Mp4 extends Device implements IPlayMusic, IPlayVideo, IRW {

	@Override
	public void read() {
		System.out.println("Mp4开始读取数据...");
	}

	@Override
	public void write() {
		System.out.println("Mp4开始写入数据...");
	}

	@Override
	public void playVideo() {
		System.out.println("Mp4开始播放视频");
	}

	@Override
	public void stopVideo() {
		System.out.println("Mp4停止播放视频");
	}

	@Override
	public void playMusic() {
		System.out.println("Mp4开始播放音乐");
	}

	@Override
	public void stopMusic() {
		System.out.println("Mp4停止播放那个音乐");
	}

}
