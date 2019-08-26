package main.scene;

import java.util.ArrayList;

import main.SpaceShooter;
import main.animation.Animation;
import main.gameObject.Enemy;
import main.gameObject.Laser;
import main.gameObject.Player;
import main.gui.InGameUI;
import main.utils.EnemySpawner;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class GameScene extends Scene {
	public static final String tag_player = "player";
	public static final String tag_enemy = "enemy";

	public static PImage bg, playerImage, enemyImage, playerLaserImage, enemyLaserImage;
	public static PImage explosionSheet;

	public static Player player;
	public static ArrayList<Laser> lasers;
	public static ArrayList<Enemy> enemies;
	public static EnemySpawner spawner;
	public static InGameUI inGameUI;

	public static Animation explosion;
	public static ArrayList<Animation> animations;

	public GameScene(PApplet parent) {
		super(parent);
	}

	@Override
	public void init() {
		bg = parent.loadImage("res/bg.png");
		playerImage = parent.loadImage("res/playerShip.png");
		playerLaserImage = parent.loadImage("res/laser1.png");
		enemyImage = parent.loadImage("res/enemy1.png");
		enemyLaserImage = parent.loadImage("res/laserE1.png");

		explosionSheet = parent.loadImage("res/explosion.png");

		player = new Player(parent, tag_player, playerImage, parent.width / 2 - playerImage.width / 2,
				parent.height - playerImage.height, 1.5f);
		lasers = new ArrayList<Laser>();
		enemies = new ArrayList<Enemy>();
		spawner = new EnemySpawner(parent, 3000, 1000, 15);

		explosion = new Animation(parent, new PVector(0, 0), explosionSheet, 8, 1, 8);

		animations = new ArrayList<Animation>();

		inGameUI = new InGameUI(parent);
	}

	@Override
	protected void update() {
		player.update();
		for (int i = enemies.size() - 1; i >= 0; i--) {
			if (enemies.get(i).health <= 0) {
				Animation exp = explosion.copy();
				animations.add(exp);
				exp.setPos(enemies.get(i).pos.add(new PVector(enemyImage.width/2, enemyImage.height/2)));
				exp.startAnimation(4);
				enemies.remove(i);
			} else {
				enemies.get(i).update();
			}
		}
		for (int i = lasers.size() - 1; i >= 0; i--) {
			if (lasers.get(i).health <= 0) {
				lasers.remove(i);
			} else {
				lasers.get(i).update();
			}
		}
		spawner.update();
	}

	@Override
	protected void render() {
		SpaceShooter.wrap(parent, bg, 0, 0, parent.width, parent.height);

		for (Laser l : lasers)
			l.render();
		for (Enemy e : enemies)
			e.render();
		player.render();

		for(Animation e:animations) {
			e.render();
		}
		
		inGameUI.render();
	}
}
