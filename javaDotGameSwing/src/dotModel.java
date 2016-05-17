

public interface dotModel {
	
	/**
	 * reports player one name
	 * 
	 * @return this.playerOneName;
	 */
	String playerOneName();
	
	/**
	 * reports player two name
	 * 
	 * @return this.playerTwoName;
	 */
	String playerTwoName();
	
	/**
	 * reports player one char
	 * 
	 * @return this.playerOneChar;
	 */
	char playerOneChar();
	
	/**
	 * reports player two char
	 * 
	 * @return this.playerOneChar;
	 */
	char playerTwoChar();
	
	/**
	 * reports player one score
	 * 
	 * @return this.playerOneScore;
	 */
	int playerOneScore();
	
	/**
	 * reports player two score
	 * 
	 * @return this.playerTwoScore;
	 */
	int playerTwoScore();
	/**
	 * reports board size height in boxes
	 * 
	 * @return this.height;
	 */
	int boardSizeHeightBox();
	
	/**
	 * reports board size width in boxes
	 * 
	 * @return this.width;
	 */
	int boardSizewidthBox();
	
	/**
	 * reports total amount of buttons
	 * 
	 * @return
	 */
	int boardSizeLines();
}