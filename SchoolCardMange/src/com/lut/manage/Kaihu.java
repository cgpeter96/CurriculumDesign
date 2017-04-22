package com.lut.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.lut.student.Card;
import com.lut.student.Student;
import com.lut.test.DataBase;

public class Kaihu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField numberField;
	private JTextField nameField;
	private JTextField sexField;
	private JTextField ageField;
	private JButton button;
	private JButton button_1;
	private JLabel label_4;
	private JTextField collegeField;
	private JLabel label_5;
	private JLabel label_6;
	private JPasswordField passwordField;
	private JTextField moneyField;
	
	Student st;
	Card cd;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Kaihu() {
		setTitle("\u6821\u56ED\u5361\u5F00\u6237");
		setBounds(100, 100, 416, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A");
		
		numberField = new JTextField();
		numberField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		sexField = new JTextField();
		sexField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		
		button = new JButton("\u5F00\u6237");
		button.addActionListener(this);
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(this);
		
		label_4 = new JLabel("\u5B66\u9662\uFF1A");
		
		collegeField = new JTextField();
		collegeField.setColumns(10);
		
		label_5 = new JLabel("\u5BC6\u7801\uFF1A");
		
		label_6 = new JLabel("\u9996\u5145\u91D1\u989D\uFF1A");
		
		passwordField = new JPasswordField();
		
		moneyField = new JTextField();
		moneyField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_5)
								.addComponent(label_4)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label)))
						.addComponent(label_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(moneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(294, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
									.addComponent(button_1))
								.addComponent(sexField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(collegeField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_3))
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(numberField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(119))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(numberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(sexField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(collegeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(moneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();		
		if(obj instanceof JButton){
			JButton jb=(JButton)obj;
			if(jb.equals(button_1)){
				this.setVisible(false);
			}else
				if(jb.equals(button)){
					st=new Student();
				    cd=new Card();
					DataBase db=new DataBase();
					String num=numberField.getText();
					String name=nameField.getText();
					int age=new Integer(ageField.getText());
					String sex=sexField.getText();
					String college=collegeField.getText();
					String pass=new String(passwordField.getPassword());
					float money=new Float(moneyField.getText());
					System.out.println(money);
					st.setNumber(num);
					st.setName(name);
					st.setAge(age);
					st.setCollege(college);
					st.setSex(sex);
					cd.setLost(1);
					cd.setCmoney(money);
					cd.setCnumber(num);
					cd.setCpassword(pass);
					try {
					    String sql1="insert into Student values('"+st.getNumber()+"','"+st.getName()+"','"+st.getSex()+
					    		"',"+st.getAge()+",'"+st.getCollege()+"')";
					    String sql2="insert into Card values('"+cd.getCnumber()+"','"+cd.getCpassword()+"',"+cd.getCmoney()+
					    		","+cd.isLost()+")";
					    String sql3="update Card set Cmoney="+cd.getCmoney()+" where Cnumber='"+st.getNumber()+"'";
					    db.executeQuery2(sql1);
					    db.executeQuery2(sql2);
					    db.executeQuery2(sql3);
					    db.close();
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("卧槽，开户出错了!"+"\n"+e2);
						
					}
				}
		}
	}
}
