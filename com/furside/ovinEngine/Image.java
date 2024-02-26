package com.furside.ovinEngine;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	private int W,h;
	private int[] p;
	public Image(String Path) {
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(Image.class.getResourceAsStream(Path));
		} catch (IOException e) {
			
			System.out.println("Error While getting your Image");
			e.printStackTrace();
		}
		
		W = image.getWidth();
		h = image.getHeight();
		p = image.getRGB(0, 0, W, h, null, 0, W);
		
		image.flush();
	}
	public int getW() {
		return W;
	}
	public void setW(int w) {
		W = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int[] getP() {
		return p;
	}
	public void setP(int[] p) {
		this.p = p;
	}
	
	
}
