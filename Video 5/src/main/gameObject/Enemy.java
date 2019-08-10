package main.gameObject;

import main.SpaceShooter;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemy extends GameObject {
	float speed;
	float cooldownMax = 200.0f;
	float cooldownMin = 50.0f;
	float leftTime;
	
	public Enemy(PApplet parent, PImage img, float x, float y, float speed) {
		super(parent, new PVector(x, y), img);
		this.speed = speed;
		leftTime = parent.random(cooldownMin, cooldownMax);
	}

	@Override
	public void update() {
		leftTime -= SpaceShooter.deltaTime;
		if (pos.y < parent.height / 2) {
			pos.y += speed * SpaceShooter.deltaTime;
			if (pos.y > parent.height / 2)
				pos.y = parent.height / 2;
		}
		shoot();
	}
	
	public void shoot() {
		if (leftTime <= 0) {
			Laser laser = new Laser(parent, SpaceShooter.enemyLaserImage,
					pos.x + img.width / 2 - SpaceShooter.enemyLaserImage.width / 2,
					pos.y + SpaceShooter.enemyLaserImage.height * 0.75f, 2);
			SpaceShooter.lasers.add(laser);

			leftTime = parent.random(cooldownMin, cooldownMax);
		}
	}
}
