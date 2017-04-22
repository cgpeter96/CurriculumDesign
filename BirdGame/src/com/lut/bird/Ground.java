package com.lut.bird;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground extends Actor {
	static BufferedImage image;
	// 利用静态代码块,初始化静态资源
	static {
		// 利用java提供的API将图片读取到内存对象中
		image = load("res/ground.png");
	}

	public Ground() {
		x = 0;
		y = 500;
		width = 800;
		height = 146;
	}

	public BufferedImage getImage() {
		return image;
	}
	public void move(){
		x--;
		if(x==-36){
			x=0;
		}
	}
}
