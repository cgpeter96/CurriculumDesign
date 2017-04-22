package cn.lut.main;

import java.awt.image.BufferedImage;

public class Space extends Actor {
	private static BufferedImage image;
	static {
		image = load("res/zidan.png");
	}

	public Space(double x, double y) {
		
		this.x = x;
		this.y = y;
		width = 7;
		height = 36.5;
	}

	public boolean outOfBounds() {
		return y < -height;
	}

	public void move() {
		y -= 4;
	}

	public void move(Hero h) {
		y = h.y;
		x = h.x;
	}

	@Override
	public BufferedImage getImage() {
		if (isLife())
			return image;
		if (isDead()) {
			state = REMOVE;
		}
		return null;
	}



}
