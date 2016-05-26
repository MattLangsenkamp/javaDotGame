public final class dotRunner {
	
	private dotRunner(){
		
	}
	
	public static void main(String[] args) {
		dotModel1 dotModel = new dotModel1();
		DotInfoForm dotView = new DotInfoForm();		
		dotControllerInfoForm dotControll = new dotControllerInfoForm(dotView, dotModel);	
		dotView.registerController(dotControll);
	}
}