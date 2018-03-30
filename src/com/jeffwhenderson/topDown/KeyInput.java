package com.jeffwhenderson.topDown;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	Handler handler;
	
	public KeyInput(Handler handler) { // not newing up a handler. Its taking in an existing handler from the player
		this.handler = handler;
	}
	
	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();
	
		
	for(GameObject object: handler.objects) {
			if(object.getId() == ID.Player) {
				if (key == KeyEvent.VK_UP) handler.setUp(true);
				if (key == KeyEvent.VK_LEFT) handler.setLeft(true);
				if (key == KeyEvent.VK_DOWN) handler.setDown(true);
				if (key == KeyEvent.VK_RIGHT) handler.setRight(true);
			}
		}
	}
	
	public void keyReleased (KeyEvent e) {
		int key = e.getKeyCode();
		
		for(GameObject object: handler.objects) {
			if(object.getId() == ID.Player) {
				if (key == KeyEvent.VK_UP) handler.setUp(false);
				if (key == KeyEvent.VK_LEFT) handler.setLeft(false);
				if (key == KeyEvent.VK_DOWN) handler.setDown(false);
				if (key == KeyEvent.VK_RIGHT) handler.setRight(false);
			}
		}
	}
}
