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
import javax.swing.JComponent;
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
	
	public static dotControllerInfoForm controll;
	
	public static int flagged = 0;
	
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
		
		this.playerOneScore = new JTextArea(controll.getPlayerOneScore());
		playerOneScore.setPreferredSize(new Dimension(50,50));
		playerOneScore.setEditable(false);
		
		this.playerTwoScore = new JTextArea(controll.getPlayerTwoScore());
		playerTwoScore.setPreferredSize(new Dimension(50,50));
		playerTwoScore.setEditable(false);
		
		
		this.turnText = new JTextArea(controll.getPlayerOneName());
		turnText.setPreferredSize(new Dimension(150,50));
		turnText.setEditable(false);
		
		JPanel board = new JPanel();
		int boardWidth = allocateBoardWidth(controll.getColumns());
		int boardHeight = allocateBoardHeight(controll.getRows());
		board.setPreferredSize(new Dimension(boardWidth,boardHeight));
		board.setBackground(Color.WHITE);
		
		
		JComponent[][] array = boardBuilder(controll.getRows(),controll.getColumns());
		
		
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
		setSize(boardHeight+40,boardWidth+350);
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
						returnVal[i][j] = new newButtonHoriz();
						
					}
				}
				else
				{
					// print vert lines with JTextArea
					if(j%2==0)
					{
						// lines 
						returnVal[i][j] = new newButtonVert();
						
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
		newButtonHoriz current;
		JTextAreaCustom text;
		int realRows = rows*2 +1;
		int realColumns = columns*2 + 1;
		for(int i=1; i<realRows-1; i++)
		{
			if (i%2==0){
				for(int j=1; j<realColumns-1; j++)
				{
					if(j%2!=0)
					{
						top = (newButtonHoriz) board[i-2][j];
						left = (newButtonVert) board[i-1][j-1];
						right = (newButtonVert) board[i-1][j+1];
						current = (newButtonHoriz) board[i][j];
						if(top.hasBeenFlagged()&&left.hasBeenFlagged()&&right.hasBeenFlagged()&&current.hasBeenFlagged())
						{
							text = (JTextAreaCustom)board[i][j-1];
							text.setText(Char);
						}
					}
				}
			}
		}
	}
	public static void isChange() {
		System.out.println("it worked");
		controll.updatePlayerTurn();
	}
	
	public static void registerController(dotControllerInfoForm dot)
	{
		controll = dot;
	}
}