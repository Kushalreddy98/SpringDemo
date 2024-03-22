package com.voya.food;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Italian implements IFoodMenu{

	public List<String> showMenu() {
		// TODO Auto-generated method stub
		List<String> italianList=Arrays.asList("Spaghetti Carbonara","Margherita Pizza","Tiramisu");
		
		return italianList;
	}

}
