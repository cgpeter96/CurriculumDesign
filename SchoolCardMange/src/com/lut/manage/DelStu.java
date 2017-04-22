package com.lut.manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.lut.test.DataBase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelStu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btu1;
	private JButton button;
	DataBase db;


	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public DelStu() {

		setTitle("\u6CE8\u9500\u7528\u6237");
		setBounds(100, 100, 279, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		btu1 = new JButton("\u6CE8\u9500");
		btu1.addActionListener(this);
		
		button = new JButton("\u53D6\u6D88");
		button.addActionListener(this);
		db=new DataBase();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btu1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
					.addGap(43))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btu1)
						.addComponent(button))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		if(obj instanceof JButton){
			JButton jb=(JButton)obj;
			if(jb.equals(btu1)){
				boolean flag=false;
				String name=textField.getText();  //获取删除学生学号和密码
				String pass=String.valueOf(passwordField.getPassword());
				String sql1="select Cnumber,Cpassword from Card where Cnumber='"+name+"'and Cpassword='"+pass+"'";
				db.executeQuery(sql1);
				flag=db.getFlag();
				if(!flag){
					String sql2="delete Student where Number ='"+name+"'";
					db.executeQuery2(sql2);
					JOptionPane.showMessageDialog(this, "注销完成");
				}
			}
			if(jb.equals(button)){
				//取消按钮
				this.setVisible(false);
			}
		}
		
	}
}
