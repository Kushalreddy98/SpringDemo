package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.auto.ShapeFactory;
import com.example.javabased.Waiter;

@SpringBootApplication(scanBasePackages = {"com"})
public class SpringBootAutowiredApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAutowiredApplication.class, args);
	}
	
	@Autowired
	ShapeFactory factory;
	@Autowired
	Waiter waiter;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		factory.printArea("r", 10, 20);
		System.out.println();
		List<String> menuList=waiter.viewMenuCard("it");
		for (String menu : menuList) {
			System.out.println(menu);
		}
	}

}