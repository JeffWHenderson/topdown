package com.jeffwhenderson.topDown;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	Handler handler;
	
	public KeyInput(Handler handler) { // not newing up a handler. Its taking in an existing handler from the player
		this.handler = handler;
	}
	public void KeyPressed (KeyEvent e) {
		int key = e.getKeyCode();
		
		for(GameObject object: handler.objects) {
			if(object.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) handler.setUp(true);
				if (key == KeyEvent.VK_A) handler.setLeft(true);
				if (key == KeyEvent.VK_S) handler.setDown(true);
				if (key == KeyEvent.VK_D) handler.setRight(true);
			}
		}
	}
	
	public void KeyReleased (KeyEvent e) {
		int key = e.getKeyCode();
		
		for(GameObject object: handler.objects) {
			if(object.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) handler.setUp(false);
				if (key == KeyEvent.VK_A) handler.setLeft(false);
				if (key == KeyEvent.VK_S) handler.setDown(false);
				if (key == KeyEvent.VK_D) handler.setRight(false);
			}
		}
	}
}
