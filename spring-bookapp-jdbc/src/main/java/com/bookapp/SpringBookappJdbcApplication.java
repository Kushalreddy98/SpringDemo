package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJdbcApplication implements CommandLineRunner {
	@Autowired
	IBookService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Books List ");
		List<Book> bookList = service.getAll();
		for (Book book1 : bookList)
			System.out.println(book1);

		System.out.println("Enter book Id");
		int id = sc.nextInt();
		System.out.println("Enter the Price");
		double price = sc.nextDouble();
		service.updateBook(id, price);
		
		System.out.println("Enter book Id");
		int id1 = sc.nextInt();
		service.deleteBook(id1);

		
		System.out.println("Enter author name");
		String author = sc.next();
		List<Book> bookList1 = service.getByAuthorStartsWith(author);
		for (Book book2 : bookList1)
			System.out.println(book2);

		System.out.println("Enter book category");
		String category = sc.next();
		List<Book> bookList2 = service.getByCategory(category);
		for (Book book3 : bookList2)
			System.out.println(book3);

		System.out.println("Enter book price");
		double price1 = sc.nextDouble();
		List<Book> bookList3 = service.getByPriceLessThan(price1);
		for (Book book3 : bookList3)
			System.out.println(book3);

		System.out.println("Enter author and category");
		String author2 = sc.next();
		String category2 = sc.next();
		List<Book> bookList4 = service.getByAuthorContainsAndCategory(author2, category2);
		for (Book book4 : bookList4)
			System.out.println(book4);

		System.out.println("Enter book Id");
		int id3 = sc.nextInt();
		System.out.println(service.getById(id3));
	}

}
