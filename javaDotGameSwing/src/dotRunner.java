public final class dotRunner {
	
	private dotRunner(){
		
	}
	
	public static void main(String[] args) {
		dotModel dotModel = new dotModel1();
		DotInfoForm dotView = new DotInfoForm();
		
		dotController dotControll = new dotController1(dotView, dotModel);
		dotView.registerController(dotControll);
	}
}