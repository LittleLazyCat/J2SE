package Duck;

public class Main {

	public static void main(String[] args) {
		
		Duck md = new MallardDuck();
		md.performFly();
		md.display();
		md.setFlyBehavior(new FlyNoWay());
		md.performFly();
		md.performQuack();
		DuckCall dc = new DuckCall();
		dc.performQuack();
	}

}
