package main.gameObject;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class GameObject {
	PApplet parent;
	PVector pos;
	PImage img;
	
	public GameObject(PApplet parent, PVector pos, PImage img) {
		this.parent = parent;
		this.pos = pos;
		this.img = img;
	}
	public void render() {
		parent.image(img, pos.x, pos.y);
	}

	public void update() {}
}
