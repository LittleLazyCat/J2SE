package interfacefactory;
//提供一个抽象接口来创建一个产品家族
public interface PizzaIngredientFactory {
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Veggies createVeggies();
	Clams createClams();
}
//因为我们需要创建一个产品家族（也就是原料）
//我们把PizzaIngredinentFactory实现为抽象工厂
//每个子类都使用其区域的供货商来实现这些原料