package com.jeffwhenderson.topDown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	private Handler handler;
	private Camera camera;
	
	public MouseInput(Handler handler, Camera camera) {
		this.handler = handler;
		this.camera = camera;
	}
	
	public void mousePressed(MouseEvent e) {
		int mouseX = (int) (e.getX() + camera.getX());
		int mouseY = (int) (e.getY() + camera.getY());
		
		for(int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			
			if(tempObject.getId() == ID.Player) {
				handler.addObject(new Projectile(tempObject.getX() + 16, tempObject.getY() + 24, ID.Bullet, handler, mouseX, mouseY));
			}
		}
	}
}
