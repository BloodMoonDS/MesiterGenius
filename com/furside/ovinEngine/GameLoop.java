package com.furside.ovinEngine;
import java.awt.event.KeyEvent;
import java.io.IOException;

import bx.generic.render.GenericRender;

public class GameLoop implements Runnable {
  private GenericRender Bx_generic;
  private Input inp;
  public Input getInp() {
	return inp;
}

private Thread thread;
  private Abstract game;
  private FormClass window;
  
  public boolean running = false;
  
  public final double FRAMERATE = 128;
  
  public final double UPDATE_CAP = 1.0/FRAMERATE;
  
  public int width = 128;
  
  public int height = 128;
  
  public float scale = 3F;
  
  public String title = "RealDreed Engine";
  
  public String iconDir= "assets/icon/icon.png"; // default Icon for program
  
  public GameLoop(Abstract game)
  {
	  this.game = game;
	  
  }
  
  
  public void start() {
    this.window = new FormClass(this);
    this.thread = new Thread(this);
    this.Bx_generic = new GenericRender(this);
    this.inp = new Input(this);
    this.thread.run();
  }
  
  public void stop() {}
  
  public void run() {
	try {
		this.window.SetImage(iconDir);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    this.running = true;
    boolean render = false;
    double firstTime = 0.0D;
    double lastTime = System.nanoTime() / 1.0E9D;
    double passedTime = 0.0D;
    double unprocessedTime = 0.0D;
    double frameTime = 0.0D;
    int frames = 0;
    int fps = 0;
    while (this.running) {
      render = false;
      firstTime = System.nanoTime() / 1.0E9D;
      passedTime = firstTime - lastTime;
      lastTime = firstTime;
      unprocessedTime += passedTime;
      frameTime += passedTime;
      while (unprocessedTime >= UPDATE_CAP) {
        unprocessedTime -= UPDATE_CAP;
        render = true;
       
        game.update(this, (float)UPDATE_CAP);
        inp.update();
        
        if (frameTime >= 1.0D) {
          frameTime = 0.0D;
          fps = frames;
          frames = 0;
          //System.out.println("FPS :" + fps);
          
        } 
      } 
      if (render) {
        //this.Bx_generic.clear();
        game.render(this, Bx_generic);
        this.Bx_generic.drawText("FPS: " + fps, 0, 0, 0xffffffff);
        this.window.update();
        frames++;
        continue;
      } 
      try {
        Thread.sleep(1L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
    } 
    dispose();
  }
  
  private void dispose() {}
  
  
  public int getWidth() {
    return this.width;
  }
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public void setHeight(int height) {
    this.height = height;
  }
  
  public float getScale() {
    return this.scale;
  }
  
  public void setScale(float scale) {
    this.scale = scale;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = title;
    window.SetTitle(title);
    window.UpdateForm();
  }
  
  public FormClass getWindow() {
    return this.window;
  }
}

