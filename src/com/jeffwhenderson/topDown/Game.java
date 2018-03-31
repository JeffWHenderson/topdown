package com.jeffwhenderson.topDown;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	/**
	 *  Default SerailUID
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	private Camera camera;
	
	private BufferedImage level = null;
	
	public Game() {
		new Window(1000, 563, "Top Down Game", this);
		start();
		
		handler = new Handler(); // initialize the handler for the Game
		camera = new Camera(0, 0);
		this.addKeyListener(new KeyInput(handler)); // I'm Receiving addKeyListener from Canvas 
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/DragonBorn_level_1.png");
		
		//handler.addObject(new DragonBorn(100, 100, ID.Player, handler));
		loadLevel(level);
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
//				System.out.print("FPS: " + frames); // prints frame rate
				frames = 0;
			}
		}
		stop();
	}// end Run()
	
	public void tick() {
		for(int i = 0; i < handler.objects.size(); i++) {
			if(handler.objects.get(i).getId() == ID.Player) {
				camera.tick(handler.objects.get(i));
//				System.out.print(object.getId());
			}
		}
		
		handler.tick(); // here I call the handler, which has a linked list of all game Objects and updates them
	}
	
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < w; xx++) {
			for(int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				//////////////////////////// heere is the problem jeffrey 
				if(red == 255) {
					handler.addObject(new Block(xx* 32, yy*32, ID.Block));
//					System.out.print("b");
				}
				
				if(blue == 255 && red != 255) {
					handler.addObject(new DragonBorn(xx*32, yy*32, ID.Player, handler));
//					System.out.println("");
					System.out.println("a dragon was born");
				}
			}
		}
		
	}
	
	public void render() { // renders everything in the game
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g  = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		////////////////ANYTHING UNDER THIS WILL RENDER/////////////////////////
				g.setColor(Color.red);
				g.fillRect(0, 0, 1000, 563);
				
				g2d.translate(-camera.getX(), -camera.getY());
				handler.render(g); // here I call the handler, which has a linked list of all game Objects and renders them (3 frames in advance)
		////////////////ANYTHING  OVER THIS WILL RENDER////////////////////////
		
		g.dispose();
		bs.show();
	}
}
