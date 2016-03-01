package sfx;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	public static final Sound test = loadSound("test");

	public static Sound loadSound(String fileName) {
		Sound sound = new Sound();
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("res/sfx/" + fileName + ".wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			sound.clip = clip;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return sound;
	}

	private Clip clip;

	public void play(boolean loop) {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.setFramePosition(0);
							if (loop) {
								clip.loop(Clip.LOOP_CONTINUOUSLY);
								;
							}
							clip.start();
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
