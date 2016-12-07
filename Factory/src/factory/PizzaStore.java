package factory;
//披萨店（创造者）这个类实现了操纵产品的方法，但不实现工厂方法
public abstract class PizzaStore {
//	工厂方法，交由子类去实现
	protected abstract Pizza createPizza(String type);
	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
