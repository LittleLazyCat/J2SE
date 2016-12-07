package factory;
//具体产品
public class NYStyleCheesePizza extends Pizza {
	public NYStyleCheesePizza(){
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.add("Grated Reggiano Cheese");
	}
}
