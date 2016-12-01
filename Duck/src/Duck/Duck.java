package Duck;
//Ѽ�ӵĳ���
public abstract class Duck {
	FlyBehavior flyBehavior;	//������Ϊ�ӿ�
	QuackBehavior quackBehavior;	//Ѽ����Ϊ�ӿ�
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
