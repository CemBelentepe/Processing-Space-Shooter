package main.gameObject;

import main.SpaceShooter;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Laser {
	PApplet parent;
	PImage img;
	PVector pos;
	float speed;

	float damage;
	String tag;

	public Laser(PApplet parent, PImage img, float x, float y, float speed) {
		this.parent = parent;
		this.img = img;
		pos = new PVector(x, y);
		this.speed = speed;
	}

	public void render() {
		parent.image(img, pos.x, pos.y);
	}

	public void update() {
		pos.y += speed * SpaceShooter.deltaTime;
	}
}