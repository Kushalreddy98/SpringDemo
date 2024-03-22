package com.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	//Auto Wiring by type
	@Autowired
	@Qualifier("rectangle")
	private IShape shape;
	
	//Auto Wiring by name
	@Autowired
	private IShape triangle;
	
	//Auto Wiring by constructor
	private IShape shaper;
	public ShapeFactory(IShape shaper) {
		super();
		this.shaper = shaper;
	}

	public IShape getShape() {
		return shape;
	}
	
	public void setShape(IShape shape) {
		this.shape = shape;
	}
	
	void printArea(String choice,int x,int y) {
		System.out.println("Printing Area");
		if(choice.equals("r"))
			shape.area(10, 20);
		if(choice.equals("t"))
			triangle.area(10, 20);
		if(choice.equals("s"))
			shaper.area(10, 20);
	}

}
