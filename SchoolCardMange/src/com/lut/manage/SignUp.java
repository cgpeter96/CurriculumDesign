package com.lut.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.lut.test.DataBase;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SignUp extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField uesrField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	JButton Signup;
	JButton Cancel;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setTitle("\u7BA1\u7406\u5458\u6CE8\u518C");
		setBounds(100, 100, 307, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel userLab = new JLabel("\u8F93\u5165\u767B\u5F55\u540D");
		
		uesrField = new JTextField();
		uesrField.setColumns(10);
		
		JLabel label = new JLabel("\u8F93\u5165\u5BC6\u7801");
		
		passwordField = new JPasswordField();
		
		 Signup = new JButton("\u6CE8\u518C");
		Signup.addActionListener(this);
		
		JLabel label_1 = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801");
		
		passwordField_1 = new JPasswordField();
		
		 Cancel = new JButton("\u53D6\u6D88\u6CE8\u518C");
		Cancel.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(userLab)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField_1)
						.addComponent(passwordField)
						.addComponent(uesrField, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addComponent(Signup)
					.addGap(36)
					.addComponent(Cancel)
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userLab)
						.addComponent(uesrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Cancel)
						.addComponent(Signup))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		String user=null;
		char []pwd;
		char []pwd1;;
		
		if(obj instanceof JButton){
			JButton jb=(JButton)obj;
			
			if(jb.equals(Cancel)){
				this.setVisible(false);
			}else
				if(jb.equals(Signup)){
					user=uesrField.getText();
					pwd=passwordField.getPassword();
					pwd1=passwordField_1.getPassword();
					System.out.println(pwd);
					System.out.println(pwd1);
					if(Arrays.equals(pwd, pwd1)){
						String spwd=String.valueOf(pwd);
						DataBase db=new DataBase();
					    db.executeQuery("INSERT INTO Manager values('"+user+"','"+spwd+"')");
					    JOptionPane.showMessageDialog(this,"注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					    db.close();
					    this.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(this,"两次密码输入不一致", "提示", JOptionPane.WARNING_MESSAGE);
						passwordField.setText("");
						passwordField_1.setText("");
					}
					
				}
		}
	}


	
}
