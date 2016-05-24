public final class dotRunner {
	
	private dotRunner(){
		
	}
	
	public static void main(String[] args) {
		dotModel1 dotModel = new dotModel1();
		DotInfoForm dotView = new DotInfoForm();
		
		dotController1 dotControll = new dotController1(dotView, dotModel);
		dotView.registerController(dotControll);
	}
}