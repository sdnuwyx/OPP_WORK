package person;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class staffInfor implements ActionListener{
 private Object System;

public  void actionPerformed(ActionEvent e) {
	 if(e.getActionCommand().equals("��ʦ��Ϣ���")) {
		 Connection conn=null;
		 java.sql.Statement st=null;
		 ResultSet rs=null;
		 TableModel tablemodel=null;
		 JTable table=new JTable(tablemodel);
		 DefaultTableModel defaultTableModel=null;
		 try {
			 conn=jdbcUtil.getSQLConn();
			 conn.setAutoCommit(true);
			 st=conn.createStatement();
			 //��ȡ�����Ԫ��1
			 rs=st.executeQuery("select ���  from ��ʦ��Ϣ");
			 int count=0;
			 while(rs.next()) {count++;}
			 Object[][]obj=new Object[count][10];
			 rs=st.executeQuery("select * from ��ʦ��Ϣ");
			 int i=0;
			 while(rs.next()) {
				 obj[i][0]=rs.getObject(1);
				 obj[i][1]=rs.getObject(2);
				 obj[i][2]=rs.getObject(3);
				 obj[i][3]=rs.getObject(4);
				 obj[i][4]=rs.getObject(5);
				 obj[i][5]=rs.getObject(6);
				 obj[i][6]=rs.getObject(7);
				 obj[i][7]=rs.getObject(8);
				 obj[i][8]=rs.getObject(9);
				 obj[i][9]=rs.getObject(10);
				 i++;
			 }
			 
			 final JFrame f=new JFrame("��ʦ��Ϣ���");
			 String[]Names= {"���","����","�Ա�","ѧ��","ְ��","ְ��","��ҵԺУ","����","��ְ��Ϣ","���ű��"};
			defaultTableModel=new DefaultTableModel(obj,Names);
			 
			 table =new JTable(defaultTableModel);
			 
			 table.setPreferredScrollableViewportSize(new Dimension(400,800));
			 JScrollPane scrollPane=new JScrollPane(table);
			 f.add(scrollPane,BorderLayout.CENTER);
			 table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			 TableColumn column=null;
			 column=table.getColumnModel().getColumn(0);
			 column.setPreferredWidth(60);
			 column=table.getColumnModel().getColumn(1);
			 column.setPreferredWidth(60);
			 column=table.getColumnModel().getColumn(2);
			 column.setPreferredWidth(60);
			 column=table.getColumnModel().getColumn(3);
			 column.setPreferredWidth(80);
			 column=table.getColumnModel().getColumn(4);
			 column.setPreferredWidth(80);
			 column=table.getColumnModel().getColumn(5);
			 column.setPreferredWidth(80);
			 column=table.getColumnModel().getColumn(6);
			 column.setPreferredWidth(60);
			 column=table.getColumnModel().getColumn(7);
			 column.setPreferredWidth(60);
			 column=table.getColumnModel().getColumn(8);
			 column.setPreferredWidth(60);
			 column=table.getColumnModel().getColumn(9);
			 column.setPreferredWidth(150);
			 
			 f.setBounds(300, 200, 800, 200);
			 f.setUndecorated(true);
			 f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
			 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			 f.setVisible(true);
			
				 
			 
		 }catch(SQLException e1) { 
			 java.lang.System.out.println("�쳣"+e1);
		 }finally {
			 jdbcUtil.close(rs,st,conn);
		 }
		 
				 
	 }}
}
	
	
	
	
	
	
	
	
	
	
	
	
	