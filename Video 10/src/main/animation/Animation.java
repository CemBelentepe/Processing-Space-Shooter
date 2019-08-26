package main.animation;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Animation {
	PApplet parent;
	PImage spriteSheet;
	ArrayList<PImage> frames;

	int animationStep;
	int frameRate;
	int frame;

	int w, h, count;

	PVector pos;

	public Animation(PApplet parent, PVector pos, PImage spriteSheet, int w, int h, int count) {
		this.parent = parent;
		this.pos = pos;
		this.spriteSheet = spriteSheet;
		this.w = w;
		this.h = h;
		this.count = count;
		frames = new ArrayList<PImage>();
		frame = -1;

		int width = spriteSheet.width / w;
		int height = spriteSheet.height / h;

		for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				if (j * h + w > count)
					break;
				PImage image = parent.createImage(width, height, PConstants.ARGB);
				image.copy(spriteSheet, i * width, j * height, width, height, 0, 0, width, height);
				frames.add(image);
			}
		}

	}

	public void startAnimation(int frameRate) {
		this.frameRate = frameRate;
		animationStep = 0;
		frame = 0;
	}

	public void render() {
		parent.push();
		parent.imageMode(PConstants.CENTER);
		if (frame < frames.size()) {
			parent.image(frames.get(frame), pos.x, pos.y);
			animationStep++;
			if (animationStep % frameRate == 0) {
				frame++;
			}
		}
		parent.pop();
	}

	public Animation copy() {
		return new Animation(parent, pos, spriteSheet, w, h, count);
	}
	
	public void setPos(PVector pos) {
		this.pos = pos;
	}
}
