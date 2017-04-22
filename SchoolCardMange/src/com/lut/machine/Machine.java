package com.lut.machine;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.lut.test.DataBase;

public class Machine extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField sMoney;
	private JTable table;
	private JTextField stuNum;
	private JButton sureButton;
	private static int MacNum=0;
	static int orderNum=10000;
	DataBase db;
	ResultSet rs;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Machine window = new Machine();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Machine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MacNum+=1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u6D88\u8D39\u673A\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setText("消费机"+Integer.toString(MacNum));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(64)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(294))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6D88\u8D39\u91D1\u989D\uFF1A");
		
		sMoney = new JTextField();
		sMoney.setColumns(10);
		
		table = new JTable();
		
		JLabel label_1 = new JLabel("\u6D88\u8D39\u5B66\u53F7\uFF1A");
		
		stuNum = new JTextField();
		stuNum.setColumns(10);
		
		sureButton = new JButton("\u786E\u5B9A");
		sureButton.addActionListener(this);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sMoney, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stuNum, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sureButton)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(sMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(stuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(32)
							.addComponent(sureButton)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		if(obj instanceof JButton){
			JButton jb=(JButton)obj;
			if(jb.equals(sureButton)){
				db=new DataBase();
				String cost=sMoney.getText();//消费
				String num=stuNum.getText();//学号
//				String sq="Select Cmoney,Clost from Card where Cnumber='"+num+"'";
//				ResultSet rs=db.executeQuery3(sq);
//				float mon1=-1;
//				int bit=0;
//					try {
//						while(rs.next()){
//						mon1=Float.parseFloat(rs.getString(1));
//						bit=Integer.parseInt(rs.getString(2));
//						}
//					} catch (NumberFormatException e2) {
//				
//						e2.printStackTrace();
//					} catch (SQLException e2) {
//	
//						e2.printStackTrace();
//					}
				
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
				String time=sdf.format(new Date());
				//单号
				String sql1="select Cmoney,Clost from Card where Cnumber='"+num+"'";
				rs=db.executeQuery3(sql1);
				String oldMon="0";
				String lost="1";
				try {
					while(rs.next()){
						oldMon=rs.getString(1);
						lost=rs.getString(2);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if(lost.equals("1")&& Float.parseFloat(oldMon)>0){
				float NowMon=Float.parseFloat(oldMon)-Float.parseFloat(cost);
				String sql2="update Card set Cmoney="+NowMon+" where Cnumber='"+num+"'";
				db.executeQuery2(sql2);
				String sql3="INSERT INTO costTable values('"+orderNum+++"','"+num+"',"+cost+",'机器"+MacNum+"','"+time+"')";
				
				db.executeQuery2(sql3);
				if(NowMon<=0)
					JOptionPane.showMessageDialog(this, "消费成功，卡已欠费，请充值");
						
			}else{
				if(Float.parseFloat(oldMon)<0)
				    JOptionPane.showMessageDialog(this, "卡上余额不足，请充值");
				if(lost.equals("0"))
					JOptionPane.showMessageDialog(this, "卡已挂失，禁止消费");
						
			}
			
		}
		
	}
}
	
}