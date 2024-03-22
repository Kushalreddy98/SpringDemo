package com.voya.instrument;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext("com.voya.instrument");
		Performer performer=context.getBean(Performer.class);
		performer.playMusic("guitar", "Senorita");
		performer.playMusic("violin", "Senorita");
		performer.playMusic("keyboard", "Senorita");
	}

}
