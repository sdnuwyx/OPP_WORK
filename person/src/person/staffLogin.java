package person;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class staffLogin implements ActionListener {

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("��ʦ��Ϣ¼��"))
		{
			final JFrame framestaff = new JFrame("��ʦ��Ϣ¼��");
			framestaff.setBounds(200,100,500,500);
			JLabel jl1= new JLabel("���");
			jl1.setToolTipText("����:1401");
			final JTextField jt1 = new JTextField(8);
			JLabel jl2 = new JLabel("����");
			final JTextField jt2 = new JTextField(6);
			JLabel jl3 = new JLabel("�Ա�");
			final JTextField jt3 = new JTextField(5);
			JLabel jl4 = new JLabel("ѧ��");
			jl1.setToolTipText("��ר�����ƣ��о���...");
			final JTextField jt4 = new JTextField(10);
			JLabel jl5 = new JLabel("ְ��");
			final JTextField jt5 = new JTextField(10);
			JLabel jl6 = new JLabel("ְ��");
			final JTextField jt6 = new JTextField(10);
			JLabel jl7 = new JLabel("��ҵԺУ");
		//	jl1.setToolTipText("�����...");
			final JTextField jt7 = new JTextField(5);
			JLabel jl8 = new JLabel("����");
			final JTextField jt8 = new JTextField(10);
			JLabel jl9 = new JLabel("��ְ��Ϣ");
			final JTextField jt9 = new JTextField(10);
			JLabel jl10 = new JLabel("���ű��");
			final JTextField jt10 = new JTextField(30);
			
			JButton jb1=new JButton("����");
			jb1.addActionListener(new ActionListener()
			{
				
				public void actionPerformed (ActionEvent e)
				{
					if(e.getActionCommand().equals("����"))
					{
						String c1 = jt1.getText().toString();
						if(c1.equals(""))
						{
							javax.swing.JOptionPane.showMessageDialog(null, "�������ţ�");
						}else if(jdbcUtil.samenumber(c1,"��ʦ��Ϣ"))
						{
							javax.swing.JOptionPane.showMessageDialog(null,"�˱���Ѿ����ڣ�");
						}
						else if(jdbcUtil.nunnumber(c1,"��ʦ��Ϣ"))
						{
							String c2=jt2.getText().toString();
						//	System.out.println(c2);
							String c3=jt3.getText().toString();
							String c4=jt4.getText().toString();
							String c5=jt5.getText().toString();
							String c6=jt6.getText().toString();
							String c7=jt7.getText().toString();
							String c8=jt8.getText().toString();
							String c9=jt9.getText().toString();
							String c10=jt10.getText().toString();
							Connection conn=null;
							java.sql.Statement st=null;
							ResultSet rs=null;
							try{
								conn=jdbcUtil.getSQLConn();
								conn.setAutoCommit(true);
								System.out.println("�Ѿ����ӵ����ݿ�...");
								
								String sql= "insert into ��ʦ��Ϣ(���,����,�Ա�,ѧ��,ְ��,ְ��,��ҵԺУ,����,��ְ��Ϣ,���ű��)values('"+c1+"','"+c2+"','"+c3+"','"+c4+"','"+c5+"','"+c6+"','"+c7+"','"+c8+"','"+c9+"','"+c10+"')";
								//System.out.println(sql);
								st=conn.createStatement();
								/*sql.append(c1+"','");
								sql.append(c2+"','");
								sql.append(c3+"','");
								sql.append(c4+"','");
								sql.append(c5+"','");
								sql.append(c6+"','");
								sql.append(c7+"','");
								sql.append(c8+"','");
								sql.append(c9+"','");
								sql.append(c10+"','");*/
								st.executeUpdate(sql);
								javax.swing.JOptionPane.showMessageDialog(null, "¼��ɹ�����");
							}catch(Exception e2)
							{
								e2.printStackTrace();
							}
							finally{
								jdbcUtil.close(rs,st,conn);
							}
						
						}
					}
				}
			});
			JPanel jp=new JPanel();
			
			JPanel jp1=new JPanel();
			JPanel jp2=new JPanel();
			JPanel jp3=new JPanel();
			JPanel jp4=new JPanel();
			JPanel jp5=new JPanel();
			jp1.add(jl1);
			jp1.add(jt1);
			
			jp2.add(jl2);
			jp2.add(jt2);
			jp2.add(jl3);
			jp2.add(jt3);
			jp2.add(jl4);
			jp2.add(jt4);
			
			jp3.add(jl5);
			jp3.add(jt5);
			jp3.add(jl6);
			jp3.add(jt6);
			
			jp4.add(jl7);
			jp4.add(jt7);
			jp4.add(jl8);
			jp4.add(jt8);
			jp4.add(jl9);
			jp4.add(jt9);
			
			jp5.add(jl10);
			jp5.add(jt10);
			
			jp.add(jb1);
			
			framestaff.setUndecorated(true);
			framestaff.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);			
			
			JPanel imagePanel = new JPanel();
			ImageIcon background;
			BufferedImage image=null;
			String path="D:\\Pictures\\1-main-image";
			background = new ImageIcon(path);
			JLabel label= new JLabel(background);
			label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
			imagePanel =(JPanel)framestaff.getContentPane();
			imagePanel.setOpaque(false);
			
			imagePanel.setLayout(new GridLayout(7,3));
			imagePanel.add(jp1);
			imagePanel.add(jp2);
			imagePanel.add(jp3);
			imagePanel.add(jp4);
			imagePanel.add(jp5);
			
			jp1.setOpaque(false);
			jp2.setOpaque(false);
			jp3.setOpaque(false);
			jp4.setOpaque(false);
			jp5.setOpaque(false);
			jp.setOpaque(false);
			
			framestaff.getLayeredPane().setLayout(null);
			framestaff.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
			//framestaff.setSize(background.getIconWidth(),background.getIconHeight());
			//framestaff.setVisible(true);  
			framestaff.add(jp,BorderLayout.SOUTH);
			
			framestaff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			framestaff.setVisible(true);
			
		}
	}
			

			
}