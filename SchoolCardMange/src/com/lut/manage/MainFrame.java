package com.lut.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lut.test.DataBase;

public class MainFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField maField;
	private JMenu menu1;
	private JMenuItem menu11;
	private JMenuItem menu21;
	private JTable table;
	private JButton FlashBt;
	private JScrollPane scrollPane;
	private Vector colName;
    private Vector rowData;
    private DefaultTableModel tableModel;
    private JMenuItem czMenu;
    DataBase db;
    private JMenuItem gzMenu;
    private JMenuItem zxMenu;
    String maName;
    private JButton searchBtu;
    private JMenuItem SumMenu;
    private JMenuItem todayMenu;
    static int n=0;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public MainFrame(String name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		maName=name;
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		setTitle("\u6821\u56ED\u5361\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 394);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu1 = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menuBar.add(menu1);
		
		menu11 = new JMenuItem("\u5EFA\u7ACB\u8425\u4E1A\u6863\u6848");
		menu1.add(menu11);
		
		JMenu munu2 = new JMenu("\u5B66\u751F\u5361\u7BA1\u7406");
		menuBar.add(munu2);
		
		menu21 = new JMenuItem("\u5F00\u6237");
		menu21.addActionListener(this);
		munu2.add(menu21);
		
		czMenu = new JMenuItem("\u5145\u503C");
		munu2.add(czMenu);
		
		gzMenu = new JMenuItem("\u6302\u5931\u89E3\u6302");
		munu2.add(gzMenu);
		
		zxMenu = new JMenuItem("\u6CE8\u9500");
		munu2.add(zxMenu);
		zxMenu.addActionListener(this);
		
		JMenu menu3 = new JMenu("\u8425\u4E1A\u6C47\u603B");
		menuBar.add(menu3);
		
		todayMenu = new JMenuItem("\u5F53\u65E5\u6536\u76CA");
		todayMenu.addActionListener(this);
		menu3.add(todayMenu);
		
		SumMenu = new JMenuItem("\u603B\u6536\u76CA");
		SumMenu.addActionListener(this);
		menu3.add(SumMenu);
		gzMenu.addActionListener(this);
		czMenu.addActionListener(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel maLabel = new JLabel("\u5F53\u524D\u7BA1\u7406\u5458\uFF1A");
		
		maField = new JTextField();
		maField.setEditable(false);
		maField.setColumns(10);
		maField.setText(name);
		
//		colName=new Vector();
//		colName.add("学号");
//		colName.add("姓名");
//		colName.add("性别");
//		colName.add("年龄");
//		colName.add("学院");
//		colName.add("卡上余额");
//		colName.add("是否挂失");
//		rowData=new Vector();
//		DefaultTableModel dtm=new DefaultTableModel();
//		String col[]={"学号","姓名","性别","年龄","学院","卡上余额","是否挂失"};
//		String row[][]={};
		FlashBt = new JButton("\u5237\u65B0\u8868\u5355");
		FlashBt.addActionListener(this);
		table = new JTable();
		table.setCellSelectionEnabled(true);
		scrollPane = new JScrollPane(table);
		
		JLabel label = new JLabel("\u5B66\u751F\u5361\u4FE1\u606F");
		
		searchBtu = new JButton("\u67E5\u8BE2\u5B66\u751F");
		searchBtu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(searchBtu)){
					String seaNum=JOptionPane.showInputDialog(contentPane, "输入查询学号");
					System.out.println(seaNum);
					String sql="select Student.Name,Student.Number,Student.Age,Student.Sex,"
							+ "Student.College,Card.Clost,Card.Cmoney from Student,Card where Student.Number=Card.Cnumber"
							+" and Cnumber='"+seaNum+"'";						
					ResultSet rs=db.executeQuery3(sql);
					try {
						if(rs.next()){
						String s1=rs.getString(1);
						String s2=rs.getString(2);
						String s3=rs.getString(3);
						String s4=rs.getString(4);
						String s5=rs.getString(5);
						String s6=rs.getString(6);
						String s7=rs.getString(7);
						
						ShowInfo si=new ShowInfo();
						si.setInfo(s1, s2, s3, s4, s5, s6, s7);
						si.setVisible(true);
						}
					} catch (Exception e1) {
						System.out.println("出错在查询按钮");
						e1.printStackTrace();
					}

					
				}
			}
		});
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(maLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(searchBtu)
								.addComponent(FlashBt))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addGap(3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(maLabel)
										.addComponent(maField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addComponent(FlashBt)
							.addGap(36)
							.addComponent(searchBtu)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		showData();
	}

	public void showData() throws SQLException {
		colName=new Vector();
		rowData=new Vector();

		db=new DataBase();
		String sql="select Student.Number,Student.Name,Student.Age,Student.Sex,"
				+ "Student.College,Card.Cmoney from Student,Card where Student.Number=Card.Cnumber";
		ResultSet rs=db.executeQuery3(sql); 
			
		ResultSetMetaData rsmd=rs.getMetaData();
//		for(int i=1;i<=rsmd.getColumnCount();i++){
//			colName.addElement(rsmd.getCatalogName(i));			
//		}
		colName.addElement("学号");
		colName.addElement("姓名");
		colName.addElement("年龄");
		colName.addElement("性别");
		colName.addElement("学院");
		colName.addElement("卡上余额");

		
			
		Vector row=new Vector();
		while(rs.next()){
//			for(int j=1;j<=rsmd.getColumnCount();j++)
//			     row.addElement(rs.getString(j));
		
			rowData.addElement(getRow(rs,rsmd));
		}

	
		tableModel =new DefaultTableModel(rowData,colName);
		table.setModel(tableModel);
		table.repaint();
		table.updateUI();
		table.setSurrendersFocusOnKeystroke(true);
		db.close();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Object obj=e.getSource();
		if(obj instanceof JMenuItem){
			JMenuItem jmi=(JMenuItem)obj;
			if(jmi.equals(menu21)){
				Kaihu kaihu=new Kaihu();
			    kaihu.setVisible(true);
			}
			if(jmi.equals(czMenu)){
					String str=null;
							str=(String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					String input="0";
							input=JOptionPane.showInputDialog(this,"请输入充值金额","输入金额");
					if(str!=null){
					//获取单元格
					db=new DataBase();
					String sql="select Cmoney from Card where Cnumber="+str;
					ResultSet rs=db.executeQuery3(sql);
					String mon = null;
					if(input!=null){
					try {
					while(rs.next())
							mon=rs.getString(1);
						
					float money=Float.parseFloat(mon);
//					System.out.println(mon);
					
					money+=Float.parseFloat(input);
					String sql1="Update Card set Cmoney="+money+" where Cnumber="+str;
					db.executeQuery2(sql1);
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
					String time=sdf.format(new Date());
					String sql2="Insert into RechargeTable values('"+(++n)+"','"+str+"',"+input+",'"+maName+"','"+time+"')";
					db.executeQuery2(sql2);
					showData();
						
					} catch (SQLException e1){	
							e1.printStackTrace();
					}finally{
						
						
						
					}JOptionPane.showMessageDialog(this, "充值成功！");
				 }
					}
				}
				if(obj.equals(gzMenu)){
						LostMa lm=new LostMa();
						lm.setVisible(true);
				}
//					else {
//						JOptionPane.showMessageDialog(this, "请刷新表单选中学号");
//				}
			 if(obj.equals(zxMenu)){
				DelStu ds=new DelStu();
				ds.setVisible(true);
				try {
					showData();
				} catch (SQLException e1) {
					System.out.println("注销用户出错");
					e1.printStackTrace();
				}
			}
			 if(obj.equals(todayMenu)){
				 float today=0;
//				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
//					String time=sdf.format(new Date());
				 String sql1="select Recharge,Time from RechargeTable ";
				 String sql2="select Spend,time from costTable";
				 SimpleDateFormat sd=new SimpleDateFormat("yyyy年MM月dd日");
				 String time=sd.format(new Date());
				 ResultSet rs1=db.executeQuery3(sql1);
				 ResultSet rs2=db.executeQuery3(sql2);
				 try {
					while(rs1.next()){
						 if(rs1.getString(2).startsWith(time)){
							    today=today+Float.parseFloat(rs1.getString(1));
						 }
					 }
					while(rs2.next()){
						 if(rs2.getString(2).startsWith(time)){
							    today=today+Float.parseFloat(rs2.getString(1));
							    System.out.println(rs2.getString(1));
						 }
					 }
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				 
				 JOptionPane.showMessageDialog(this,"今日消费："+today+"元","今日收益", JOptionPane.DEFAULT_OPTION);
			 }
			 if(obj.equals(SumMenu)){
				 String sql1="select Recharge from RechargeTable ";
				 String sql2="select Spend from costTable";
				 float sum=0;
				 ResultSet rs1=db.executeQuery3(sql1);
				 ResultSet rs2=db.executeQuery3(sql2);
				 try {
					while(rs1.next()){
						sum=sum+Float.parseFloat(rs1.getString(1));
					}
					while(rs2.next()){
						sum=sum+Float.parseFloat(rs2.getString(1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					System.out.println("in sum\n");
				}
				 JOptionPane.showMessageDialog(this,"收益汇总："+sum+"元","累计收益", JOptionPane.DEFAULT_OPTION);
			 }
		}else
		     if(obj instanceof JButton){
			   JButton jb=(JButton)obj;
			   if(jb.equals(FlashBt))
				   try {
						showData();
					} catch (SQLException sqle) {
						// TODO 自动生成的 catch 块
					   System.out.println("here "+sqle);
					}
		}
			
	}
	public Vector getRow(ResultSet row , ResultSetMetaData rsm) throws SQLException{
		Vector v=new Vector();
		for(int i=1;i<=rsm.getColumnCount();i++)
			v.addElement(row.getString(i));
		
		return v;
	}
}
