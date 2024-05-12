package com.furside.game;

import java.awt.event.KeyEvent;

import com.furside.ovinEngine.Abstract;
import com.furside.ovinEngine.FormClass;
import com.furside.ovinEngine.GameLoop;
import com.furside.ovinEngine.Image;
import com.furside.ovinEngine.SoundClip;
import com.furside.ovinEngine.TiledImage;

import bx.generic.render.GenericRender;

public class GameManager extends Abstract {
	
	private Image cursor;
	
	private Image image;
	
	private float playerX=64, playerY=64, speed=64;
	
	private Image bg;
	
	private Image picture;
	
	private TiledImage Tile;
	
	private SoundClip crashsnd;
	
	private SoundClip mus;
	
	private FormClass win;
	
	public GameManager() 
	{
		cursor = new Image("/sprites/cursor.png");
		image = new Image("/sprites/Ship.png");
		bg = new Image("/sprites/bg/Sky.png");
		Tile = new TiledImage("/sprites/player.png",16,16);
		crashsnd = new SoundClip("/sounds/snd_crash.wav");
		mus = new SoundClip("/music/earth.mid");
		mus.play();
	}
	
	@Override
	public void update(GameLoop gc, float dt) {
		
		if(gc.getInp().isKeyDown(KeyEvent.VK_A)) 
		{
			crashsnd.play();
			//System.out.println("A Pressed");
			
		}
		if(gc.getInp().isKey(KeyEvent.VK_RIGHT)) 
		{
			playerX = playerX + speed * dt;
		}
		if(gc.getInp().isKey(KeyEvent.VK_LEFT)) 
		{
			playerX = playerX - speed * dt;
		}
		if(gc.getInp().isKey(KeyEvent.VK_UP)) 
		{
			playerY = playerY - speed * dt;
		}
		if(gc.getInp().isKey(KeyEvent.VK_DOWN)) 
		{
			playerY = playerY + speed * dt;
		}
	}

	@Override
	public void render(GameLoop gc, GenericRender r) {
		win = gc.getWindow();
		//win.HideCursor();
		r.clear();
		r.drawImage(bg,0,0);
		r.drawImage(image, (int)playerX,(int)playerY);

		//r.drawTiledImage(Tile, 0, 0, 1, 0);
		if(gc.getInp().isKey(KeyEvent.VK_A)) 
		{
			//r.colorswitch();
			//System.out.println("A Pressed");
			//r.drawImage(picture, 0, 0);
			//crashsnd.play();
		}
		//r.colorswitch();
		
		// MOUSE RENDER
		r.drawImage(cursor, gc.getInp().getMouseX(), gc.getInp().getMouseY());
		
		
	}
	public static void main (String args[]) {
		GameLoop gc = new GameLoop(new GameManager());
		gc.start();
	}
	
}
