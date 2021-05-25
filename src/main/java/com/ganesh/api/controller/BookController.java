package com.ganesh.api.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.api.model.Book;

/**
 * @Project: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

@RestController
@RequestMapping(path = "/v1/books")
public class BookController {
	
	
	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody Book book){
		
		book.setBookId(UUID.randomUUID().toString());
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable String bookId){
		
		Book book = new Book(bookId, UUID.randomUUID().toString(), "APIs Security", "GKP Publisher", "23-05-2021");
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

}
