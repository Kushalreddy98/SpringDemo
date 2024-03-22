package com.bookapp.repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;

import java.util.List;

public interface IBookRepository {
    void addByBook(Book book);
    void updateBook(int bookId,double price);
    void deleteBook(int bookId);
    Book findById(int bookId) throws IdNotFoundException;

    List<Book> findAll();
    List<Book> findByAuthor(String author) throws BookNotFoundException;
    List<Book> findByCategory(String category) throws BookNotFoundException;
    List<Book> findByLesserPrice(double price) throws BookNotFoundException;
    List<Book> findByAuthorCategory(String author,String category) throws BookNotFoundException;

}
