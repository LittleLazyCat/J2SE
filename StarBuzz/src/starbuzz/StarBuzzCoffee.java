package starbuzz;

public class StarBuzzCoffee {

	public static void main(String[] args) {
		Beverage beverage = new HouseBlend();
		System.out.println(beverage.getDescription()+beverage.cost());
		beverage= new Milk(beverage);//������IO
		System.out.println(beverage.getDescription()+beverage.cost());
	}

}
