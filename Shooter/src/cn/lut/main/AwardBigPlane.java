package cn.lut.main;

import java.awt.Color;
import java.awt.Graphics;

public class AwardBigPlane extends BigPlane implements Award {

	@Override
	public int getAward() {
		return DOUBLE_FIRE;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.yellow);
		g.drawRect((int)x, (int)y, (int)20, (int)20);
	}
}
