
package win.sonic.i.inter.inter;

/**
 * 所有设备的父类
 * 
 * @author 郝一鸣
 *
 */
public class Device {
	// 设备的名称
	String name;
	// 设备的容量;
	int flash;
	//创建接口
	IPlayMusic music;
	IPlayVideo video;
	IRW rw;
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return flash
	 */
	public int getFlash() {
		return flash;
	}
	/**
	 * @param music 要设置的 music
	 */
	public void setMusic(IPlayMusic music) {
		this.music = music;
	}
	/**
	 * @param video 要设置的 video
	 */
	public void setVideo(IPlayVideo video) {
		this.video = video;
	}
	/**
	 * @param rw 要设置的 rw
	 */
	public void setRw(IRW rw) {
		this.rw = rw;
	}
	/*实现接口方法*/
	/**
	 * 读取数据
	 */
	public void readDate(){
		rw.read();
	}
	/**
	 * 写入数据
	 */
	public void writeDate(){
		rw.write();
	}
	/**
	 * 播放音乐
	 */
	public void palyMusic(){
		music.playMusic();
	}
	/**
	 * 停止音乐
	 */
	public void stopMusic(){
		music.stopMusic();
	}
	/**
	 * 播放视频
	 */
	public void palyVideo(){
		video.playVideo();
	}
	/**
	 * 停止视频
	 */
	public void stopVideo(){
		video.stopVideo();
	}	
}
