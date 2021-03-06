package starbuzz;

public class Milk extends CondimentDecorator {

	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.description + ",Milk";
	}

	@Override
	public float cost() {
		return 0.25f + beverage.cost();
	}

}
