
public class dotController1 {

	DotInfoForm view;
	dotModel1 model;
	
	public dotController1(DotInfoForm viewNew, dotModel1 modelNew)
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

	
	public void updateInterfaceHeader() {
		// TODO
		
	}

	
	public void updateScoreOne(int scoreOne) {
		model.setScoreOne(scoreOne);
		
	}

	
	public void updateScoreTwo(int scoreTwo) {
		model.setScoreTwo(scoreTwo);
		
	}

	
	public void updateTurn() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}