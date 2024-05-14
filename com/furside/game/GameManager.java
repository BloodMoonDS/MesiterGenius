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
	public int Score;
	private Image image;
	int cposx = 0;
	int cposy = 0; 
	int crposx = 0;
	int crposy = 0;
	int rposz = 0;
	float posz = 0;
	float zSpeed = 4;
	private float playerX=64, playerY=64, speed=64;
	
	private Image bg;
	
	private Image picture;
	
	private TiledImage Tile;
	
	private SoundClip crashsnd;
	
	private SoundClip mus;
	
	private int plrx= 0,plry=0;
	
	private FormClass win;
	private Image testimg;
	public GameManager() 
	{
		//testimg = new Image("/sprites/img/vfx_test_dummy.png");
		cursor = new Image("/sprites/cursor.png");
		image = new Image("/sprites/Ship.png");
		bg = new Image("/sprites/bg/cd.png");
		Tile = new TiledImage("/sprites/player.png",16,16);
		crashsnd = new SoundClip("/sounds/snd_crash.wav");
		mus = new SoundClip("/music/earth.mid");
		
	}
	
	@Override
	public void update(GameLoop gc, float dt) {
		crposx = gc.getInp().getMouseX()-64;
		crposy = gc.getInp().getMouseY()-64;
		
		posz += zSpeed*dt;
		
		if(mus.isRunning()==false) {
			mus.play();
			
		}
		
		
		if(gc.getInp().isKeyDown(KeyEvent.VK_A)) 
		{
			//crashsnd.play();
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
		rposz = (int)posz;
		//win.HideCursor();
		r.clear();
		r.drawImage(bg,crposx*-1-64,crposy*-1-64);
		
		//r.drawImage(image, (int)playerX,(int)playerY);

		//r.drawTiledImage(Tile, 0, 0, 1, 0);
		if(gc.getInp().isKey(KeyEvent.VK_A)) 
		{
			//r.colorswitch();
			//System.out.println("A Pressed");
			//r.drawImage(picture, 0, 0);
			//crashsnd.play();
		}
		//r.drawImage(testimg, 0, 0);
		//r.colorswitch();
		//r.addcolor(100);
		// MOUSE RENDER
		r.drawImage(cursor, gc.getInp().getMouseX(), gc.getInp().getMouseY());
		//TEXT RENDER
				r.drawText("SCORE:"+ Score, 0, 8, 0xff0fffff);
		//DATA RENDER
		r.drawText("x:"+crposx, 0, 16, 0xffff0000);
		r.drawText("y:"+crposy*-1, 0, 16+8, 0xff00ff00);
		r.drawText("z:"+rposz, 0, 16+16, 0xff0000ff);
	}
	public static void main (String args[]) {
		GameLoop gc = new GameLoop(new GameManager());
		gc.start();
	}
	
}
