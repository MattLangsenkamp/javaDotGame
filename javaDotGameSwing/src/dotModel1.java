

public class dotModel1   {

	// 0 - playerOneName, 1 - playerTwoName, 2 - playerOneChar, 3 - playertwoChar;
	
	public static String[] StringValsInReferenceForm = new String[4];
		
		// 0 - playerOneScore, 1 - playerTwoScore, 2 - boardSizeH, 3 - boardSizeW;
		
	public int[] IntValsInReferenceForm = new int[4];
	
	
	public String playerOneName() {
		String val = StringValsInReferenceForm[0];
		return val;
	}

	
	public String playerTwoName() {
		
		return StringValsInReferenceForm[1];
	}


	public String playerOneChar() {
		
		return StringValsInReferenceForm[2];
	}

	
	public String playerTwoChar() {
		
		return StringValsInReferenceForm[3];
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

	
	public int boardSizewidthBox() {
		
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
		// TODO Auto-generated method stub
		
	}

	
	
}