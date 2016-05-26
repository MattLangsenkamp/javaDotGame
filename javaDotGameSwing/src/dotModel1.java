

public  class dotModel1   {

	// 0 - playerOneName, 1 - playerTwoName, 2 - playerOneChar, 3 - playertwoChar;
	
	public static String[] StringValsInReferenceForm = new String[4];
		
		// 0 - playerOneScore, 1 - playerTwoScore, 2 - boardSizeH, 3 - boardSizeW;
		
	public static int[] IntValsInReferenceForm = new int[4];
	
	public static boolean playerOneTurn = true;
	
	public static boolean isPlayerOneturn() {
		
		return playerOneTurn;
		
	}
	
	public static String playerOneName() {
		
		return StringValsInReferenceForm[0];
		
	}

	
	public static String playerTwoName() {
		
		return StringValsInReferenceForm[1];
	}


	public static String playerOneChar() {
		
		return StringValsInReferenceForm[2];
	}

	
	public static String playerTwoChar() {
		
		return StringValsInReferenceForm[3];
	}

	
	public static int playerOneScore() {
		
		return IntValsInReferenceForm[0];
	}

	
	public static int playerTwoScore() {
		
		return IntValsInReferenceForm[1];
	}

	
	public static int boardSizeHeightBox() {
		
		return IntValsInReferenceForm[2];
	}

	
	public static int boardSizewidthBox() {
		
		return IntValsInReferenceForm[3];
	}

	

	
	public void setNameOne(String name) {
		StringValsInReferenceForm[0] = name;
	}

	
	public void setNameTwo(String name) {
		StringValsInReferenceForm[1] = name;
		
	}

	
	public void setCharOne(String charc) {
		StringValsInReferenceForm[2] = charc;
		
	}

	
	public void setCharTwo(String charc) {
		StringValsInReferenceForm[3] = charc;
		
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
		IntValsInReferenceForm[0] = scoreTwo;
		
	}

	
	public void updateTurn() {
		if(this.playerOneTurn==true){
			this.playerOneTurn = false;
		}
		if(this.playerOneTurn==false){
			this.playerOneTurn = true;
		}
		
	}

	
	
}