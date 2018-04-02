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
		
		collision();
		
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
	}
	
	public void collision() {
		for(GameObject object: handler.objects) {
			if(object.getId() == ID.Block) {
				if(getBounds().intersects(object.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 10, 10);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 32);
	}

}
