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


public class scientInfor implements ActionListener{
 private Object System;

public  void actionPerformed(ActionEvent e) {
	 if(e.getActionCommand().equals("������Ϣ���")) {
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
			 rs=st.executeQuery("select ��ʦ��� from ������Ϣ");
			 int count=0;
			 while(rs.next()) {count++;}
			 Object[][]obj=new Object[count][4];
			 rs=st.executeQuery("select * from ������Ϣ");
			 int i=0;
			 while(rs.next()) {
				 obj[i][0]=rs.getObject(1);
				 obj[i][1]=rs.getObject(2);
				 obj[i][2]=rs.getObject(3);
				 obj[i][3]=rs.getObject(4);
				 i++;
			 }
			 
			 final JFrame f=new JFrame("������Ϣ���");
			 String[]Names= {"��ʦ���","ר�����ı��","�о�����","�о����"};
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
			
			 
			 f.setBounds(300, 200, 800, 200);
			 f.setUndecorated(true);
			 f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
			 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			 f.setVisible(true);
			 
				 
			 
		 }catch(SQLException e1) {
			java.lang .System.out.println("�쳣"+e1);
			 
		 }finally {
			 jdbcUtil.close(rs,st,conn);
		 }
		 
				 
	 }}}