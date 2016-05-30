import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;


public final class dotMainView extends JFrame{
	
	private JTextArea playerOneName,playerTwoName;


	static Font newFont = new Font(null, Font.PLAIN, 18);
	static Font newFont2 = new Font(null, Font.PLAIN, 38);
	private static JTextArea playerOneScore; 
	private static JTextArea playerTwoScore;

	private static JTextArea turnText;
	
	public static JComponent[][] array; 
	//= boardBuilder(controll.getRows(),controll.getColumns());;
	
	private final JButton endEarly;
	
	public static dotControllerInfoForm controll;
	public static dotControllerInfoForm booger;
	public static int height = 24;
	public static int flagged = 0;
	
	public dotMainView(){
		super("main game");
		String nameOne = controll.getPlayerOneName();
		String nameTwo = controll.getPlayerTwoName();
		
		this.playerOneName = new JTextArea(nameOne+"'s score:");
		int numbOne = spaceLength(nameOne+"'s score:");
		playerOneName.setPreferredSize(new Dimension(numbOne,height));
		playerOneName.setEditable(false);
		playerOneName.setFont(newFont);
		
		this.playerTwoName = new JTextArea(nameTwo+"'s score:");
		int numbTwo = spaceLength(nameTwo+"'s score:");
		playerTwoName.setPreferredSize(new Dimension(numbTwo,height));
		playerTwoName.setEditable(false);
		playerTwoName.setFont(newFont);
		
		this.playerOneScore = new JTextArea(controll.getPlayerOneScore());
		playerOneScore.setPreferredSize(new Dimension(50,height));
		playerOneScore.setEditable(false);
		playerOneScore.setFont(newFont);
		
		this.playerTwoScore = new JTextArea(controll.getPlayerTwoScore());
		
		playerTwoScore.setPreferredSize(new Dimension(50,height));
		playerTwoScore.setEditable(false);
		playerTwoScore.setFont(newFont);
		
		
		this.turnText = new JTextArea(controll.getPlayerOneName()+"'s turn");
		int numbText = spaceLength(controll.getPlayerOneName()+"'s turn");
		turnText.setPreferredSize(new Dimension(numbText,height));
		turnText.setEditable(false);
		turnText.setFont(newFont);
		
		
		JPanel board = new JPanel();
		int boardWidth = allocateBoardWidth(controll.getColumns());
		int boardHeight = allocateBoardHeight(controll.getRows());
		board.setPreferredSize(new Dimension(boardWidth,boardHeight));
		board.setBackground(Color.WHITE);
		
		
		array = boardBuilder(controll.getRows(),controll.getColumns());
		
		
		boardWriter(array,board,controll.getRows(),controll.getColumns());
		
		
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
		buttonFlow.add(endEarly);
		
		// scroll stuff
		JScrollPane scrollable = new JScrollPane();
		scrollable.setPreferredSize(new Dimension(boardWidth,boardHeight));
		scrollable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		scrollable.add(boardFlow);
		
		
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
		
		container.add(buttonFlow);
		
		add(container);
		setSize(boardWidth+60,boardHeight+370);
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
	public int allocateBoardWidth(int columns){
		int pixels = 25;
		for(int i = 0; i<columns;i++){
			pixels = pixels + 75;
		}
		return pixels;
	}
	public int allocateBoardHeight(int rows) {
		int pixels = 25;
		for(int i = 0; i<rows;i++){
			pixels = pixels + 75;
		}
		return pixels;
	}
	public static JComponent[][] boardBuilder(int rows, int columns)
	{
		int realRows = rows*2 +1;
		int realColumns = columns*2 + 1;
		JComponent[][] returnVal = new JComponent[realRows][realColumns];
		for(int i = 0; i<realRows; i++)
		{
			for(int j = 0; j<realColumns; j++)
			{
				if(i%2==0)
				{
					// print horiz lines with blocks
					if(j%2==0)
					{
						// middleButton
						returnVal[i][j] = new ButtonMiddle();
						
					}
					else
					{
						//lines
						newButtonHoriz curH = new newButtonHoriz();
						returnVal[i][j] = curH;
						curH.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e)
						    {
								curH.setBackground(Color.BLACK);
								
								
								avoidInitialization(controll.getRows(),controll.getColumns(),whoChar());
								
								if(controll.isPlayerOneTurn()){
									controll.updateScoreOne(boardScorer(controll.getRows(),controll.getColumns(),whoChar()));
									controll.updatePlayerTurn();
									turnText.setText(controll.getPlayerTwoName()+"'s turn");
									int numbText = spaceLength(controll.getPlayerTwoName()+"'s turn");
									turnText.setPreferredSize(new Dimension(numbText,height));
									
								}
								else
								{
									controll.updateScoreTwo(boardScorer(controll.getRows(),controll.getColumns(),whoChar()));
									controll.updatePlayerTurn();
									turnText.setText(controll.getPlayerOneName()+"'s turn");
									int numbText = spaceLength(controll.getPlayerOneName()+"'s turn");
									turnText.setPreferredSize(new Dimension(numbText,height));
									
								}
								playerOneScore.setText(controll.getPlayerOneScore());
								playerTwoScore.setText(controll.getPlayerTwoScore());
								declareWinner(controll.getRows(),controll.getColumns(),controll.getPlayerChar(controll.getPlayerOneName()),controll.getPlayerChar(controll.getPlayerTwoName()));
						    }						
						});
					}
				}
				else
				{
					// print vert lines with JTextArea
					if(j%2==0)
					{
						// lines 
						newButtonVert curV = new newButtonVert();
						returnVal[i][j] = curV;
						curV.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e)
						    {
								curV.setBackground(Color.BLACK);
								
															
								avoidInitialization(controll.getRows(),controll.getColumns(),whoChar());
								
								if(controll.isPlayerOneTurn()){
									controll.updateScoreOne(boardScorer(controll.getRows(),controll.getColumns(),whoChar()));
									controll.updatePlayerTurn();
									turnText.setText(controll.getPlayerTwoName()+"'s turn");
									int numbText = spaceLength(controll.getPlayerTwoName()+"'s turn");
									turnText.setPreferredSize(new Dimension(numbText,height));
									
								}
								else
								{
									controll.updateScoreTwo(boardScorer(controll.getRows(),controll.getColumns(),whoChar()));
									controll.updatePlayerTurn();
									turnText.setText(controll.getPlayerOneName()+"'s turn");
									int numbText = spaceLength(controll.getPlayerOneName()+"'s turn");
									turnText.setPreferredSize(new Dimension(numbText,height));
								}
								playerOneScore.setText(controll.getPlayerOneScore());
								playerTwoScore.setText(controll.getPlayerTwoScore());
								declareWinner(controll.getRows(),controll.getColumns(),controll.getPlayerChar(controll.getPlayerOneName()),controll.getPlayerChar(controll.getPlayerTwoName()));
						    }
						});
					}
					else
					{
						// custom text area
						returnVal[i][j] = new JTextAreaCustom();
						
					}
				}
			}
		}
		return returnVal;
	}	
	public static void boardWriter(JComponent[][] boardToPrint, JPanel board, int rows, int columns){
		int realRows = rows*2 +1;
		int realColumns = columns*2 + 1;
		for(int i = 0; i<realRows; i++)
		{
			for(int j = 0; j<realColumns; j++)
			{
				board.add(boardToPrint[i][j]);
			}
		}		
	}
	public static void boardChanger(JComponent[][] board, int rows, int columns, String Char)
	{
		newButtonHoriz top;
		newButtonVert left;
		newButtonVert right;
		newButtonHoriz bottom;
		JTextAreaCustom text = new JTextAreaCustom();
		int realRows = rows*2 +1;
		int realColumns = columns*2 + 1;
		for(int i=1; i<realRows-1; i++)
		{
			if (i%2!=0){
				for(int j=1; j<realColumns-1; j++)
				{
					if(j%2!=0)
					{
						top = (newButtonHoriz) board[i-1][j];
						left = (newButtonVert) board[i][j-1];
						right = (newButtonVert) board[i][j+1];
						bottom = (newButtonHoriz) board[i+1][j];
						if((top.getBackground()==Color.BLACK)&&(left.getBackground()==Color.black)&&(right.getBackground()==Color.black&&(bottom.getBackground()==Color.black)))
						{		
							text = ((JTextAreaCustom)board[i][j]);
							
							if(text.getText().equals("")){
								text.setText(Char);
								text.setFont(newFont2);
							}
						}
					}
				}
			}
		}
	}	
	public static int boardScorer(int rows, int columns, String Char)
	{
		int counter = 0;
		JTextAreaCustom text;
		int realRows = rows*2 +1;
		int realColumns = columns*2 + 1;
		for(int i=1; i<realRows-1; i++)
		{
			if (i%2!=0){
				for(int j=1; j<realColumns-1; j++)
				{
					if(j%2!=0)
					{
						text = ((JTextAreaCustom)array[i][j]);
						if(text.getText().equals(Char)){
							counter++;
						}
					}
				}
			}
		}
		return counter;
	}
	public static void declareWinner(int rows, int columns, String char1, String char2) {
		int counter = 0;
		JTextAreaCustom text;
		int realRows = rows*2 +1;
		int realColumns = columns*2 + 1;
		for(int i=1; i<realRows-1; i++)
		{
			if (i%2!=0){
				for(int j=1; j<realColumns-1; j++)
				{
					if(j%2!=0)
					{
						text = ((JTextAreaCustom)array[i][j]);
						if(text.getText().equals(char1)||text.getText().equals(char2)){
							counter++;
						}
					}
				}
			}
		}
		if(counter==(rows*columns)){
			winnerView won = new winnerView();
	    	won.registerController(controll);
		}
	}
	public static void registerController(dotControllerInfoForm dot)
	{
		controll = dot;
	}
	
	public static void avoidInitialization(int rows, int columns, String Char){
		boardChanger(array,rows,columns,Char);
	}
	
	public static String whoChar(){
		String returnVal = "";
		
		if(controll.isPlayerOneTurn()==true){
			returnVal=controll.getPlayerChar(controll.getPlayerOneName());
		}
		else
		{
			returnVal=controll.getPlayerChar(controll.getPlayerTwoName());
		}
		System.out.println(returnVal);
		return returnVal;
	}
	public static int spaceLength(String text){
		
		double numb = text.length();
		double pixels = numb*8.8;
		int retPix = (int) pixels;
		return retPix;
	}
}