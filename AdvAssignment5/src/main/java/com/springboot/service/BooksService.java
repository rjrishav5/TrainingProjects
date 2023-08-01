package com.springboot.service;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.springboot.Advancejava_assignment5;
import com.springboot.dao.BooksRepository;
import com.springboot.model.Books;
import com.springboot.model.User;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class BooksService {
	
     @Autowired

	private BooksRepository booksRepository;
     
    
	
	
	public List<Books> getBooks()
	{
		return this.booksRepository.findAll();
	}
	public Books getBooksById(Integer id)
	{
		return this.booksRepository.findById(id).get();
	}
	
	public Books addBook(Books book)
	{
		return this.booksRepository.save(book);
	}
	
	public Books deleteById(Integer id)
	{
		Books d_book = this.booksRepository.findById(id).get();
		this.booksRepository.deleteById(id);
		
		return d_book;
	}
	
	public Books updateById(Integer id,String newtitle ,String newauthor,String date)
	{
		
		Books newbook = new Books(id,newtitle,newauthor,date);
		return this.booksRepository.save(newbook);
		
	}

}
