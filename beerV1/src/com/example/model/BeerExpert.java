package com.example.model;
import java.util.*;
public class BeerExpert {
	
	public List getColorList() {
        
	    List colorList = new ArrayList();
	    colorList.add("light");
	    colorList.add("amber");
	    colorList.add("brown");
	    colorList.add("dark");
	         
	    return colorList;
	}
	public List getBrands(String color){
		List brands = new ArrayList<>();
		if(color.equals("amber")){
			brands.add("Jack Amber");
			brands.add("Red Moose");
		}
		else{
			brands.add("Jail Pale Ale");
			brands.add("Gout Stout");
		}
		return brands;
	}
}
