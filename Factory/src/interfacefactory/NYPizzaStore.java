package interfacefactory;

public class NYPizzaStore extends PizzaStore {
	// ����ʵ�ֹ�����������ʵ���������Ʒ
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
