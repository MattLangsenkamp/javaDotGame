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
	
	private final JTextArea playerOneName, playerTwoName, playerOneScore, playerTwoScore, turnText;
	
	private final JButton endEarly;
	
	private static dotControllerInfoForm controll;
	
	public dotMainView(){
		super("main game");
		String nameOne = controll.getPlayerOneName();
		String nameTwo = dotControllerInfoForm.getPlayerTwoName();
		
		this.playerOneName = new JTextArea(nameOne);
		playerOneName.setPreferredSize(new Dimension(300,50));
		playerOneName.setEditable(false);
		
		this.playerTwoName = new JTextArea(nameTwo);
		playerTwoName.setPreferredSize(new Dimension(300,50));
		playerTwoName.setEditable(false);
		
		this.playerOneScore = new JTextArea("0");
		playerOneScore.setPreferredSize(new Dimension(50,50));
		playerOneScore.setEditable(false);
		
		this.playerTwoScore = new JTextArea("0");
		
		playerTwoScore.setPreferredSize(new Dimension(50,50));
		playerTwoScore.setEditable(false);
		
		
		this.turnText = new JTextArea(controll.getPlayerOneName());
		turnText.setPreferredSize(new Dimension(75,50));
		turnText.setEditable(false);
		
		JPanel board = new JPanel();
		board.setPreferredSize(new Dimension(400,400));
		board.setBackground(new Color(3));
		
		this.endEarly = new JButton("End early");
		endEarly.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	winnerView won = new winnerView();
		    	won.registerController(controll);
		    }
		});
		
		JPanel playerGridOne = new JPanel(new FlowLayout());
		JPanel playerGridTwo = new JPanel(new FlowLayout());
		JPanel turnFlow = new JPanel(new FlowLayout());
		JPanel boardFlow = new JPanel(new FlowLayout());
		JPanel buttonFlow = new JPanel(new FlowLayout());
		
		playerGridOne.add(playerOneName);
		playerGridOne.add(playerOneScore);
		
		playerGridTwo.add(playerTwoName);
		playerGridTwo.add(playerTwoScore);
		
		turnFlow.add(turnText);
		boardFlow.add(board);
		
		JPanel container = new JPanel();
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setAlignmentX(CENTER_ALIGNMENT);
		
		container.add(playerGridOne);
		container.add(playerGridTwo);
		container.add(Box.createRigidArea(new Dimension(0, 5)));
		container.add(turnFlow);
		container.add(Box.createRigidArea(new Dimension(0, 5)));
		container.add(boardFlow);
		container.add(Box.createRigidArea(new Dimension(0, 5)));
		buttonFlow.add(endEarly);
		container.add(buttonFlow);
		
		add(container);
		setSize(700,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void updateScoreOne(String t){
		playerOneScore.setText(t);
		
	}
	public void updateScoreTwo(String t){
		playerTwoScore.setText(t);
	}
	
	public void updateTurn (boolean isPlayerOneTurn)
	{
		
	}
	
	public static void registerController(dotControllerInfoForm dot)
	{
		controll = dot;
	}
}