package com.lut.bird;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Actor {
	protected int x, y, width, height;

	public abstract BufferedImage getImage();

	public void paint(Graphics g) {
		g.drawImage(getImage(), x, y, null);
	}

	protected static BufferedImage load(String file) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(Actor.class.getClassLoader().getResourceAsStream(file));
//			image = ImageIO.read(new FileInputStream(new  File(file)));这种方式行不通
			return image;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
