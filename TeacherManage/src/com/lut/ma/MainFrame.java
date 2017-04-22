package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lut.db.DataBase;
import com.lut.te.Teacher;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenu menu1;
	private JMenu menu;
	private JMenu menu_1;
	private JMenu menuItem4;
	private JMenuItem menuItem11;
	
	DataBase db=new DataBase();
	
	DefaultListModel teachers=new DefaultListModel();
	JList list=new JList(teachers);
	private JMenuItem menuItem12;
	private JMenuItem menuItem13;
	private JMenuItem menuItem14;
	private JPanel panel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel label_11;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JMenuItem menuItem22;
	private JMenuItem menuItem21;
	private JMenuItem menuItem31;
	private JMenuItem menuItem41;
	private JButton searchPro;
	private JButton SearchTh;
	private JButton SearchCo;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		setResizable(false);
		setTitle("\u6559\u5E08\u4E1A\u52A1\u6863\u6848\u7BA1\u7406");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 550, 430);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu1 = new JMenu("\u6559\u5E08\u7BA1\u7406");
		menuBar.add(menu1);
		
		menuItem11 = new JMenuItem("\u6559\u5E08\u5F55\u5165");
		menu1.add(menuItem11);
		
		menuItem12 = new JMenuItem("\u804C\u79F0\u53D8\u66F4");
		menuItem12.addActionListener(this);
		menu1.add(menuItem12);
		
		menuItem13 = new JMenuItem("\u5DE5\u4F5C\u53D8\u66F4");
		menuItem13.addActionListener(this);
		menu1.add(menuItem13);
		
		menuItem14 = new JMenuItem("\u6559\u5E08\u6CE8\u9500");
		menuItem14.addActionListener(this); 
		menu1.add(menuItem14);
		menuItem11.addActionListener(this);
		
		menu = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		menuBar.add(menu);
		
		menuItem21 = new JMenuItem("\u8BFE\u7A0B\u6DFB\u52A0");
		menu.add(menuItem21);
		menuItem21.addActionListener(this);
		
		menuItem22 = new JMenuItem("\u8BFE\u7A0B\u5220\u9664");
		menu.add(menuItem22);
		menuItem22.addActionListener(this);
		
		menu_1 = new JMenu("\u8BBA\u6587\u7BA1\u7406");
		menuBar.add(menu_1);
		
		menuItem31 = new JMenuItem("\u8BBA\u6587\u6DFB\u52A0");
		menu_1.add(menuItem31);
		menuItem31.addActionListener(this);
		
		menuItem4 = new JMenu("\u9879\u76EE\u7BA1\u7406");
		menuBar.add(menuItem4);
		
		menuItem41 = new JMenuItem("\u9879\u76EE\u6DFB\u52A0");
		menuItem4.add(menuItem41);
		menuItem41.addActionListener(this);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_1.setColumns(15);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField_10.setColumns(10);
		
		list.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
