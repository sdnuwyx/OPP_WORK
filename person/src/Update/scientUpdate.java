package Update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class scientUpdate implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("������Ϣ�޸�")) {
			final JFrame framestaff = new JFrame("������Ϣ�޸�");
			framestaff.setBounds(200, 100, 500, 500);
			new scienthome();

		}
	}

}
