package main;

import java.util.ArrayList;

import main.gameObject.Enemy;
import main.gameObject.Laser;
import main.gameObject.Player;
import processing.core.PApplet;
import processing.core.PImage;

public class SpaceShooter extends PApplet {
	public static void main(String[] args) {
		PApplet.main("main.SpaceShooter");
	}

	public void settings() {
		size(1366, 768);
	}

	public static PImage bg, playerImage, enemyImage, playerLaserImage, enemyLaserImage;
	public static float deltaTime;

	public static Player player;
	public static ArrayList<Laser> lasers;
	public static Enemy enemy;

	public void setup() {
		size(1366, 768);

		bg = loadImage("res/bg.png");
		playerImage = loadImage("res/playerShip.png");
		playerLaserImage = loadImage("res/laser1.png");
		enemyImage = loadImage("res/enemy1.png");
		enemyLaserImage = loadImage("res/laserE1.png");

		player = new Player(this, playerImage, width / 2 - playerImage.width / 2, height - playerImage.height, 1.5f);
		lasers = new ArrayList<Laser>();
		enemy = new Enemy(this, enemyImage, width/2-enemyImage.width/2, enemyImage.height, 2f);
		
		t1 = millis();
	}

	float t1, t2;

	public void draw() {
		background(0);
		t2 = millis();
		deltaTime = (t2 - t1);
		
		// Game Scene
		wrap(bg, 0, 0, width, height);

		for (Laser l : lasers)
			l.render();
		player.render();
		enemy.render();

		for (Laser l : lasers)
			l.update();
		player.update();
		enemy.update();
		
		t1 = millis();
	}

	void wrap(PImage img, float x1, float y1, float x2, float y2) {
		for (float x = x1; x < x2; x += img.width) {
			for (float y = y1; y < y2; y += img.height) {
				image(img, x, y);
			}
		}
	}

	public static boolean[] keys = new boolean[5]; // W/UP, A/LEFT, S/DOWN, D/RIGHT, SPACE

	public void keyPressed() {
		if (key == 'w' || key == 'W' || keyCode == UP)
			keys[0] = true;
		if (key == 'a' || key == 'A' || keyCode == LEFT)
			keys[1] = true;
		if (key == 's' || key == 'S' || keyCode == DOWN)
			keys[2] = true;
		if (key == 'd' || key == 'D' || keyCode == RIGHT)
			keys[3] = true;
		if (key == ' ')
			keys[4] = true;
	}

	public void keyReleased() {
		if (key == 'w' || key == 'W' || keyCode == UP)
			keys[0] = false;
		if (key == 'a' || key == 'A' || keyCode == LEFT)
			keys[1] = false;
		if (key == 's' || key == 'S' || keyCode == DOWN)
			keys[2] = false;
		if (key == 'd' || key == 'D' || keyCode == RIGHT)
			keys[3] = false;
		if (key == ' ')
			keys[4] = false;
	}
}
