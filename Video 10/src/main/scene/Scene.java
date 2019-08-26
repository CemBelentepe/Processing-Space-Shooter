package main.scene;

import processing.core.PApplet;

public class Scene {
	PApplet parent;
	
	public Scene(PApplet parent) {
		this.parent = parent;
	}

	public void updateFrame() {
		update();
		render();
	}
	
	public void init() {}
	protected void update() {}
	protected void render() {}
}
