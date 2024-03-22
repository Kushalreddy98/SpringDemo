package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookserviceImpl implements IBookService{
	 private BookDetails details;
	 
	 @Autowired
	 public void setDetails(BookDetails details) {
		 this.details =details;
	 }
	 
	 
    public List<Book> getAll() {
        List<Book> books= details.showBooks();
        return books;
    }

    @Override
    public List<Book> getByAuthorStartsWith(String author) throws BookNotFoundException {
        List<Book> books= details.showBooks();
        List<Book> bookByAuthor=new ArrayList<>();
        for(Book book:books){
            if(book.getAuthor().startsWith(author))
            bookByAuthor.add(book);
        }
        if(bookByAuthor.isEmpty())
            throw new BookNotFoundException("Book doesn't exist : written by "+author);

        return bookByAuthor;
    }

    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException {
        List<Book> books= details.showBooks();
        List<Book> bookByCategory=new ArrayList<>();
        for(Book book:books){
            if(book.getCategory().startsWith(category))
                bookByCategory.add(book);
        }
        if(bookByCategory.isEmpty())
            throw new BookNotFoundException("Book doesn't exist in this category "+category);
        return bookByCategory;
    }

    @Override
    public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
        List<Book> books= details.showBooks();
        List<Book> bookByPriceLessThan=new ArrayList<>();
        for(Book book:books){
            if(book.getPrice() <=price)
                bookByPriceLessThan.add(book);
        }
        if(bookByPriceLessThan.isEmpty())
            throw new BookNotFoundException("Book doesn't exist in this price "+price);
        return bookByPriceLessThan;
    }

    @Override
    public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
        List<Book> books= details.showBooks();
        List<Book> booksWithAuthorAndCategory=new ArrayList<>();
        for(Book book:books){
            if(book.getAuthor().contains(author) && book.getCategory().contains(category))
                booksWithAuthorAndCategory.add(book);
        }
        if(booksWithAuthorAndCategory.isEmpty())
            throw new BookNotFoundException("Book doesn't exist");
        return booksWithAuthorAndCategory;
    }

    @Override
    public Book getById(int bookId) throws IdNotFoundException {
        List<Book> books= details.showBooks();

        for(Book book:books){
            if(book.getBookId()==bookId)
                return book;
        }
           throw new IdNotFoundException("Book Id "+bookId+" doesn't Exist");
    }
}
