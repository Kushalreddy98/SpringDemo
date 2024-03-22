package com.spring.auto;

import org.springframework.stereotype.Component;

@Component("shaper")
public class Square implements IShape{

	public void area(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Area of Square is "+(x*x));
	}

}
