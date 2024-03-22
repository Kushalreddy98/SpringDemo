package com.example.auto;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements IShape{

	public void area(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Area of traingle is "+(0.5*x*y));
	}

}
