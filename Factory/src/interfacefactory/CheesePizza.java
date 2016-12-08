package interfacefactory;

public class CheesePizza extends Pizza {
	PizzaIngredientFactory ingredientfactory;
	
	public CheesePizza(PizzaIngredientFactory ingredientfactory) {
		this.ingredientfactory = ingredientfactory;
	}

	@Override
	void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Prepareing "+name);
		dough = ingredientfactory.createDough();
		sauce = ingredientfactory.createSauce();
		cheese = ingredientfactory.createCheese();
				
	}

}
