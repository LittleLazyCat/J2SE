package interfacefactory;
//每个具体子类都创建一个家族的产品
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		// TODO Auto-generated method stub
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		// TODO Auto-generated method stub
		return new ReggianoCheese();
	}

	@Override
	public Veggies createVeggies() {
		// TODO Auto-generated method stub
		return new FreshVeggies();
	}

	@Override
	public Clams createClams() {
		// TODO Auto-generated method stub
		return new FreshClams();
	}

}
