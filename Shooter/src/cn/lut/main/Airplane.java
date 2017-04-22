package cn.lut.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Airplane extends Actor implements Enemy{

	public Airplane() {
		super(48, 36);
	}

	static BufferedImage[]image;
	static {
		image=new BufferedImage[5];
		for(int i=0 ;i<5 ;i++)
		image[i] = load("res/airplane"+i+".png");
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
			Font font=new Font(Font.SANS_SERIF,Font.BOLD,15);
			g.setFont(font);
			g.setColor(Color.green);
			g.drawString(" "+getScore(), (int)x, (int)y);
		
		}
	}
	@Override
	public int getScore() {
		
		return 1;
	}
	
}
