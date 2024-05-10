package com.furside.ovinEngine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundClip {
	private Clip clip = null;
	private FloatControl gainControl;
	
	public SoundClip(String path) {
		try {
			InputStream audioSrc = SoundClip.class.getResourceAsStream(path);
			InputStream bufferedIn = new BufferedInputStream(audioSrc);
			AudioInputStream AIS = AudioSystem.getAudioInputStream(bufferedIn);
			AudioFormat baseformat = AIS.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseformat.getSampleRate(),
					9,
					baseformat.getChannels(),
					baseformat.getChannels()*2,
					baseformat.getSampleRate(),
					false
					);
			AudioInputStream DAIS = AudioSystem.getAudioInputStream(decodeFormat, AIS);
			
			clip = AudioSystem.getClip();
			clip.open(DAIS);
			gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void play() {
		if(clip==null) {
			return;	
		}
		
		stop();
		clip.setFramePosition(0);
		while(!clip.isRunning()) {
			clip.start();
		}
	}
	public void stop() {
		if(clip.isRunning())
			clip.stop();
	}
	public void close() {
		
		stop();
		clip.drain();
		clip.close();
	}
	public void loop() {
		
		clip.loop(clip.LOOP_CONTINUOUSLY);
		play();
	}
	
	public void setVolume(float vol) {
		gainControl.setValue(vol);
	}
	
	public boolean isRunning() {
		return clip.isRunning();
		
	}
	
}