import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class DotInfoForm extends JFrame {
	
	
	private dotControllerInfoForm controller;
		
	
	/**
     * State variable to keep track of which event happened last; needed to
     * prepare for digit to be added to bottom operand.
     */
      
	private final JTextArea playerOneName, playerTwoName, playerOneChar, playerTwoChar, boardSizeHeight, boardSizeWidth;
	
	private final JButton next;
	
	private final int textHeight = 5, textWidth = 10;
	
	public DotInfoForm()
	{
		super("Entry field");
		this.setVisible(true);
		this.playerOneName = new JTextArea("Player One Name");
		playerOneName.setPreferredSize(new Dimension(300,50));
		this.playerOneChar = new JTextArea("H");
		playerOneChar.setPreferredSize(new Dimension(50,50));
		this.playerTwoName = new JTextArea("Player Two Name");
		playerTwoName.setPreferredSize(new Dimension(300,50));
		this.playerTwoChar = new JTextArea("C");
		playerTwoChar.setPreferredSize(new Dimension(50,50));
		this.boardSizeHeight = new JTextArea("7");
		boardSizeHeight.setPreferredSize(new Dimension(50,50));
		this.boardSizeWidth = new JTextArea("9");
		boardSizeWidth.setPreferredSize(new Dimension(50,50));
		this.next = new JButton("next");
		next.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	
		    String height = boardSizeHeight.getText();
		    String width = boardSizeWidth.getText();
		    int hInt = Integer.parseInt(height);
		    int wInt = Integer.parseInt(width);
		    		
		    if(!playerOneName.getText().equals(playerTwoName.getText()))
		    {
		    	if(playerOneChar.getText().length()==1 && playerTwoChar.getText().length()==1)
		    	{
		    		if(!playerOneChar.getText().equals(playerTwoChar.getText()))
		    		{
		    			if(hInt > 2 && hInt <19 && wInt >2 && wInt < 19)
		    			{
		    				
		    				
		    				controller.updateNameOne(playerOneName.getText());
		    				controller.updateNameTwo(playerTwoName.getText());
		    				controller.updateCharOne(playerOneChar.getText());
		    				controller.updateCharTwo(playerTwoChar.getText());
		    				controller.updateBoardSizeHeight(hInt);
		    				controller.updateBoardSizeWidth(wInt);
		    				
		    				dotMainView game = new dotMainView();
		    			    game.setVisible(true);
		    			    playerOneName.setEditable(false);
		    				playerOneChar.setEditable(false);
		    				playerTwoName.setEditable(false);
		    				playerTwoChar.setEditable(false);
		    				boardSizeHeight.setEditable(false);
		    				boardSizeWidth.setEditable(false);
		    				next.setEnabled(false);
		    				
		    				dotMainView.registerController(controller);
		    			}
		    			else
		    			{
		    				JOptionPane.showMessageDialog(null,"Board size not valid");
		    				  // bounds not correct
		    			}
		    		}
		    		else
		    		{
		    			JOptionPane.showMessageDialog(null,"Player characters not different");
		    			 // chars the same
		    		}
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(null,"Player characters cannot be that large");
		    		 // chars too big
		    	}
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(null,"Player names are the same");
		    	// names the same
		    }
		  }
	});
				
		JPanel playerOne = new JPanel(new FlowLayout());
		JPanel playerTwo = new JPanel(new FlowLayout());
		JPanel boardSize = new JPanel(new FlowLayout());
		JPanel button = new JPanel(new FlowLayout());
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setAlignmentX(CENTER_ALIGNMENT);
		
		playerOne.add(playerOneName);
		playerOne.add(playerOneChar);
		
		playerTwo.add(playerTwoName);
		playerTwo.add(playerTwoChar);
		
		boardSize.add(boardSizeHeight);
		boardSize.add(boardSizeWidth);
		
		container.add(playerOne);
		container.add(playerTwo);
		container.add(boardSize);
		button.add(next);
		container.add(button);
		add(container);
		setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	public void registerController(dotControllerInfoForm dot)
	{
		this.controller = dot;
	}
	
	}