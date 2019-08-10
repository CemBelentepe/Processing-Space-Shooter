package main.gameObject;

import main.SpaceShooter;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends GameObject{
	float speed;
	float cooldown = 100;
	float leftTime;

	public Player(PApplet parent, PImage img, float x, float y, float speed) {
		super(parent, new PVector(x, y), img);
		this.speed = speed;
		leftTime = 0;
	}

	@Override
	public void update() {
		if (leftTime > 0)
			leftTime -= SpaceShooter.deltaTime;

		if (SpaceShooter.keys[0])
			pos.y -= speed * SpaceShooter.deltaTime;
		if (SpaceShooter.keys[2])
			pos.y += speed * SpaceShooter.deltaTime;
		if (SpaceShooter.keys[1])
			pos.x -= speed * SpaceShooter.deltaTime;
		if (SpaceShooter.keys[3])
			pos.x += speed * SpaceShooter.deltaTime;

		if (pos.x < 0)
			pos.x = 0;
		else if (pos.x + img.width > parent.width)
			pos.x = parent.width - img.width;

		if (pos.y < 0)
			pos.y = 0;
		else if (pos.y + img.height > parent.height)
			pos.y = parent.height - img.height;

		if (SpaceShooter.keys[4])
			shoot();
	}

	void shoot() {
		if (leftTime <= 0) {
			Laser laser = new Laser(parent, SpaceShooter.playerLaserImage,
					pos.x + img.width / 2 - SpaceShooter.playerLaserImage.width / 2,
					pos.y - SpaceShooter.playerLaserImage.height * 0.75f, -2);
			SpaceShooter.lasers.add(laser);
			leftTime = cooldown;
		}
	}
}