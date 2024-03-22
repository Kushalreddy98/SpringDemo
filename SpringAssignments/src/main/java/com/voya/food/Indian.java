package com.voya.food;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Indian implements IFoodMenu{

	public List<String> showMenu() {
		// TODO Auto-generated method stub
		List<String> indianList=Arrays.asList("North Indian Meals","South Indian Meals","Curd Rice");
		
		return indianList;
	}

}
