package cn.lut.main;

import java.awt.image.BufferedImage;

public class Bird extends Actor implements Enemy {
	private double g=9.8;
	private double v0=30;
	public Bird(){
		x=0;
		y=Math.random()*400;
		width=56;
		height=48;
	}
	public static BufferedImage [] image;
	static{
		image=new BufferedImage[8];
		for(int i=0;i<=7;i++){
			image[i]=load("res/"+i+".png");
		}
	}
	
	@Override
	public void hit() {
		super.hit();
	}
	private double s=0;
	private double t=1/3.8;
	public void move(){
		x+=10;
		s=v0*t+g*t*t;
		v0=v0-g*t;
		y-=s;
		if(x>480|y>800){
			state=REMOVE;
		}
	}
	private int index=0;
	@Override
	public BufferedImage getImage() {
		if(isLife())
			return image[index++/2%8];
		else{
			state=REMOVE;
			return null;
		}
	}
	@Override
	public int getScore() {
		return 0;
	}
	public boolean bigzhao(){
		return true;
	}

}
