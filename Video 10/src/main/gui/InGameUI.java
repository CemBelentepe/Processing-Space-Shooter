package main.gui;

import main.scene.GameScene;
import processing.core.PApplet;
import processing.core.PConstants;

public class InGameUI extends UI{
	
	public InGameUI(PApplet parent) {
		super(parent);
	}

	@Override
	public void render() {
		parent.push();
		
		parent.fill(255);
		parent.textSize(32);
		parent.textAlign(PConstants.LEFT, PConstants.TOP);
		parent.text("Health: " + GameScene.player.health, 0, 0);
		parent.text("Level: " + GameScene.player.level, 0, 32);
		
		parent.pop();
	}
}
