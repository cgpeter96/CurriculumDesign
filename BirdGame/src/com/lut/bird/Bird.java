package com.lut.bird;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class Bird extends Actor {
	static BufferedImage[] image ;
	private final static double g=9.8;
	private double t=1/3.8;
	private double V0=30;
	//每一次的初始速度v0
	private double v0;
	//每次的位移大小
	private double s;
	private double alpha;
	static {
		image=new BufferedImage[8];
		for(int i=0;i<8;i++){
			image[i]=load("res/"+i+".png");
		}
	}
	
	public Bird() {
		// 初始化鸟的数据
		x = 50;
		y = 300;
		width = 56;
		height = 48;
		v0=V0;
	}
	private int i=0;
	public BufferedImage getImage() {
		
		return image[i++/2%image.length];
	}
	public void move(){
		s=v0*t+g*t*t/2;
		y-=s;
		v0=v0-g*t;
		alpha=Math.atan(s/12);
	}
	public boolean duang(Column col){
		double x1=col.x-(width-16);
		double x2=col.x+(col.width);
		
		double y1=col.y+col.height/2.0-col.getGap()/2.0;
		double y2=col.y+col.height/2.0+col.getGap()/2.0-(height-16);
		
//		if(y+(height-16)<498){
			if ((x1 < (x + 8)) && ((x + 8) < x2)) {
				return (y1 < (y + 8)) && ((y + 8) < y2) ? false : true;
			} else {
				return false;
			}
//		} else {
//			return true;
//		}
		//return (y+(height-16)<498)?((x1<(x+8))&&((x+8)<x2)?((y1<(y+8))&&((y+8)<y2)?false:true):false):true;
	}
	public boolean duang(Ground grd){
		if(y+(height-16)<grd.y)
			return false;
		else
			return true;
	}
	//利用重写父类actor提供的绘制方法
	public void paint(Graphics g){
		//旋转坐标系,绘制鸟
		Graphics2D g2=(Graphics2D) g;
		g2.rotate(-alpha,x+width/2.0,y+height/2.0);
		g.drawImage(getImage(), x, y, null);
		g2.rotate(alpha,x+width/2.0,y+height/2.0);
		g.drawRect(x+8, y+8, width-16, height-16);
	}
	public void fly() {
		v0=V0;
	}

	public boolean pass(Column[] columns){
		if(x+8==columns[0].x+columns[0].width)
			return true;
		if(x+8==columns[1].x+columns[1].width)
			return true;
		return false;
	}
}
