package com.spring.auto;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements IShape{

	public void area(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Area of Rectangle is "+(x*y));
	}

}