//				String name=(String) list.getSelectedValue();
//				int index=list.getSelectedIndex();
//				String sql1="select Teacher.Number,Name,Sex,Adress,Birth,SchoolTag,Education,GraduateTime,Position,WorkFor,Major "+
//				"from Teacher,Position,TWork,Education "+
//				"where Teacher.Number=Position.Number and Teacher.Number=TWork.Number and Teacher.Number=Education.Number"+
//				" and Teacher.name='"+name+"'";
//			
//				ResultSet rs=db.executeQuery(sql1);
//				try {
//					if(rs.next())
//						setT(rs);
//					
//				} catch (SQLException e1) {
//					// TODO 自动生成的 catch 块
//					e1.printStackTrace();
//				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				String name=(String) list.getSelectedValue();
				int index=list.getSelectedIndex();
				String sql1="select Teacher.Number,Name,Sex,Adress,Birth,SchoolTag,Education,GraduateTime,Position,WorkFor,Major "+
				"from Teacher,Position,TWork,Education "+
				"where Teacher.Number=Position.Number and Teacher.Number=TWork.Number and Teacher.Number=Education.Number"+
				" and Teacher.name='"+name+"'";
			
				ResultSet rs=db.executeQuery(sql1);
				try {
					if(rs.next())
						setT(rs);
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
//		list.addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO 自动生成的方法存根
//				System.out.println(e.getSource().toString());
//				System.out.println(list.getSelectedIndex());
//			}
//		});
		
		
		JScrollPane jsp=new JScrollPane(list);//滚动条

		JPanel scoroll=new JPanel();
		scoroll.setLayout(new BorderLayout());
		scoroll.setPreferredSize(new Dimension(70, 20));
		
		JLabel label = new JLabel("教师列表");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		scoroll.add(label, BorderLayout.NORTH);
		scoroll.add(jsp, BorderLayout.CENTER);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(scoroll, BorderLayout.WEST);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		label_1 = new JLabel("\u6559\u5E08\u4FE1\u606F");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		label_2 = new JLabel("\u6559\u5E08\u7F16\u53F7:");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		lblNewLabel = new JLabel("\u59D3\u540D:");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("幼圆", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6027\u522B:");
		label_3.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u51FA\u751F\u65E5\u671F:");
		label_4.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("\u6BD5\u4E1A\u9662\u6821:");
		label_5.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("\u4E13\u4E1A:");
		label_6.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("\u7C4D\u8D2F:");
		label_7.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_8 = new JLabel("\u5B66\u5386:");
		label_8.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_9 = new JLabel("\u6BD5\u4E1A\u65F6\u95F4:");
		label_9.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_10 = new JLabel("\u804C\u79F0:");
		label_10.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		label_11 = new JLabel("\u5DE5\u4F5C:");
		label_11.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		
		SearchTh = new JButton("\u67E5\u8BE2\u8BBA\u6587");
		SearchTh.setFont(new Font("幼圆", Font.PLAIN, 18));
		SearchTh.addActionListener(this);
		searchPro = new JButton("\u67E5\u8BE2\u9879\u76EE");
		searchPro.setFont(new Font("幼圆", Font.PLAIN, 18));
		searchPro.addActionListener(this);
		
		SearchCo = new JButton("\u67E5\u8BE2\u8BFE\u7A0B");
		SearchCo.setFont(new Font("幼圆", Font.PLAIN, 18));
		SearchCo.addActionListener(this);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(195)
							.addComponent(label_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(SearchTh)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(searchPro)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(SearchCo))
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(SearchTh)
						.addComponent(searchPro)
						.addComponent(SearchCo))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		updateList();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		if(obj instanceof JMenuItem){
			JMenuItem jmi=(JMenuItem)obj;
			if(jmi.equals(menuItem11)){
				TypeIn ti=new TypeIn(teachers);
				ti.setVisible(true);
				new Thread(ti).start();
				
			}
			if(jmi.equals(menuItem12)){
				//职称
				PosiMa pm=new PosiMa();
				pm.setVisible(true);
				
			}
			if(jmi.equals(menuItem13)){
				//工作
				WorkArra wa=new WorkArra();
				wa.setVisible(true);
			}
			if(jmi.equals(menuItem14)){
				DelTeacher dt=new DelTeacher(teachers);
				dt.setVisible(true);
			}
			if(jmi.equals(menuItem21)){
				//添加课程
				AddCourse ac=new AddCourse();
				ac.setVisible(true);
				new Thread(ac).start();
			}
			if(jmi.equals(menuItem22)){
				//删除课程
				DelCourse dc=new DelCourse();
				dc.setVisible(true);
				new Thread(dc).start();
			}
			if(jmi.equals(menuItem31)){
				//论文
				Paper pa=new Paper();
				pa.setVisible(true);
				new Thread(pa).start();
			}
			if(jmi.equals(menuItem41)){
				Project pro=new Project();
				pro.setVisible(true);
				new Thread(pro).start();
			}
		}
		if(obj instanceof JButton){
			JButton jb=(JButton)obj;
			if(jb.equals(searchPro)){
				//项目
				
				SearchPoject sp=new SearchPoject(textField.getText().trim(),textField_1.getText().trim());
				sp.setVisible(true);
			}
			if(jb.equals(SearchTh)){
				//论文
				SearchPaper spp=new SearchPaper(textField.getText().trim(),textField_1.getText().trim());
				spp.setVisible(true);
				
			}
			if(jb.equals(SearchCo)){
				//课程
				SearchCourse sc=new SearchCourse(textField.getText().trim(),textField_1.getText().trim());
				sc.setVisible(true);
			}
		}
	}
    public void updateList(){
    	String Sql="select Name from Teacher";
    	ResultSet rs=db.executeQuery(Sql);
    	try {
			while(rs.next()){
				if(!teachers.contains(rs.getString(1).trim()))
				    teachers.addElement(rs.getString(1).trim());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
    public void setT(ResultSet rs) {
    	try {
    		
    		String school=rs.getString(6);
			textField.setText(rs.getString(1).trim());
			textField_1.setText(rs.getString(2).trim());
	    	textField_2.setText(rs.getString(3).trim());
	    	textField_3.setText(rs.getString(5).trim());
	    	textField_4.setText(school.trim());
	    	textField_5.setText(rs.getString(11).trim());
	    	textField_6.setText(rs.getString(10).trim());
	    	textField_7.setText(rs.getString(4).trim());
	    	textField_8.setText(rs.getString(7).trim());
	    	textField_9.setText(rs.getString(8).trim());
	    	textField_10.setText(rs.getString(9).trim());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	
    }
}
