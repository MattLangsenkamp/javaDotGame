import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



public final class newButtonHoriz extends JButton {
	
	public static boolean flagged = false;
	
	public newButtonHoriz () {
		this.setPreferredSize(new Dimension(50,15));
		this.setBackground(Color.gray);
		this.setVisible(true);
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
		    {
		    	setBackground(Color.BLACK);
		    	flagged = true;
		    }
		});
	}
	public static boolean hasBeenFlagged() {
		return flagged;
	}
}
