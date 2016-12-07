package factory;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		if("cheese".equals(type)){
			return new NYStyleCheesePizza();
		}else return null;
	}

}
