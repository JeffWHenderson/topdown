package com.jeffwhenderson.topDown;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void tick() {
		for(GameObject object: objects)  	
			object.tick();
	}
	
	public void render(Graphics g) {
		for(GameObject object: objects)  	
			object.render(g);
	}
	
	public void addObject(GameObject updateableGameObject) {
		objects.add(updateableGameObject);
	}
	
	public void removeObject(GameObject updateableGameObject) {
		objects.remove(updateableGameObject);
	}
}

//for(int i = 0; i < objects.size(); i++) {} /// removed for forEach loop