package cn.lut.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Thunder  {
	
	public void paint(Graphics g){
		Font font=new Font(Font.SANS_SERIF,Font.BOLD,80);
		g.setFont(font);
		g.setColor(new Color(1,190,223));
		for(int i=0;i<50;i++){
			g.drawString("À×µç", 200, 300);
		}                                     
	}

}
