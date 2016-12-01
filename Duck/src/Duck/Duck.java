package Duck;
//鸭子的超类
public abstract class Duck {
	FlyBehavior flyBehavior;	//飞行行为接口
	QuackBehavior quackBehavior;	//鸭叫行为接口
	abstract void display();
	void performFly(){
		flyBehavior.fly();
	}
	void performQuack(){
		quackBehavior.quack();
	}
	void setFlyBehavior(FlyBehavior fly){
		flyBehavior = fly;
	}
	void setQuackBehavior(QuackBehavior quack)
	{
		quackBehavior = quack;
	}
}
