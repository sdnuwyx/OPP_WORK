package Delete;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class clear_tea {
	deletetea_chaxun xx ;

    

	 public  clear_tea( int i) {
			// TODO Auto-generated constructor stub
			xx=new deletetea_chaxun();
	        
	        if(i==-1){
	            JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ������");
	            return;  }   
	            Connection con=null;
	              PreparedStatement sql=null;
	                ResultSet rs=null;
	                Statement sm=null;
	             
	            String sr=(String) xx.getValueAt(i,0);
	            try{
	                 
	                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                   con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=���¹���ϵͳ","sa","123456");
	                  // ������ѯ����   
	               
	                   String  cl = "delete  from ת����ʦ   where ���=?"; 
	                   

	             
	                 sql=con.prepareStatement(cl);
	                // int ii=Integer.valueOf(sr).intValue();
	                sql.setString(1,sr);
	                 sql.executeUpdate();

	                 
	            }
	            catch(Exception e){
	                e.printStackTrace();
	                 
	            }

	             finally
	             {
	                 try {
	                     if(rs!=null)
	                     {
	                         rs.close();
	                     }
	                     if(sql!=null)
	                     {
	                         sql.close();
	                     }
	                     if(con!=null)
	                     {
	                         con.close();
	                     }
	                      
	                 } catch (Exception e3){}        
	             } 
	             
	             
	             
	    }
			}
		
