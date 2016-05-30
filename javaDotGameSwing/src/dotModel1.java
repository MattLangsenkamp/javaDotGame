

public  class dotModel1   {

	// 0 - playerOneName, 1 - playerTwoName, 2 - playerOneChar, 3 - playertwoChar;
	
	public static String[] StringValsInReferenceForm = new String[4];
	public static String playerCharOne = "";
	public static String playerCharTwo = "";
		// 0 - playerOneScore, 1 - playerTwoScore, 2 - boardSizeH, 3 - boardSizeW;
		
	public static int[] IntValsInReferenceForm = new int[4];
	
	public boolean playerOneTurn = true;
	
	public boolean isPlayerOneturn() {
		
		return playerOneTurn;
		
	}
	
	public String playerOneName() {
		
		return StringValsInReferenceForm[0];
		
	}

	
	public String playerTwoName() {
		
		return StringValsInReferenceForm[1];
	}


	public String playerOneChar() {
		
		return playerCharOne;
	}

	
	public String playerTwoChar() {
		
		return playerCharTwo;
	}

	
	public int playerOneScore() {
		
		return IntValsInReferenceForm[0];
	}

	
	public int playerTwoScore() {
		
		return IntValsInReferenceForm[1];
	}

	
	public int boardSizeHeightBox() {
		
		return IntValsInReferenceForm[2];
	}

	
	public int boardSizeWidthBox() {
		
		return IntValsInReferenceForm[3];
	}

	

	
	public void setNameOne(String name) {
		StringValsInReferenceForm[0] = name;
	}

	
	public void setNameTwo(String name) {
		StringValsInReferenceForm[1] = name;
		
	}

	
	public void setCharOne(String charc) {
		playerCharOne = charc;
		
	}

	
	public void setCharTwo(String charc) {
		playerCharTwo = charc;
		
	}

	
	public void setBoardH(int h) {
		IntValsInReferenceForm[2] = h;
		
	}

	
	public void setBoardW(int w) {
		IntValsInReferenceForm[3] = w;
		
	}

	
	public void setScoreOne(int scoreOne) {
		IntValsInReferenceForm[0] = scoreOne;
		
	}

	
	public void setScoreTwo(int scoreTwo) {
		IntValsInReferenceForm[1] = scoreTwo;
		
	}

	
	public void updateTurn() {
		if(this.playerOneTurn==true){
			this.playerOneTurn = false;
		}
		else if(this.playerOneTurn==false){
			this.playerOneTurn = true;
		}
		
	}

	
	
}