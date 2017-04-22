package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.lut.db.DataBase;

public class WorkArra extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton Submit;
	private JButton Cancel;

	DataBase db=new DataBase();
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public WorkArra() {
		setType(Type.UTILITY);
		setTitle("\u5DE5\u4F5C\u53D8\u66F4");
		setBounds(600, 300, 230, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6559\u5E08\u7F16\u53F7:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("\u5DE5\u4F5C:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		Submit = new JButton("\u63D0\u4EA4");
		Submit.setFont(new Font("黑体", Font.PLAIN, 18));
		panel_1.add(Submit);
		Submit.addActionListener(this);
		Cancel = new JButton("\u53D6\u6D88");
		Cancel.setFont(new Font("黑体", Font.PLAIN, 18));
		panel_1.add(Cancel);
		Cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if(obj.equals(Submit)){
			String Number=textField.getText();
			String Work=textField_1.getText();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(new Date());
			String sql1="select Number from TWork";
			ResultSet rs=db.executeQuery(sql1);
			boolean flag=false;
			try {
				while(rs.next()){
					String t=rs.getString(1).trim();
					if(t.equals(Number)){
					
						String sql3="update TWork set WorkFor='"+Work+"',WorkTime='"+time+"' where Number='"+Number+"'";
						db.executeQuery2(sql3);
						flag=true;
						JOptionPane.showMessageDialog(this, "工作变更完毕");
					}
				}
				if(!flag){
				    String sql2="insert into TWork values('"+Number+"','"+Work+"','"+time+"')";
				    db.executeQuery2(sql2);
				    JOptionPane.showMessageDialog(this, "工作安排完毕");
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		if(obj.equals(Cancel)){
			this.setVisible(false);
		}
		
		
	}
}
