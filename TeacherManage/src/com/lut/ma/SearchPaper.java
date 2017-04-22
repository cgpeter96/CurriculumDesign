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

public class SearchPaper extends JFrame {

	private JPanel contentPane;
	private Vector row;
	private Vector col;
	private DefaultTableModel tableModel;
	DataBase db=new DataBase();
	private String num;
	private String name;
	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public SearchPaper(String Num,String na) {
		
		num=Num;
		name=na;
		setTitle(name+"的"+"\u8BBA\u6587\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table=new JTable();
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
		
		col.addElement("论文号");
		col.addElement("论文名称");
		col.addElement("期刊会议名称");
		col.addElement("索引情况");
		col.addElement("个人排名");
		String sql="select Paper.论文号,论文名称,期刊会议名称,索引情况,个人排名 from Paper,SendPaper where Number='"+num+"' and SendPaper.论文号=Paper.论文号";
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
