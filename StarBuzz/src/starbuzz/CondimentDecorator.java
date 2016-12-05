package starbuzz;
//为了让CondimentDecorator能够取代Beverage，所以将CondimentDecorator扩展自Beverage
public abstract class CondimentDecorator extends Beverage {

	public abstract String getDescription();
	 

}
