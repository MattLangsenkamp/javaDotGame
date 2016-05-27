
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;


public final class JTextAreaCustom extends JTextArea {
	
	
	public JTextAreaCustom() {
		this.setPreferredSize(new Dimension(50,50));
		this.setEditable(false);
		//this.setBackground(Color.BLACK);
		this.setVisible(true);
		
	}
}