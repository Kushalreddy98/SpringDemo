package com.example.javabased;

import java.util.Arrays;
import java.util.List;


public class Chinese implements IFoodMenu{

	public List<String> showMenu() {
		// TODO Auto-generated method stub
		List<String> chineseList=Arrays.asList("Kung Pao Chicken","Dim Sum","Peking Duck");
		
		return chineseList;
	}

}
