package com.voya.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Waiter {
	@Autowired
	private IFoodMenu indian;
	@Autowired
	private IFoodMenu chinese;
	@Autowired
	private IFoodMenu italian;

	List<String> viewMenuCard(String choice){
		List<String> menuList=new ArrayList<String>();
		if(choice.equals("indian"))
			menuList=indian.showMenu();
		if(choice.equals("chinese"))
			menuList=chinese.showMenu();
		if(choice.equals("italian"))
			menuList=italian.showMenu();
		
		return menuList;
		
	}
}
