package cn.lut.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BigPlane extends Actor implements Enemy {

	private static BufferedImage[] image;
	static {
		image =new BufferedImage[5];
		for(int i=0;i<image.length;i++)
			image[i] = load("res/bigplane"+i+".png");
	}

	public BigPlane() {
		
		super(69, 99);
		life=5;
	}


	private int deadIndex=1;
	public BufferedImage getImage() {
		if(isLife()){
			return image[0];
		}
		if(isDead()){
			BufferedImage img=image[deadIndex++/2];
			if(deadIndex==image.length*2){
				state=REMOVE;
			}
			return img;
		}
		
		return image[image.length-1];
	}
	public void paint(Graphics g){
		super.paint(g);
		if(state==DEAD){
			g.drawString(" "+getScore(), (int)x, (int)y);
		}
	}
	@Override
	public int getScore() {
		return 3;
	}
}
