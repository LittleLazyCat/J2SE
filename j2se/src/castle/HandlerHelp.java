package castle;

public class HandlerHelp extends Handler {
	public HandlerHelp(Game game){
		super(game);
	}
	@Override
	public void doCMD(String cmd) {
		// ����Ϊ�û�����
 
			System.out.println("��·������������������У�go bye help");
			System.out.println("�磺\tgo east");
	 
	}

}
