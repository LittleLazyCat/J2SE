package com.example.model;

import java.util.ArrayList;

public class jspModel {
	ArrayList<String> al = new ArrayList<String>();
	public ArrayList<String> shareHobby(String hobby)
	{
		if("extreme knitting".equals(hobby))
		{
			al.add("Fred");
			al.add("Pradeep");
			al.add("Philippe");
		}
		return al;
	}
}
