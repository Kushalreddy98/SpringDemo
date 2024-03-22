package com.voya.food;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Chinese implements IFoodMenu{

	public List<String> showMenu() {
		// TODO Auto-generated method stub
		List<String> chineseList=Arrays.asList("Kung Pao Chicken","Dim Sum","Peking Duck");
		
		return chineseList;
	}

}
