package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookserviceImpl;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappBasicApplication.class, args);
	}

	@Autowired
	IBookService iBookService;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the book name");
		String name = sc.next();
		List<Book> booksByCategory;
		
		System.out.println();
		System.out.println("Enter the book category");
		String category = sc.next();
		booksByCategory = iBookService.getByCategory(category);
		for (Book book : booksByCategory)
			System.out.println(book);

		System.out.println();
		System.out.println("Book by Author");
		System.out.println("Enter the book author");
		String author = sc.next();
		List<Book> getByAuthor = iBookService.getByAuthorStartsWith(author);
		for (Book book : getByAuthor)
			System.out.println(book);

		System.out.println();
		System.out.println("Book by Price");
		System.out.println("Enter the book Price");
		double price = sc.nextInt();
		List<Book> bookByPriceLessThan = iBookService.getByPriceLessThan(price);
		for (Book book : bookByPriceLessThan)
			System.out.println(book);

		System.out.println();
		System.out.println("Book by Author");
		System.out.println("Enter the Author Name");
		System.out.println("Enter the book category");
		String author1 = sc.next();
		String category1 = sc.next();

		List<Book> getByAuthorContainsAndCategory = iBookService.getByAuthorContainsAndCategory(author1, category1);
		for (Book book : getByAuthorContainsAndCategory)
			System.out.println(book);

	}

}
