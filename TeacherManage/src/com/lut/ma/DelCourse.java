package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import com.lut.db.DataBase;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DelCourse extends JFrame implements Runnable,ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel panel_1;
	private JButton Sure;
	private JButton Cancel;
	
	
	DataBase db=new DataBase();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DelCourse() {
		setTitle("\u8BFE\u7A0B\u5220\u9664");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u7F16\u53F7:");
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u7F16\u53F7:");
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u540D\u79F0:");
		
		JLabel label_4 = new JLabel("\u8BFE\u7A0B\u8BFE\u65F6:");
		
		JLabel label_5 = new JLabel("\u4E0A\u8BFE\u73ED\u7EA7:");
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u4EBA\u6570:");
		
		JLabel label_6 = new JLabel("\u4E0A\u8BFE\u65F6\u95F4:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_2)
						.addComponent(label_4)
						.addComponent(lblNewLabel))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(label_6)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		Sure = new JButton("\u5220\u9664\u8BFE\u7A0B");
		Sure.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 18));
		panel_1.add(Sure);
		Sure.addActionListener(this);
		
		Cancel = new JButton("\u53D6\u6D88\u5220\u9664");
		Cancel.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 18));
		panel_1.add(Cancel);
		Cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource().equals(Cancel)){
			//cancel
			new Thread(this).stop();
			this.setVisible(false);
		}
		if(e.getSource().equals(Sure)){
			//sure
			String deln=textField.getText();
			String sql1="delete Courses where CNumber='"+deln+"'";
			String sql2="delete AddCourse where Cnum='"+deln+"'";
			db.executeQuery2(sql1);
			db.executeQuery2(sql2);
			JOptionPane.showMessageDialog(this, "课程："+deln+"删除成功");
		}
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			String Cnum=textField.getText();
			String Tnum=textField.getText();
			if(!Cnum.isEmpty()){
//				String sql1="select * from Courses，AddCourse,Teacher where CNumber='"+Cnum+"'";
				String sql1="select CNumber,Course,Hours,People,Time,Classroom,Teacher.Name from Courses,AddCourse,Teacher where CNumber='"+Cnum+"'"+" and CNumber=AddCourse.Cnum and Teacher.Number=AddCourse.Number";
				ResultSet rss=db.executeQuery(sql1);
				try {
					if(rss.next()){
					textField_1.setText(rss.getString(2).trim());
					textField_2.setText(rss.getString(3).trim());
					textField_3.setText(rss.getString(4).trim());
					textField_5.setText(rss.getString(7).trim());
					textField_6.setText(rss.getString(6).trim());
					textField_7.setText(rss.getString(5).trim());
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();								
			}
		}
		}

	}
	
}
