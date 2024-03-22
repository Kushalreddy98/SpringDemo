package com.bookapp.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.Queries;

@Repository
public class BookRepositoryImpl implements IBookRepository {
	private JdbcTemplate jdbcTemplate;
	

	public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public void addByBook(Book book) {
		Object[] bookArr= {book.getTitle(),book.getAuthor(),book.getPrice(),book.getCategory()};
		jdbcTemplate.update(Queries.INSERTQUERY, bookArr);
	}

	@Override
	public void updateBook(int bookId, double price) {
		jdbcTemplate.update(Queries.UPDATEQUERY,price,bookId);
		
	}

	@Override
	public void deleteBook(int bookId) {
		jdbcTemplate.update(Queries.DELETEQUERY,bookId);
		
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
		Book book=jdbcTemplate.queryForObject(Queries.SELECTBYIDQUERY,new BookMapper(), bookId);
		return book;
	}

	@Override
	public List<Book> findAll() {
		RowMapper<Book> mapper=new BookMapper();
		List<Book> book=jdbcTemplate.query(Queries.SELECTQUERY, mapper);
		return book;
	}

	@Override
	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		List<Book> book=jdbcTemplate.query(Queries.SELECTBYAUTHORQUERY, new BookMapper(),author);
		return book;
	}

	@Override
	public List<Book> findByCategory(String category) throws BookNotFoundException {
		List<Book> book=jdbcTemplate.query(Queries.SELECTBYCATQUERY, new BookMapper(),category);
		return book;
	}

	@Override
	public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
		List<Book> book=jdbcTemplate.query(Queries.SELECTBYPRICEQUERY, new BookMapper(),price);
		return book;
	}

	@Override
	public List<Book> findByAuthorCategory(String author, String category) throws BookNotFoundException {
		List<Book> book=jdbcTemplate.query(Queries.SELECTBYAUTHCATQUERY, new BookMapper(),author,category);
		return book;
	}

   
}