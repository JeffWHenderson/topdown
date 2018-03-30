package com.jeffwhenderson.topDown;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	
	public Game() {
		new Window(1000, 563, "Top Down Game", this);
		start();
		
		handler = new Handler(); // initialize the handler for the Game
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks; //
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >=1) {
				tick();
				delta--;
			}
			if(isRunning)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.print("FPS: " + frames); // prints frame rate
				frames = 0;
			}
		}
		stop();
	}// end Run()
	
	public void tick() { // updates everything in the game
		handler.tick();
	}
	
	public void render() { // renders everything in the game
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g  = bs.getDrawGraphics();
		
		////////////////ANYTHING UNDER THIS WILL RENDER/////////////////////////
				g.setColor(Color.red);
				g.fillRect(0, 0, 1000, 563);
				
				handler.render(g);
		////////////////ANYTHING  OVER THIS WILL RENDER////////////////////////
		
		g.dispose();
		bs.show();
	}
}
