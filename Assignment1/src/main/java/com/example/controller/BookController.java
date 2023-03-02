package com.example.controller;

import com.example.bean.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.BookRepository;

@RestController
@RequestMapping("books")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("all")
	public List<Book> getAllBooks() {
		
		List<Book> books = (List<Book>) bookRepository.findAll();
		
		return books;
	}
	
	@GetMapping("book/{id}")
	public Optional<Book> getBookById(@PathVariable int id) {
		return bookRepository.findById(id);
	}
	
	@PostMapping("add")
	public String createBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Book added";
	}
	
	@PutMapping("update/{id}")
	public String updateBookById(@RequestBody Book book) {
		bookRepository.save(book);
		return "Book updated";
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteBookById(@PathVariable int id) {
		bookRepository.deleteById(id);
		return "Book deleted";
	}
	
	@DeleteMapping("delete")
	public String deleteAllBooks() {
		bookRepository.deleteAll();
		return "All books deleted";
	}
	
	@GetMapping("book/{year}")
	public Optional<Book> findBookByYear(@PathVariable int year) {
		return bookRepository.findById(year);
	}
}
