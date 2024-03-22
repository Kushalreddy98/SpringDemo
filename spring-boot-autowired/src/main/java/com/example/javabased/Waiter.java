package com.example.javabased;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Waiter {
	@Autowired
	@Qualifier("getIndian")
	IFoodMenu iFoodMenu;
	
	@Autowired
	 IFoodMenu menus;
	
	
	 IFoodMenu menuItems;
	

	public void setMenuItems(IFoodMenu menuItems) {
		this.menuItems = menuItems;
	}


	public List<String> viewMenuCard(String choice){
		List<String> menuList=new ArrayList<String>();
		if(choice.equals("in"))
			menuList=iFoodMenu.showMenu();
		if(choice.equals("ch"))
			menuList=menus.showMenu();
		if(choice.equals("it"))
			menuList=menuItems.showMenu();
		
		return menuList;
		
	}
	


	


	
	
	
}
