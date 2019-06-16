package person;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import Delete.scientDelete;
import Delete.staffDelete;
import Delete.teaDelete;
import Infor.scientInfor;
import Infor.staffInfor;
import Infor.teaInfor;
import Inquire.scientInquire;
import Inquire.staffInquire;
import Inquire.teaInquire;
import Login.scientLogIn;
import Login.staffLogin;
import Login.teaLogIn;
import Statis.staticKc;
import Statis.statisJx;
import Statis.statisKc;
import Statis.statisKy;
import Statis.statisYg;
import Update.scientUpdate;
import Update.staffUpdate;
import Update.teaUpdate;

public class mainFrame {

	static JFrame frame = new JFrame();
	static Container content = frame.getContentPane();
	JMenuBar Barmenu = new JMenuBar();
	JMenu browse = new JMenu("���");
	JMenu login = new JMenu("¼��");
	JMenu update = new JMenu("�޸�");
	JMenu inquire = new JMenu("��ѯ");
	JMenu delete = new JMenu("ɾ��");
	JMenu statistic = new JMenu("ͳ��");

	public mainFrame() {
		// TODO Auto-generated method stub
		JMenuItem staff = new JMenuItem("��ʦ��Ϣ���");
		staff.addActionListener(new staffInfor());
		JMenuItem teacher = new JMenuItem("��ʦ��ѧ��Ϣ���");
		teacher.addActionListener(new teaInfor());
		JMenuItem scientResearch = new JMenuItem("������Ϣ���");
		scientResearch.addActionListener(new scientInfor());
		browse.add(staff);
		browse.add(teacher);
		browse.add(scientResearch);

		// ��Ϣ¼��

		staff = new JMenuItem("��ʦ��Ϣ¼��");
		teacher = new JMenuItem("��ʦ��ѧ��Ϣ¼��");
		scientResearch = new JMenuItem("������Ϣ¼��");

		staff.addActionListener(new staffLogin());
		teacher.addActionListener(new teaLogIn());
		scientResearch.addActionListener(new scientLogIn());
		login.add(staff);
		login.add(teacher);
		login.add(scientResearch);

		// ��Ϣ�޸�

		staff = new JMenuItem("��ʦ��Ϣ�޸�");
		teacher = new JMenuItem("��ʦ��ѧ��Ϣ�޸�");
		scientResearch = new JMenuItem("������Ϣ�޸�");

		staff.addActionListener(new staffUpdate());
		teacher.addActionListener(new teaUpdate());
		scientResearch.addActionListener(new scientUpdate());

		update.add(staff);
		update.add(teacher);
		update.add(scientResearch);

		// ��Ϣ��ѯ

		staff = new JMenuItem("��ʦ��Ϣ��ѯ");
		teacher = new JMenuItem("��ʦ��ѧ��Ϣ��ѯ");
		scientResearch = new JMenuItem("������Ϣ��ѯ");

		staff.addActionListener(new staffInquire());
		teacher.addActionListener(new teaInquire());
		scientResearch.addActionListener(new scientInquire());

		inquire.add(staff);
		inquire.add(teacher);
		inquire.add(scientResearch);

		// ��Ϣɾ��

		teacher = new JMenuItem("ת����ʦ��Ϣɾ��");
		staff = new JMenuItem("��ʦ��Ϣɾ��");
		scientResearch = new JMenuItem("������Ϣɾ��");
		delete.add(teacher);
		delete.add(staff);
		delete.add(scientResearch);

		teacher.addActionListener(new teaDelete());
		staff.addActionListener(new staffDelete());
		scientResearch.addActionListener(new scientDelete());

		// ��Ϣͳ��

		JMenuItem ky = new JMenuItem("���з���");
		JMenuItem kc = new JMenuItem("�γ�");
		JMenuItem yg = new JMenuItem("Ա����Ϣ");
		JMenuItem jx = new JMenuItem("��ʦ��ѧ��Ϣ");
		statistic.add(ky);
		statistic.add(kc);
		statistic.add(yg);
		statistic.add(jx);
		// statistic.add(retiree);

		ky.addActionListener(new statisKy());
		kc.addActionListener(new statisKc());
		yg.addActionListener(new statisYg());
		jx.addActionListener(new statisJx());
		

		Barmenu.add(browse);
		Barmenu.add(login);
		Barmenu.add(update);
		Barmenu.add(inquire);
		Barmenu.add(delete);
		Barmenu.add(statistic);

		content.add(Barmenu, BorderLayout.NORTH);
		JLabel title = new JLabel("��ӭʹ�����¹���ϵͳ");

		title.setFont(new java.awt.Font("dialog", 1, 45));
		title.setForeground(Color.pink);
		title.setOpaque(false);

		content.add(title, BorderLayout.CENTER);

		frame.setBounds(200, 100, 500, 500);
		frame.setTitle("������Ϣ����");
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		
		
	        ImageIcon image = new ImageIcon("D:\\Pictures\\1-main-image.jpg");
	        JLabel imagelabel = new JLabel(image);
	        imagelabel.setBounds(0, 0, 500, 500);
	        frame.getLayeredPane().add(imagelabel, new Integer(Integer.MIN_VALUE));
	        JPanel panel = (JPanel) frame.getContentPane();// ��崰��
	        panel.setOpaque(false);
	        frame.setBounds(0, 0, 500, 500);
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel imagePanle = new JPanel();
		JLabel lable = new JLabel("background");
		imagePanle = (JPanel) frame.getContentPane();
		imagePanle.setOpaque(false);
		frame.getLayeredPane().setLayout(null);
		frame.getLayeredPane().add(lable, new Integer(Integer.MIN_VALUE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
