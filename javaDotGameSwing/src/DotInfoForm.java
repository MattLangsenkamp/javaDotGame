import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;






public class DotInfoForm extends JFrame {

	
	
	
	private dotController controller;
	
	
	
	/**
     * State variable to keep track of which event happened last; needed to
     * prepare for digit to be added to bottom operand.
     */
    
    
	private final JTextField playerOneName, playerTwoName, playerOneChar, playerTwoChar, boardSizeHeight, boardSizeWidth;
	
	private final JButton next;
	
	private final int textHeight = 5, textWidth = 10;
	
	public DotInfoForm()
	{
		super("Entry field");
		this.setVisible(true);
		this.playerOneName = new JTextField("Player One Name");
		this.playerOneChar = new JTextField("Player One Char");
		this.playerTwoName = new JTextField("Player Two Name");
		this.playerTwoChar = new JTextField("Player Two Char");
		this.boardSizeHeight = new JTextField("Board Size Height");
		this.boardSizeWidth = new JTextField("Board Size Width");
		this.next = new JButton("next");
		
		
		
		JPanel playerOne = new JPanel(new GridLayout(
                1, 2));
		JPanel playerTwo = new JPanel(new GridLayout(
                1, 2));
		JPanel boardSize = new JPanel(new GridLayout(
                1, 2));
		JPanel container = new JPanel(new GridLayout(
                4, 1));
		
		playerOne.add(playerOneName);
		playerOne.add(playerOneChar);
		
		playerTwo.add(playerTwoName);
		playerTwo.add(playerTwoChar);
		
		boardSize.add(boardSizeHeight);
		boardSize.add(boardSizeWidth);
		
		container.add(playerOne);
		container.add(playerTwo);
		container.add(boardSize);
		container.add(next);
		setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
	}
	
	public void registerController(dotController dot)
	{
		this.controller = dot;
	}
	
	}