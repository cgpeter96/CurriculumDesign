package res;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyTest extends JPanel implements KeyListener {
	
	public void paint(Graphics g){
		g.drawString("\"lol", 50, 50);
	}
	public KeyTest() {
	
	
	}

	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setSize(400, 400);
		frame.add(new KeyTest());
		frame.setVisible(true);
		KeyAdapter kl = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int code =e.getKeyCode();
				System.out.println(code);
						
			}

		};
		frame.addKeyListener(kl);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
