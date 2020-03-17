package win.sonic.i.inter.inter;

public class Test {

	public static void main(String[] args) {
		Usb sandisk = new Usb();
		Mp3 mp3 = new Mp3();
		Mp4 mp4 = new Mp4();
		Device com = new Device();
		com.setVideo(mp4);
		com.setMusic(mp3);
		com.palyVideo();
		com.palyMusic();
		com.setRw(sandisk);
		com.readDate();
	}

}
