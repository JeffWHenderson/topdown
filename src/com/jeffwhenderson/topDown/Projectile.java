package com.jeffwhenderson.topDown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject {
	private Handler handler;
	
	public Projectile(int x, int y, ID id, Handler handler, int mouseX, int mouseY) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (mouseX - x) / 10;
		velY = (mouseY - y) / 10;
				
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		for(GameObject object : handler.objects) {
			if(object.getId() == ID.Block) {
				if(getBounds().intersects(object.getBounds())) {
					handler.removeObject(this);
					break;
					//System.out.print("this is workig");
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
