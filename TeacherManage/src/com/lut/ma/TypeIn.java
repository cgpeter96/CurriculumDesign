package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.lut.db.DataBase;
import com.lut.te.Teacher;

public class TypeIn extends JFrame implements ActionListener ,Runnable{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton TypeIn;
	private JButton TypeCancel;
	DefaultListModel tea;
	
	DataBase db=new DataBase();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TypeIn(DefaultListModel col) {
		tea=col;
		
		setTitle("\u6559\u5E08\u4FE1\u606F\u5F55\u5165");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel label = new JLabel("\u6559\u5E08\u7F16\u53F7:");
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D:");
		
		JLabel label_2 = new JLabel("\u6027\u522B:");
		
		JLabel lblNewLabel = new JLabel("\u7C4D\u8D2F:");
		
		JLabel label_3 = new JLabel("\u51FA\u751F:");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u5386:");
		
		JLabel label_4 = new JLabel("\u6BD5\u4E1A\u5B66\u6821:");
		
		JLabel label_5 = new JLabel("\u4E13\u4E1A:");
		
		JLabel label_6 = new JLabel("\u6BD5\u4E1A\u65F6\u95F4:");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel))
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addGap(28)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_4)
						.addComponent(textField_3)
						.addComponent(textField_2)
						.addComponent(textField_1)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
					.addGap(60)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(lblNewLabel_1)
								.addComponent(label_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		TypeIn = new JButton("\u5F55\u5165");
		panel_1.add(TypeIn);
		TypeIn.addActionListener(this);
		TypeCancel = new JButton("\u53D6\u6D88");
		panel_1.add(TypeCancel);
		TypeCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		
		if(obj instanceof JButton){
			JButton but=(JButton)obj;
			if(but.equals(TypeIn)){
				//录入按钮
				Teacher teach=new Teacher();
				String Number=textField.getText();
				String Name=textField_1.getText();
				String Sex=textField_2.getText();
				String Address=textField_3.getText();
				String Birth=textField_4.getText();
				String Education =textField_6.getText();
				String School=textField_5.getText();
				String Major=textField_7.getText();
				String GraTime=textField_8.getText();
				infoType(teach, Number, Name, Sex, Address, Birth);
				String sql1="insert into Teacher values('"+Number+"','"+Name+"','"+Sex+"','"+Address+"','"+Birth+"')";
				String sql2="insert into Education values('"+Number+"','"+Education+"','"+School+"','"+GraTime+"','"+Major+"')";
				String sql3="select Number from Teacher";
				ResultSet rs=db.executeQuery(sql3);
				boolean flag=false;
				try {
					while(rs.next()){
						String t=rs.getString(1).trim();
						if(t.equals(Number)){
							JOptionPane.showMessageDialog(this, t+":该编号已存在，请更改");
							flag=true;
						}
					}
				} catch (SQLException e1) {
			
					e1.printStackTrace();
					
				}
				if(!flag){
				   db.executeQuery2(sql1);
				   db.executeQuery2(sql2);
			   	   JOptionPane.showMessageDialog(this, "信息录入成功");
			   	   setNull();
				   updateList();
				   
				}
			}else
				if(but.equals(TypeCancel)){
					//取消按钮
					this.setVisible(false);
				}
			
		}
	}
	public void updateList(){
    	String Sql="select Name from Teacher";
    	ResultSet rs=db.executeQuery(Sql);
    	try {
			while(rs.next()){
				if(!tea.contains(rs.getString(1).trim()))
				    tea.addElement(rs.getString(1).trim());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
	public void infoType(Teacher t,String s1,String s2,String s3,String s4,String s5){
		t.setNumber(s1);
		t.setName(s2);
		t.setSex(s3);
		t.setAddress(s4);
		t.setBirth(s5);
		
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			String num=textField.getText();
			String s1=null;
			if(num.isEmpty()){
				String sql="select Number from Teacher";
				ResultSet rs=db.executeQuery(sql);
				try {
					while(rs.next()){
						
							if(rs.isLast()){
								s1=rs.getString(1).trim();															
							    int i=(int)Integer.valueOf(s1)+1;
							    textField.setText(String.valueOf(i));
							    }
					}
				} catch (NumberFormatException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	public void setNull(){
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");	
	}
}
