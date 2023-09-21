package com.furside.ovinEngine;
import java.io.IOException;

import bx.generic.render.GenericRender;

public class GameLoop implements Runnable {
  private GenericRender Bx_generic;
  
  private Thread thread;
  
  private FormClass window;
  
  public boolean running = false;
  
  public final double UPDATE_CAP = 0.016666666666666666D;
  
  public int width = 160;
  
  public int height = 144;
  
  public float scale = 3.0F;
  
  public String title = "RealDreed Engine V0.0.0.1-experimental";
  
  public String iconDir= "assets/icon/icon.jpg"; // default Icon for program
  
  public void start() {
    this.window = new FormClass(this);
    this.thread = new Thread(this);
    this.Bx_generic = new GenericRender(this);
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
      while (unprocessedTime >= 0.016666666666666666D) {
        unprocessedTime -= 0.016666666666666666D;
        render = true;
        if (frameTime >= 1.0D) {
          frameTime = 0.0D;
          fps = frames;
          frames = 0;
          System.out.println("FPS :" + fps);
        } 
      } 
      if (render) {
        this.Bx_generic.clear();
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
  
  public static void main(String[] args) {
    GameLoop gc = new GameLoop();
    gc.start();
  }
  
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

