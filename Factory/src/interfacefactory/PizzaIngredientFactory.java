package interfacefactory;
//�ṩһ������ӿ�������һ����Ʒ����
public interface PizzaIngredientFactory {
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Veggies createVeggies();
	Clams createClams();
}
//��Ϊ������Ҫ����һ����Ʒ���壨Ҳ����ԭ�ϣ�
//���ǰ�PizzaIngredinentFactoryʵ��Ϊ���󹤳�
//ÿ�����඼ʹ��������Ĺ�������ʵ����Щԭ��