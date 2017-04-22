package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.xml.crypto.Data;

import com.lut.db.DataBase;

public class Paper extends JFrame implements ActionListener,Runnable {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton button;
	private JButton button_1;
	DataBase db=new DataBase();
	private JLabel label_4;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Paper() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("\u8BBA\u6587\u6DFB\u52A0");
		setBounds(100, 100, 374, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel label = new JLabel("\u8BBA\u6587\u53F7:");
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u53F7:");
		
		JLabel label_2 = new JLabel("\u8BBA\u6587\u540D\u79F0:");
		
		JLabel lblNewLabel = new JLabel("\u671F\u520A\u4F1A\u8BAE\u540D\u79F0:");
		
		JLabel lblNewLabel_1 = new JLabel("\u65F6\u95F4:");
		
		JLabel lblNewLabel_2 = new JLabel("\u671F\u520A\u7EA7\u522B:");
		
		JLabel label_3 = new JLabel("\u7D22\u5F15\u60C5\u51B5:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		label_4 = new JLabel("\u6392\u540D:");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_2)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addGap(18)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(label_1)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		button = new JButton("\u63D0\u4EA4");
		panel_1.add(button);
		button.addActionListener(this);
		button_1 = new JButton("\u53D6\u6D88");
		panel_1.add(button_1);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource().equals(button)){
			String Pnum=textField.getText();
			String Tnum=textField_3.getText();
			String Name=textField_1.getText();
			String Time =textField_2.getText();
			String BookName=textField_4.getText();
			String Level =textField_5.getText();
			String index=textField_6.getText();
			String pa=textField_7.getText();
			String sql3="select 论文号 from Paper where 论文号='"+Pnum+"'";
			ResultSet rs=db.executeQuery(sql3);
			String sql=null;
			try {
				if(!rs.next()){
//					if(!rs.getString(1).trim().equals(Pnum)){
//						sql="insert into Paper values('"+Pnum+"','"+Name+"','"+BookName+"','"+Time+"','"+Level+"','"+index+"')";
//						db.executeQuery2(sql);
//					}
					sql="insert into Paper values('"+Pnum+"','"+Name+"','"+BookName+"','"+Time+"','"+Level+"','"+index+"')";
					db.executeQuery2(sql);
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
			String sql2="insert into SendPaper values('"+Tnum+"','"+Pnum+"','"+pa+"')";
			
			db.executeQuery2(sql2);
			JOptionPane.showMessageDialog(this, "添加成功");
			
		}
		if(e.getSource().equals(button_1)){
			this.setVisible(false);
		}
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			String num=textField.getText();
			if(!num.isEmpty()){
				String sql="select * from Paper where 论文号='"+num+"'";
				ResultSet rs=db.executeQuery(sql);
				if(rs!=null){
					try {
						if(rs.next()){
							textField_1.setText(rs.getString(2).trim());
							textField_2.setText(rs.getString(4).trim());
							textField_4.setText(rs.getString(3).trim());
							textField_5.setText(rs.getString(5).trim());
							textField_6.setText(rs.getString(6).trim());
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}
	}

}
