package castle;

public class HandlerBye extends Handler {
	public HandlerBye(Game game){
		super(game);
	}
	@Override
	public boolean isBye() {
		System.out.println("感谢您的光临。再见！");
		return true;
	}
	
}
