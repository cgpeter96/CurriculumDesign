package cn.lut.main;

import java.awt.image.BufferedImage;

public class Bee extends Actor implements Award{
	private static BufferedImage[]image;
	private double dir=2;
	private int award;
	static{
		image = new BufferedImage[5];
		for(int i=0;i<5;i++)
			image[i]=load("res/bee"+i+".png");
		
	}
	public Bee() {
		super(60, 50);
		//随机抽[0,1)  
//		double[]ary={0,1,2};
//		dir=ary[(int)Math.random()*ary.length];
		//随机抽取奖品
		
//		System.out.println("bee的award:"+award);
	}
	
	public void move(){
		super.move();
		x+=dir;
		if(x>=480-width||x<0)
			dir*=-1;
		
	}
	private int deadIndex=1;
	public BufferedImage getImage() {
		if(isLife()){
			return image[0];
		}
		if(isDead()){
			BufferedImage img=image[deadIndex++];
			if(deadIndex>=image.length){
				deadIndex=0;
				state=REMOVE;
			}
			return img;
		}
		
		return image[image.length-1];
	}

	@Override
	public int getAward() {
		int type[]={Award.DOUBLE_FIRE,Award.FIRE,Award.LIFE,Award.SPACE};
		award=type[(int)Math.random()*type.length];
		return award;
	}

}
