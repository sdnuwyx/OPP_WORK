package Update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class teaUpdate implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("��ʦ��ѧ��Ϣ�޸�")) {
			final JFrame framestaff = new JFrame("��ʦ��ѧ��Ϣ�޸�");
			framestaff.setBounds(200, 100, 500, 500);
			new teahome();

		}

	}
}