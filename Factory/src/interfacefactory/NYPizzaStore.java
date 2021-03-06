package interfacefactory;

public class NYPizzaStore extends PizzaStore {
	// 子类实现工厂方法，以实际制造出产品
	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientfactory = new NYPizzaIngredientFactory();
		if ("cheese".equals(type)) {
			pizza = new CheesePizza(ingredientfactory);
			pizza.setName("New York Style Cheese Pizza");
		}
		return pizza;
	}

}
