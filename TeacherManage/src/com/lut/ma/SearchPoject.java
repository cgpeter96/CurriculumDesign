package com.lut.ma;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lut.db.DataBase;

public class SearchPoject extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector row;
	private Vector col;
	private DefaultTableModel tableModel;
	DataBase db=new DataBase();
	private String num;
	private String name;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public SearchPoject(String Num,String na) {
		num=Num;
		name=na;
		setTitle(na+"的"+"\u8BBA\u6587\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		table = new JTable();
		table.setCellSelectionEnabled(true);

		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		try {
			showData();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void showData() throws SQLException{
		col=new Vector();
		row=new Vector();
		
		col.addElement("项目号");
		col.addElement("项目名称");
		col.addElement("鉴定结论");
		col.addElement("获奖情况");
		col.addElement("个人排名");
		String sql="select Project.项目号,项目名称,鉴定结论,获奖情况,个人排名 from JoinProject,Project where Number='"+num+"' and JoinProject.项目号=Project.项目号";
		ResultSet rs=db.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		while(rs.next()){
			Vector r=new Vector();
			for(int i=1;i<=rsmd.getColumnCount();i++)
			     r.addElement(rs.getString(i).trim());
			row.addElement(r);
		}
		tableModel=new DefaultTableModel(row,col);
		table.setModel(tableModel);
		table.repaint();
		table.updateUI();
		table.setSurrendersFocusOnKeystroke(true);
		db.closeAll();
	}

}
