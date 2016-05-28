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
	
	private static dotControllerInfoForm controll;
	
	JTextArea winnerText = new JTextArea();
	
	public winnerView() {
		
		
		super("Winner winner chicken dinner!!!!");
		this.setVisible(true);
		String winText = "";
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
		    {
		    	System.exit(0);
		    }
		});
		
		int p1Score = Integer.parseInt(controll.getPlayerOneScore());
		int p2Score = Integer.parseInt(controll.getPlayerTwoScore());
		
		if(p1Score > p2Score)
		{
			winText = "Player two wins with a score of " + p1Score + "!";
		}
		else if(p2Score>p1Score)
		{
			winText = "Player two wins with a score of " + p2Score + "!";
		}
		else
		{
			winText = "It's a tie!";
		}
		
		winnerText.setEditable(false);
		winnerText.setPreferredSize(new Dimension(200,50));
		winnerText.setText(winText);
		
		JPanel textFlow = new JPanel(new FlowLayout());
		textFlow.add(winnerText);
		JPanel buttonFlow = new JPanel(new FlowLayout());
		buttonFlow.add(ok);		
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setAlignmentX(CENTER_ALIGNMENT);
		
		container.add(textFlow);
		container.add(Box.createRigidArea(new Dimension(0, 5)));
		container.add(buttonFlow);
		
		add(container);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void registerController(dotControllerInfoForm dot)
	{
		controll = dot;
	}
}