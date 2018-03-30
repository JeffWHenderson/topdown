package com.jeffwhenderson.topDown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject {

	public Block(int x, int y, ID id) {
		super(x, y, id);
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
