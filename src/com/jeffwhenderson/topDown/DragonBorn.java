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
		if(x <= 200) 
			x += 1;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 10, 10);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
