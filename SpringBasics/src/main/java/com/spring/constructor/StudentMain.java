package com.spring.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.constructor");
		Student student1=(Student)context.getBean("student");
		System.out.println(student1);
		
		Student student2=context.getBean("student",Student.class);
		System.out.println(student2);
		
		student2=context.getBean(Student.class);
		System.out.println(student2);
	}

}
