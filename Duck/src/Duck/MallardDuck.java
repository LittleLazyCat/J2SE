package Duck;

public class MallardDuck extends Duck {

	public MallardDuck()
	{
		flyBehavior = new FlyWithWIngs();
		quackBehavior = new Quack();
	}

	@Override
	void display() {
		System.out.println("ÂÌÍ·Ñ¼£¡");
	}
	
}
