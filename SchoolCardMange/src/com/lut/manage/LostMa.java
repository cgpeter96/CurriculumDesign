package com.lut.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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

public class LostMa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField num;
	private JPasswordField passwordField;
	private JButton guaBut;
	private JButton jieBut;
	DataBase db;
	private boolean flag;
	ResultSet rs;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LostMa() {
		setTitle("\u6302\u5931\u7BA1\u7406");
		db=new DataBase();
		setBounds(100, 100, 296, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		
		num = new JTextField();
		num.setColumns(10);
		
		JLabel key = new JLabel("\u5BC6\u7801\uFF1A");
		
		passwordField = new JPasswordField();
		
		guaBut = new JButton("\u6302\u5931");
		guaBut.addActionListener(this);
		
		jieBut = new JButton("\u89E3\u6302");
		jieBut.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(guaBut)
							.addGap(18)
							.addComponent(jieBut)
							.addGap(64))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(key)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(num, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
							.addGap(67))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(key))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(guaBut)
						.addComponent(jieBut))
					.addGap(16))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		String stuNum=num.getText();
		String keywords=String.valueOf(passwordField.getPassword());
		if(obj instanceof JButton){
			JButton jb=(JButton)obj;
			   if(jb.equals(guaBut)){
				   String sql1="select Cnumber,Cpassword from Card where Cnumber='"+stuNum+"'and Cpassword='"+keywords+"'";
				   db.executeQuery(sql1);
				   flag=db.getFlag();
				   if(!flag){
					   String sql2="update Card set Clost ="+0+" where Cnumber='"+stuNum+"'";
					   db.executeQuery2(sql2);
					   JOptionPane.showMessageDialog(this, "挂失成功！");
				   }
				   db.close();
			   }else
			   if(jb.equals(jieBut)){
				   String sql1="select Cnumber ,Cpassword from Card where Cnumber='"+stuNum+"'and Cpassword='"+keywords+"'";
				   db.executeQuery(sql1);
				   flag=db.getFlag();
				   if(!flag){
					   String sql2="update Card set Clost ="+1+" where Cnumber='"+stuNum+"'";
					   db.executeQuery2(sql2);
					   JOptionPane.showMessageDialog(this, "挂失解锁成功！");
				   }
				   db.close();
				   
			   }else{
				   
			   }
		}
		
	}
}
