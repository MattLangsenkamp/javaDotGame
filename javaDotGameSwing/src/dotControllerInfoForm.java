
public class dotControllerInfoForm {

	DotInfoForm view;
	
	static dotModel1 model;
	
	public dotControllerInfoForm(DotInfoForm viewNew, dotModel1 modelNew)
	{
		this.model = modelNew;
		this.view = viewNew;
	}
	
	public void updateNameOne(String str) {
		model.setNameOne(str);
		
	}

	public void updateCharOne(String str) {
		model.setCharOne(str);
	}

	
	public void updateNameTwo(String str) {
		model.setNameTwo(str);
		
	}

	
	public void updateCharTwo(String str) {
		model.setCharTwo(str);
		
	}

	
	public void updateBoardSizeHeight(int h) {
		model.setBoardH(h);		
	}

	
	public void updateBoardSizeWidth(int w) {
		model.setBoardW(w);	
	}
	

	
	public void updateScoreOne(int scoreOne) {
		model.setScoreOne(scoreOne);
		
	}

	
	public void updateScoreTwo(int scoreTwo) {
		model.setScoreTwo(scoreTwo);
		
	}
	
	public void updatePlayerTurn(){
		model.updateTurn();
	}
  //-------------- methods for main-game
	public static String getPlayerOneScore() {
		return ""+model.playerOneScore();
	}
	public static String getPlayerTwoScore() {
		return ""+model.playerTwoScore();
	}
	public static String getPlayerOneName() {
		
		return model.playerOneName();
	}
	public static String getPlayerTwoName() {
		return model.playerTwoName();
	}
	public static int getRows() {
		return model.boardSizeHeightBox();
	}
	public static int getColumns() {
		return model.boardSizeWidthBox();
	}
	public static boolean isPlayerOneTurn() {
		
		return model.isPlayerOneturn();
	}
	public static String getPlayerChar(String player){
		String val = "";
		if(player == model.playerOneName()){
			val = model.playerOneChar();
		}else if (player == model.playerTwoName()){
			val = model.playerTwoChar();
		}
		return val;
	}
	
}