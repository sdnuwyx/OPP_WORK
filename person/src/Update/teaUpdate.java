package Update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class teaUpdate implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("教师教学信息修改")) {
			final JFrame framestaff = new JFrame("教师教学信息修改");
			framestaff.setBounds(200, 100, 500, 500);
			new teahome();

		}

	}
}