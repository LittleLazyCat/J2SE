package starbuzz;

public abstract class CondimentDecorator extends Beverage {

	public String getDescription(){
		return description;
	}
	public abstract float cost();

}
