import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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


public final class dotMainView extends JFrame{
	
	private final JTextArea playerOneName, playerTwoName, playerOneScore, playerTwoScore;
	
	private final JButton endEarly;
	
	private static dotController controll;
	
	public dotMainView(){
		super("main game");
		
		this.playerOneName = new JTextArea("Player one name");
		playerOneName.setPreferredSize(new Dimension(300,50));
		this.playerTwoName = new JTextArea("Player two name");
		playerTwoName.setPreferredSize(new Dimension(300,50));
		this.playerOneScore = new JTextArea("Player one score");
		playerOneScore.setPreferredSize(new Dimension(50,50));
		playerOneScore.setEditable(false);
		this.playerTwoScore = new JTextArea("Player two score");
		playerTwoScore.setPreferredSize(new Dimension(50,50));
		playerTwoScore.setEditable(false);
		this.endEarly = new JButton("End early");
		
		JPanel playerGridOne = new JPanel(new FlowLayout());
		JPanel playerGridTwo = new JPanel(new FlowLayout());
		JPanel boardFlow = new JPanel(new FlowLayout());
		JPanel buttonFlow = new JPanel(new FlowLayout());
		
		playerGridOne.add(playerOneName);
		playerGridOne.add(playerOneScore);
		
		playerGridTwo.add(playerTwoName);
		playerGridTwo.add(playerTwoScore);
		
		JPanel board = new JPanel();
		board.setPreferredSize(new Dimension(400,400));
		board.setBackground(new Color(3));
		JPanel container = new JPanel();
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setAlignmentX(CENTER_ALIGNMENT);
		
		container.add(playerGridOne);
		
		container.add(playerGridTwo);
		container.add(Box.createRigidArea(new Dimension(0, 5)));
		boardFlow.add(board);
		container.add(boardFlow);
		container.add(Box.createRigidArea(new Dimension(0, 5)));
		buttonFlow.add(endEarly);
		container.add(buttonFlow);
		
		add(container);
		setSize(700,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void registerController(dotController dot)
	{
		controll = dot;
	}
}