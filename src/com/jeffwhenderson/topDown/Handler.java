package com.jeffwhenderson.topDown;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	private boolean up = false, down = false, right = false, left = false;

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
	
	//////////////// getsNsets ////////////////////
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
}

//for(int i = 0; i < objects.size(); i++) {} /// removed for forEach loop