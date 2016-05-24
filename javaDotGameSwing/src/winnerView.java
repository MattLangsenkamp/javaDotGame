import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;


public final class winnerView extends JFrame{
	
	private static dotController1 controll;
	
	JTextArea winnerText = new JTextArea();
	
	public winnerView() {
		
		super("Winner winner chicken dinner!!!!");
		String winText = "";
		
		winnerText.setEditable(false);
		winnerText.setPreferredSize(new Dimension(200,50));
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void registerController(dotController1 dot)
	{
		controll = dot;
	}
}