package com.lut.test;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JDB extends JFrame{
// 定义组件
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
// 构造方法
public JDB(){
// 窗体的相关属性的定义
super("JTable数据绑定示例");
this.setSize(330,400);
this.setLayout(null);
this.setLocation(100,50);
// 创建组件
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,300,270);
this.btnShow = new JButton("显示数据");
this.btnShow.setBounds(10,10,300,30);
// 给按钮注册监听
this.btnShow.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
btnShow_ActionPerformed(ae);
}
});
// 将组件加入到窗体中
add(this.scpDemo);
add(this.btnShow);
// 显示窗体
this.setVisible(true);
}
// 点击按钮时的事件处理
public void btnShow_ActionPerformed(ActionEvent ae){
// 以下是连接数据源和显示数据的具体处理方法，请注意下
	DataBase db=new DataBase();
	if(ae.getSource() instanceof JButton){

String sql = "select * from Student"; 

try{
ResultSet rs = db.executeQuery(sql);
// 计算有多少条记录
int count = 0;
while(rs.next()){
count++;
}
rs = db.executeQuery(sql);
// 将查询获得的记录数据，转换成适合生成JTable的数据形式
Object[][] info = new Object[count][4];
count = 0;

while(rs.next()){
info[count][0] = rs.getString("Number");
info[count][1] = rs.getString("Name");
info[count][2] = rs.getString("Sex");//Integer.valueOf( rs.getInt("age") );
info[count][3] = Integer.valueOf( rs.getInt("Age") );
info[count][4] = rs.getString("College");
count++;
// 定义表头
String[] title = {"学号","姓名","性别","年龄","学院"};
// 创建JTable
this.tabDemo = new JTable(info,title);
// 显示表头
this.jth = this.tabDemo.getTableHeader();
// 将JTable加入到带滚动条的面板中
this.scpDemo.getViewport().add(tabDemo); 

}
}catch(SQLException e){
	System.out.println(e);
}
}
}
public static void main(String[] args){
new JDB();
}
}
