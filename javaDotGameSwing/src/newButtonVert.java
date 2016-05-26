import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public final class newButtonVert extends JButton {
	
	public static boolean flagged = false;
	
	public newButtonVert () {
		setSize(5,30);
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