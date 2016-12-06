package human;
/*

��д�Ĵ�����

*/
abstract class Human{
	abstract void getColor();
	abstract void talk();
}
class WhiteHuman extends Human{

	@Override
	void getColor() {
		System.out.println("��ɫ���ֵ�Ƥ����ɫ�ǰ�ɫ�ģ�");
	}

	@Override
	void talk() {
		System.out.println("��ɫ���ֻ�˵����һ�㶼�ǵ��ǵ��ֽڡ�");
	}
	
}

class BlackHuman extends Human{

	@Override
	void getColor() {
		System.out.println("��ɫ���ֵ�Ƥ����ɫ�Ǻ�ɫ�ģ�");
	}

	@Override
	void talk() {
		System.out.println("���˻�˵����һ������������");
	}
	
}

class YellowHuman extends Human{

	@Override
	void getColor() {
		System.out.println("��ɫ���ֵ�Ƥ����ɫ�ǻ�ɫ�ģ� ");
	}

	@Override
	void talk() {
		System.out.println("��ɫ���ֻ�˵����һ��˵�Ķ���˫�ֽڡ�");
	}
	
}
abstract class AbstractHumanFactory {   
	public abstract Human createHuman(Class<? extends Human> c);   
} 


class HumanFactory extends AbstractHumanFactory {   
	public Human createHuman(Class<? extends Human> c){   
		//����һ������������ 	  
		Human human=null; 	  
		try { 	  
			//����һ������ 
			human = (Human)Class.forName(c.getName()).newInstance();  
		} catch (Exception e) {  
			System.out.println("�������ɴ���"); 
		} 	  
	return human;   
	} 
} 

public class HumanTester {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������������¯ 		  
		AbstractHumanFactory YinYangLu = new HumanFactory(); 	  
		//Ů洵�һ�����ˣ�����㣬ȱ�ݲ�Ʒ 		  
		System.out.println("--����ĵ�һ�����ǰ�ɫ����--"); 		  
		Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class); 		  
		whiteHuman.getColor(); 		  
		whiteHuman.talk(); 		  
		//Ů洵ڶ������ˣ������㣬���Ǵ�Ʒ�� 		  
		System.out.println("\n--����ĵڶ������Ǻ�ɫ����--"); 		  
		Human blackHuman = YinYangLu.createHuman(BlackHuman.class); 		  
		blackHuman.getColor(); 		  
		blackHuman.talk(); 		  
		//���������ˣ����ոպã���Ʒ����ɫ���� 		  
		System.out.println("\n--����ĵ��������ǻ�ɫ����--"); 		  
		Human yellowHuman = YinYangLu.createHuman(YellowHuman.class); 		  
		yellowHuman.getColor();		  
		yellowHuman.talk(); 		  
	}
}