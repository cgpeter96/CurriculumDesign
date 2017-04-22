package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import com.lut.db.DataBase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelTeacher extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private DefaultListModel tea;
	DataBase db=new DataBase();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DelTeacher( DefaultListModel t) {
		tea=t;
		setTitle("\u6559\u5E08\u6CE8\u9500");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 198, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6559\u5E08\u7F16\u53F7:");
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(172, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		button = new JButton("\u6CE8\u9500");
		button.addActionListener(this);
		panel_1.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		panel_1.add(button_1);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource().equals(button)) {
			String num=textField.getText();
			String name=textField_1.getText();
			String sql="delete Teacher where Number='"+num+"'";
			String sql1="delete TWork where Number='"+num+"'";
			String sql6="delete Education where Number='"+num+"'";
			String sql2="delete Position where Number='"+num+"'";
			String sql3="delete AddCourse where Number='"+num+"'";
			String sql4="delete SendPaper where Number='"+num+"'";
			String sql5="delete JoinProject where Number='"+num+"'";
			db.executeQuery2(sql);
			db.executeQuery2(sql1);
			db.executeQuery2(sql2);
			db.executeQuery2(sql3);
			db.executeQuery2(sql4);
			db.executeQuery2(sql5);
			db.executeQuery2(sql6);
			tea.removeElement(name);
			
			String t=name+"老师注销成功";
			JOptionPane.showMessageDialog(this,t );
						
		}
		if(e.getSource().equals(button_1)){
			this.setVisible(false);
		}
	}
}
