package castle;

public class HandlerGo extends Handler {

	public HandlerGo(Game game){
		super(game);
	}
	@Override
	public void doCMD(String cmd) {
		game.goRoom(cmd);
	}

}
