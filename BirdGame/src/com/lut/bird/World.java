package com.lut.bird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {
	// 分数
	private int score;

	private Bird bird;
	private Ground ground;
	private Column[] column;
	private Sky sky;
	int i = 0;
	private Timer timer;
	private static BufferedImage readyImg;
	private static BufferedImage gameOverImg;
	static {
		readyImg = Actor.load("res/start.png");
		gameOverImg = Actor.load("res/gameover.png");
	}
	/**
	 * 游戏状态变量
	 */
	private int state;
	public final static int READY = 0;
	public final static int RUNNING = 1;
	public final static int GAME_OVER = 2;

	public World() {
		state = READY;
		sky = new Sky();
		bird = new Bird();
		column = new Column[] { new Column(0), new Column(1) };
		ground = new Ground();

	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		sky.paint(g);
		bird.paint(g);
		column[0].paint(g);
		column[1].paint(g);
		ground.paint(g2);

		switch (state) {
		case READY:
			g2.drawImage(readyImg, 0, 0, null);
			break;
		case GAME_OVER:
			g2.drawImage(gameOverImg, 0, 0, null);

			break;
		}
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		g.setFont(font);
		g.setColor(Color.yellow);
		g.drawString(score + "", 15, 50);
	}

	public void action() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ground.move();
				synchronized(this){
					if (state == RUNNING) {
						column[0].move();
						column[1].move();
						bird.move();
						sky.move();
						
						if (bird.duang(column[0]) || bird.duang(column[1]) 
								|| bird.duang(ground)) {
							Thread t = Thread.currentThread();
							System.out.println("定时器:"+t);
							state = GAME_OVER;
						}
					}
				}
				if (bird.pass(column))
					score++;
				repaint();
			}
		}, 1000 / 30, 1000 / 30);
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if (state == RUNNING)
					bird.fly();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Thread t = Thread.currentThread();
				System.out.println("鼠标事件:"+t);
				synchronized(this){
					switch (state) {
					case READY:
						score = 0;
						state = RUNNING;
						break;
					case RUNNING:
	
						break;
					case GAME_OVER:
						bird = new Bird();
						column = new Column[] { new Column(0), new Column(1) };
						state = READY;
						break;
					}
				}
			}

		};
		// 注册监听器
		this.addMouseListener(l);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		World world = new World();
		frame.setSize(432, 644);
		frame.add(world);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		world.action();
	}
}
