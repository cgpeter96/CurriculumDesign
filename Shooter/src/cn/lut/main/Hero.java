package cn.lut.main;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Hero extends Actor {
	private static BufferedImage[] image;
	private int fireTpye=Award.FIRE;
	private int zidan=0;
	public void setZidan(int zidan) {
		this.zidan = zidan;
	}

	//Ó¢ÐÛµÄÊýÁ¿
	private int heros=3;
	static {
		image = new BufferedImage[6];
		for (int i = 0; i <= 5; i++)
			image[i] = load("res/hero" + i + ".png");
	}

	public Hero() {
		width = 97;
		height = 124;
		x = (480 - width) / 2.0;
		y = 500;
		life=5;
	}

	private int index = 0;
	private int deadIndex=2;
	public BufferedImage getImage() {
		if(isLife()){
			return image[index++ / 2 % 2];
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
	public void hit(){
		life--;
		if(life==0)
			state=DEAD;
	}
	public void move(int x, int y) {
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}
	public void setFireTpye(int fireTpye) {
		this.fireTpye = fireTpye;
	}
	public int getFireTpye() {
		return fireTpye;
	}
	public Actor[] shoots(Actor[]bullets){
		int y1=(int) y-30;
		int x1=(int )(x+width/2-4);
		if(zidan==0){
			if (getFireTpye() == 1) {
				bullets = Arrays.copyOf(bullets, bullets.length + 1);
				bullets[bullets.length - 1] = new Space(x1, y1);
			}
			if (getFireTpye() == 2) {
				bullets = Arrays.copyOf(bullets, bullets.length + 3);
				bullets[bullets.length - 1] = new Bullet(x1-40, y1-40);
				bullets[bullets.length - 2] = new Bullet(x1+40, y1-40);
				bullets[bullets.length - 3] = new Bullet(x1, y1-40);
			}
			if(getFireTpye() == 3){
				
				bullets = Arrays.copyOf(bullets, bullets.length + 2);
			
				bullets[bullets.length - 1] = new Bullet(x1-20, y1-10);
				bullets[bullets.length - 2] = new Bullet(x1+20, y1-10);
				
			}
		}else{
			if (getFireTpye() == 1) {
				bullets = Arrays.copyOf(bullets, bullets.length + 1);
				bullets[bullets.length - 1] = new Bullet(x1, y1);
			}
			if (getFireTpye() == 3) {
				bullets = Arrays.copyOf(bullets, bullets.length + 3);
				bullets[bullets.length - 1] = new Bullet(x1-140, y1-40);
				bullets[bullets.length - 2] = new Bullet(x1+140, y1-40);
				bullets[bullets.length - 3] = new Bullet(x1, y1-40);
			}
			if(getFireTpye() == 2){
				
				bullets = Arrays.copyOf(bullets, bullets.length + 2);
			
				bullets[bullets.length - 1] = new Bullet(x1-100, y1);
				bullets[bullets.length - 2] = new Bullet(x1+100, y1);
				
			}
		}
		return bullets;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
	}
	
}
