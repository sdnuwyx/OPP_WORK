package Delete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class teaDelete implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("ת����ʦ��Ϣɾ��")) {
			final JFrame framestaff = new JFrame("ת����ʦ��Ϣɾ��");
			framestaff.setBounds(200, 100, 500, 500);
             new Homedelete_tea();
      }
	}

}
