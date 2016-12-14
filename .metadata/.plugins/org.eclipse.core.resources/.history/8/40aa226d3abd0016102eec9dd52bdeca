package factory;

public class NYPizzaStore extends PizzaStore {
//	子类实现工厂方法，以实际制造出产品
	@Override
	protected Pizza createPizza(String type) {
		if("cheese".equals(type)){
			return new NYStyleCheesePizza();
		}else return null;
	}

}
