package com.jeffwhenderson.topDown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DragonBorn extends GameObject {
	Handler handler;

	public DragonBorn(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(handler.isUp()) velY = -2;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 2;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isLeft()) velX = -2;
		else if(!handler.isRight()) velX = 0;
		
		if(handler.isRight()) velX = 2;
		else if(!handler.isLeft()) velX = 0;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 10, 10);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}

}
