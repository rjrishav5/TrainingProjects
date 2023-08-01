package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Books;
import com.springboot.service.BooksService;


/*---------------THIS IS THE FRONT CONTROLLER THAT WILL HANDLE ALL THE FUNCTIONING OF THE RESTY APIS AND THE OUTPUT OF ALL THE API----*/

@RestController
public class ApiController {
	@Autowired
	private BooksService booksService;
	
	
	
	/*-----------------THIS WILL BE EXECUTED TO GET THE BOOKS-------------------*/
	
	@GetMapping("/books")
	public List<Books> books()
	{	
		return this.booksService.getBooks();
	}
	
	@GetMapping("/getbooks/{id}") 
	public Books GetBooksById(@PathVariable("id") int id)
	{
		return this.booksService.getBooksById(id);
	}
	
	
	/*-----------------THIS WILL BE EXECUTED TO ADD THE BOOKS-------------------*/
	
	@PostMapping("/addBook")
	public Books addBook(@RequestBody Books book)
	{
		
		return this.booksService.addBook(book);
	}
	
	
	/*-----------------THIS WILL BE EXECUTED TO DELETE THE BOOKS-------------------*/
	
	@DeleteMapping("/deleteBookbyId/{id}")
	public Books deleteBookById(@PathVariable("id") Integer id)
	{
		return this.booksService.deleteById(id);
	}
	
	
	/*-----------------THIS WILL BE EXECUTED TO EDIT THE BOOKS-------------------*/
	@PutMapping("/updateById")
	public Books updateById(@RequestBody Books book)
	{
		System.out.println(book);
		return booksService.updateById(book.getBookId(),book.getBookName(),book.getAuthorName(),book.getDateAdded());
	}

}
