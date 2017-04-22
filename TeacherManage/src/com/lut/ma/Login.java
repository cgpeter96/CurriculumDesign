package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel img;
	private JButton button;
	private JButton button_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBounds(100, 100, 348, 200);
		
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setFont(new Font("华文琥珀", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setFont(new Font("华文琥珀", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(20);
		
		button = new JButton("登录");
		button.addActionListener(this);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		button_1 = new JButton("取消");
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_1.addActionListener(this);
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(183, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		img = new JLabel();
	    ImageIcon ii=new ImageIcon("cb0222bz02.jpg");
	    Image i=ii.getImage().getScaledInstance(400, 170, Image.SCALE_DEFAULT);//缩放图像
		img.setIcon(new ImageIcon(i));
		img.setLayout(null);
		contentPane.add(img, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource().equals(button)){
			if(textField.getText().equals("ma")&&(String.valueOf(passwordField.getPassword())).equals("123")){
			this.setVisible(false);
			JOptionPane.showMessageDialog(this, "欢迎登录系统");
			MainFrame mf;
			try {
				mf = new MainFrame();
				mf.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			}
			else{
				JOptionPane.showMessageDialog(this, "用户名或密码不正确");
			}
		}
		if(e.getSource().equals(button_1)){
			JOptionPane.showMessageDialog(this, "退出程序");
			System.exit(0);
		}
		
	}
}
