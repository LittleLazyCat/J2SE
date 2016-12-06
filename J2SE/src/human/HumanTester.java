package human;
/*

填写的代码区

*/
abstract class Human{
	abstract void getColor();
	abstract void talk();
}
class WhiteHuman extends Human{

	@Override
	void getColor() {
		System.out.println("白色人种的皮肤颜色是白色的！");
	}

	@Override
	void talk() {
		System.out.println("白色人种会说话，一般都是但是单字节。");
	}
	
}

class BlackHuman extends Human{

	@Override
	void getColor() {
		System.out.println("黑色人种的皮肤颜色是黑色的！");
	}

	@Override
	void talk() {
		System.out.println("黑人会说话，一般人听不懂。");
	}
	
}

class YellowHuman extends Human{

	@Override
	void getColor() {
		System.out.println("黄色人种的皮肤颜色是黄色的！ ");
	}

	@Override
	void talk() {
		System.out.println("黄色人种会说话，一般说的都是双字节。");
	}
	
}
abstract class AbstractHumanFactory {   
	public abstract Human createHuman(Class<? extends Human> c);   
} 


class HumanFactory extends AbstractHumanFactory {   
	public Human createHuman(Class<? extends Human> c){   
		//定义一个生产的人种 	  
		Human human=null; 	  
		try { 	  
			//产生一个人种 
			human = (Human)Class.forName(c.getName()).newInstance();  
		} catch (Exception e) {  
			System.out.println("人种生成错误！"); 
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
		//声明阴阳八卦炉 		  
		AbstractHumanFactory YinYangLu = new HumanFactory(); 	  
		//女娲第一次造人，火候不足，缺陷产品 		  
		System.out.println("--造出的第一批人是白色人种--"); 		  
		Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class); 		  
		whiteHuman.getColor(); 		  
		whiteHuman.talk(); 		  
		//女娲第二次造人，火候过足，又是次品， 		  
		System.out.println("\n--造出的第二批人是黑色人种--"); 		  
		Human blackHuman = YinYangLu.createHuman(BlackHuman.class); 		  
		blackHuman.getColor(); 		  
		blackHuman.talk(); 		  
		//第三次造人，火候刚刚好，优品！黄色人种 		  
		System.out.println("\n--造出的第三批人是黄色人种--"); 		  
		Human yellowHuman = YinYangLu.createHuman(YellowHuman.class); 		  
		yellowHuman.getColor();		  
		yellowHuman.talk(); 		  
	}
}
