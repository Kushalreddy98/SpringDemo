package com.example.javabased;

import java.util.Arrays;
import java.util.List;

public class Indian implements IFoodMenu{

	public List<String> showMenu() {
		// TODO Auto-generated method stub
		List<String> indianList=Arrays.asList("North Indian Meals","South Indian Meals","Curd Rice");
		
		return indianList;
	}

}
