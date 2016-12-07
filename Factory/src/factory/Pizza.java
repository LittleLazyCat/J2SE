package factory;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList toppings = new ArrayList();
	
	void prepare(){
		System.out.println("Preparing "+name);
		System.out.println("Tossing dough");
		System.out.println("Adding sauce");
		for(int i=0;i<toppings.size();i++)
		{
			System.out.print("    "+toppings.get(i));
		}
		System.out.println();
	}
	void bake(){
		System.out.println("ºæ¿¾");
	}
	void cut(){
		System.out.println("ÇÐÆ¬");
	}
	void box(){
		System.out.println("´ò°ü");
	}
	public String getName(){
		return name;
	}
}
