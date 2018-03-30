package com.jeffwhenderson.topDown;

import java.awt.Graphics;
import java.awt.Rectangle;

public class DragonBorn extends GameObject {

	public DragonBorn(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		x += velX; // velX and velY are inherited from the GameObject
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
