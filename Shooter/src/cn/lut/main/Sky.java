package cn.lut.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sky extends Actor {
	private double y1;
	private static BufferedImage image;
	static {
		image = load("res/background.png");
	}

	public Sky() {
		x = 0;
		y = 0;
		width = 480;
		height = 852;
		y1=-height;
		
	}
	public void move(){
		y+=0.8;
		y1+=0.8;
		if(y1>height)
			y1=-height;
		if(y>height)
			y=-height;
	}
	public void paint(Graphics g){
		g.drawImage(getImage(), (int)x, (int)y, null);
		g.drawImage(getImage(), (int)x, (int)y1, null);
	}
	@Override
	public BufferedImage getImage() {
		return image;
	}

}
