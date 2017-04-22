package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.lut.db.DataBase;

public class PosiMa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton Sure;
	private JButton Cancel;
	
	DataBase db=new DataBase();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PosiMa() {
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitle("\u804C\u79F0\u53D8\u66F4");
		setResizable(false);
		setType(Type.UTILITY);
		setBounds(600, 300, 205, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6559\u5E08\u7F16\u53F7:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		JLabel label_1 = new JLabel("\u804C\u79F0\u53D8\u66F4:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		Sure = new JButton("\u53D8\u66F4");
		Sure.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		Sure.addActionListener(this);
		panel_1.add(Sure);
		
		Cancel = new JButton("\u53D6\u6D88");
		Cancel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		panel_1.add(Cancel);
		Cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		if(obj instanceof JButton){
			JButton jb=(JButton)obj;
			if(jb.equals(Sure)){
				String Num=textField.getText();
				String Pos=textField_1.getText();
				String sql1="select Number from Position";
				ResultSet rs=db.executeQuery(sql1);
				boolean flag=false;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String time=sdf.format(new Date());
				try {
					while(rs.next()){
						String t=rs.getString(1).trim();
						if(t.equals(Num)){
						
							String sql3="update Position set Position='"+Pos+"',GetTime='"+time+"' where Number='"+Num+"'";
							db.executeQuery2(sql3);
							flag=true;
							JOptionPane.showMessageDialog(this, "职称变更完毕");
						}
					}
					if(!flag){
					    String sql2="insert into Position values('"+Num+"','"+Pos+"','"+time+"')";
					    db.executeQuery2(sql2);
					    JOptionPane.showMessageDialog(this, "职称获得完毕");
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
			if(jb.equals(Cancel)){
				setVisible(false);
			
			}
			
		}
	}
}
