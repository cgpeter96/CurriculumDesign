package cn.lut.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class AttackPlane extends Actor implements Enemy {
	
	public static AttackPlane plane=null;
	private static BufferedImage image[];
	static{
		image = new BufferedImage[4];
		for(int i=0;i<4;i++)
			image[i]=load("res/fi"+i+".png");
	}
	private  AttackPlane(){
		life=25;
		x=-150;
		y=100;
		width=800;
		height=Math.random()*148+50;
		state=LIFE;
	}
	public static void init(){
		if(plane==null){
			plane=new AttackPlane();
		}
		
	}
	private int deadIndex=1;
	@Override
	public BufferedImage getImage() {
		
		if(isLife()){
			return image[0];
		}
		if(isDead()){
			
			 BufferedImage img=image[deadIndex++];
			 if(deadIndex==image.length){
				 state=REMOVE;
			 }
			 return img;
			
		}
		return null;
	}
	@Override
	public int getScore() {
		return 20;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(state==DEAD){
			Font font=new Font(Font.SANS_SERIF,Font.BOLD,15);
			g.setFont(font);
			g.setColor(Color.green);
			g.drawString(" "+getScore(), (int)x, (int)y);
		
		}
	}
	
}
