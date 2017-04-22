package cn.lut.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {

	private int state = READY;

	public static final int READY = 0;
	public static final int RUNNING = 1;
	public static final int GAMEOVER = 2;
	public static final int PAUSE = 3;

	private static BufferedImage blood;
	private static BufferedImage readyImg;
	private static BufferedImage pauseImg;
	private static BufferedImage gameOverImg;
	static {
		readyImg = Actor.load("res/start.png");
		pauseImg = Actor.load("res/pause.png");
		gameOverImg = Actor.load("res/gameover.png");
		blood = Actor.load("res/blood.png");
	}
	private int zidan=0;
	private Sky sky;
	private Hero hero;
	private Bird bird;
	private Actor[] bullets;
	// private Bullet[] bullets;
	private Actor[] enemies;
	private int score = 0;
	private int heros = 3;
	/**
	 * 定时器用于控制界面的主刷新频率
	 */
	private Timer timer;
	private int bigzhao = 0;
	Thunder th = new Thunder();

	public World() {
		sky = new Sky();
		hero = new Hero();
		bullets = new Bullet[0];
		enemies = new Actor[0];

	}

	public void paintBlood(Graphics g) {
		g.drawString("LIFE:", 10, 40);
		for (int i = 0; i < heros; i++) {
			g.drawImage(blood, 120 + i * 20, 16, null);
		}
	}

	public void paint(Graphics g) {
		/**
		 * 开启抗锯齿
		 */
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		sky.paint(g);
		hero.paint(g);

		if (hero.isLife()) {
			for (Actor bullet : bullets) {
				bullet.paint(g);
			}
		}
		for (Actor actor : enemies) {
			actor.paint(g);
		}
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		g.setFont(font);
		g.setColor(Color.yellow);
		// g.drawString("LIFE:" + heros, 10, 30);
		paintBlood(g2);
		g.drawString("SCORE:" + score, 10, 80);
		if (bigzhao == 1) {
			th.paint(g2);
			for (Actor ac : enemies) {
				ac.state = Actor.DEAD;

			}
			bigzhao = 0;
		}
		switch (state) {
		case READY:
			g.drawImage(readyImg, 0, 0, getWidth(), getHeight(), null);
			break;
		case PAUSE:
			g.drawImage(pauseImg, 0, 0, getWidth(), getHeight(), null);
			break;
		case GAMEOVER:
			g.drawImage(gameOverImg, 0, 0, getWidth(), getHeight(), null);
		}
	}

	public void action() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				synchronized (sky) {
					if (state == RUNNING) {
						addEnemies();
						moveObjects();
						addBullet();

						// 碰撞检查...
						checkDuang();
						checkObjectOutOfBounds();
						removeObjects();
						heroGoDead();
					}
					repaint();
				}
			}
		}, 1000 / 30, 1000 / 30);

		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				// 鼠标移动是执行
				if (state == RUNNING) {
					int x = e.getX();
					int y = e.getY();
					if (hero.isLife()) {
						hero.move(x, y);
					}
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				synchronized (sky) {
					switch (state) {
					case READY:
						state = RUNNING;
						break;
					case RUNNING:
						bigzhao = 1;
						if (hero.isLife()) {
							for (Actor ac : enemies) {
								ac.state = Actor.DEAD;
								if (hero.isLife()) {
									hero.hit();
								}
							}
							heros--;
							if (heros == 0) {
								hero.state = Actor.DEAD;
							}
						}
						break;
					case GAMEOVER:
						score = 0;
						heros = 3;
						bullets = new Bullet[0];
						enemies = new Actor[0];
						state = READY;
						break;
					}
				}

				System.out.println(state);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				synchronized (sky) {
					if (state == PAUSE) {
						state = RUNNING;
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				synchronized (sky) {
					if (state == RUNNING) {
						state = PAUSE;
					}
				}
			}

		};

		this.addMouseMotionListener(l);
		this.addMouseListener(l);

	}

	protected void heroGoDead() {
		if (hero.isLife()) {
			for (Actor actor : enemies) {
				if (actor.isLife() && actor instanceof Enemy && actor.duang(hero)) {
					if (actor instanceof Bird) {
						actor.goDead();
						bigzhao = 1;
						return;
					}
					hero.goDead();
					actor.goDead();
				}
			}
		}
		if (hero.isRemove()) {
			if (heros == 0) {
				state = GAMEOVER;
				return;
			}
			heros--;
			cleanEnemies();
			hero = new Hero();
		}
	}

	private void cleanEnemies() {
		for (Actor actor : enemies) {
			actor.goDead();
		}
	}

	protected void checkObjectOutOfBounds() {
		for (Actor a : enemies) {
			if (a.isLife()) {
				if (a.outOfBounds()) {
					a.state = Actor.REMOVE;
				}
			}
		}
		for (Actor b : bullets)
			if (b.isLife())
				if (b.outOfBounds()) {
					b.state = Actor.REMOVE;
				}
	}

	protected void removeObjects() {
		// System.out.println("子弹数量"+bullets.length);
		// System.out.println("飞机数量"+enemies.length);
		// Actor[]newAry=null;//0010010
		// for(int i=0;i<enemies.length;i++){
		// Actor actor=enemies[i];
		// if(enemies[i].state==Actor.REMOVE||enemies[i].state==Actor.DEAD){
		// if(newAry==null){
		// newAry=Arrays.copyOf(enemies, i);
		// }
		// continue;
		// }
		// if(newAry!=null){
		// newAry=Arrays.copyOf(newAry, newAry.length+1);
		// newAry[newAry.length-1]=actor;
		// }
		// }
		// if(newAry!=null)
		// enemies=newAry;

		removeEnemies();
		removeBullets();
	}

	public void removeBullets() {
		int rm = 0;
		for (int j = 0; j < bullets.length - rm; j++) {
			if (bullets[j].state == Actor.REMOVE) {
				rm++;
				for (int i = j; i < bullets.length; i++) {
					if (i < bullets.length - 1) {
						Actor temp = bullets[i];
						bullets[i] = bullets[i + 1];// 类似冒泡算法,也可以通过覆盖不进行交换
						bullets[i + 1] = temp;
					}
				}
				j -= 1;
			}

		}
		bullets = Arrays.copyOf(bullets, bullets.length - rm);
	}

	public void removeEnemies() {
		int ra = 0;
		for (int j = 0; j < enemies.length - ra; j++) {
			if (enemies[j].state == Actor.REMOVE) {
				ra++;
				for (int i = j; i < enemies.length; i++) {
					if (i < enemies.length - 1) {
						Actor temp = enemies[i];
						enemies[i] = enemies[i + 1];// 类似冒泡算法,也可以通过覆盖不进行交换
						enemies[i + 1] = temp;
					}
				}
				j -= 1;
			}

		}
		enemies = Arrays.copyOf(enemies, enemies.length - ra);
	}

	private void checkDuang() {
		for (Actor b : bullets) {
			for (Actor a : enemies)
				if (a.isLife() && b.isLife() && a.duang(b) && !(a instanceof Bird)) {
					a.hit();
					b.hit();
					/**
					 * actor引用是多态的方法:有打飞机小飞机,蜜蜂 其中大飞机小飞机有getScore方法bee没有
					 * 只有先判断actor引用对象的类型是大飞机或者是小飞机时候才能调用 getScore()方法 10
					 */
					if (a.isDead()) {
						if (a instanceof Enemy) {
							Enemy e = (Enemy) a;
							int s = e.getScore();
							score += s;
							if (a instanceof AttackPlane) {
								AttackPlane.plane = null;
							}
						}
						if (a instanceof Award) {
							Award award = (Award) a;
							int aw = award.getAward();
							switch (aw) {
							case Award.DOUBLE_FIRE:
								hero.setFireTpye(Award.DOUBLE_FIRE);
								break;
							case Award.FIRE:
								hero.setFireTpye(Award.FIRE);
								break;
							case Award.LIFE:
								heros++;
								System.out.println(heros);
								break;
							case Award.SPACE:
								hero.setFireTpye(Award.SPACE);
								break;
							}
						}
						if (a instanceof Bird) {
							Bird br = (Bird) a;
							System.out.println("LOLO");
						}
					}

				}
		}
		// for (Actor a : enemies)
		// if (a.isLife() && hero.isLife() && hero.duang(a)) {
		// hero.hit();
		//
		// }
	}

	private long interval = 1000;
	private long nextTime = System.currentTimeMillis() + interval;

	private void addEnemies() {
		long now = System.currentTimeMillis();
		if (now < nextTime) {
			return;
		}
		nextTime = now + interval;
		int num = (int) (Math.random() * 10);
		Actor actor;
		switch (num) {
		case 0:
		case 1:
			actor = new Bee();
			break;
		case 2:
		case 3:
			actor = new BigPlane();
			break;
		case 4:
			actor = new AwardBigPlane();
			break;
		case 5:
			actor = new Bird();
			break;
		case 6:
			AttackPlane.init();
			actor = AttackPlane.plane;
			break;
		default:
			actor = new Airplane();
			break;
		}
		enemies = Arrays.copyOf(enemies, enemies.length + 1);
		enemies[enemies.length - 1] = actor;
	}

	private int bullet_interval = 600;
	private long bullet_time = System.currentTimeMillis() + bullet_interval;

	public void addBullet() {
		long now = System.currentTimeMillis();
		if (!(now < bullet_time)) {
			bullets = hero.shoots(bullets);
			bullet_time += bullet_interval;
		}
	}

	private void moveObjects() {

		sky.move();
		for (Actor bullet : bullets) {
			bullet.move();
		}
		for (Actor a : enemies) {
			a.move();
		}

	}

	public void setZidanType() {
		if(zidan==0){
			Bullet.setImage(Actor.load("res/zidan.png"));
			zidan=1;
			hero.setZidan(zidan);
		}else{
			Bullet.setImage(Actor.load("res/bullet.png"));
			zidan=0;
			hero.setZidan(zidan);;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 700);
		frame.setLocationRelativeTo(null);// 必须先设置大小,才能用此方法居中
		World world = new World();
		frame.add(world);
		frame.setVisible(true);
		world.action();
		KeyAdapter kl = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code==KeyEvent.VK_ENTER){
					world.setZidanType();
				}
			}

		};
		frame.addKeyListener(kl);

	}

}
