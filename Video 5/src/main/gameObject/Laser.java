package main.gameObject;

import main.SpaceShooter;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Laser extends GameObject{
	float speed;
	float damage;
	String tag;

	public Laser(PApplet parent, PImage img, float x, float y, float speed) {
		super(parent, new PVector(x, y), img);
		this.speed = speed;
	}

	public void update() {
		pos.y += speed * SpaceShooter.deltaTime;
	}
}