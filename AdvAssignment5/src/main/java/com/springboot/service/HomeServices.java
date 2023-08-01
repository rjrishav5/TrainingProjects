package com.springboot.service;

import java.net.URI;

import java.net.URISyntaxException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.model.Books;




@Service
public class HomeServices {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Books[] getAllBooks()
	{
		Books[] books = this.restTemplate.getForObject("http://localhost:1235/books",Books[].class);
		return books;
	}
	
	public Books addBook(Books newBook) throws URISyntaxException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI uri = new URI("http://localhost:1235/addBook");

//		Books newBook = new Books(1001 , "Book added by jsp" , "author added by jsp");

		HttpEntity<Books> httpEntity = new HttpEntity<>(newBook, headers);

		Books addedBook = this.restTemplate.postForObject(uri, httpEntity, Books.class);
		
		return addedBook;
		
	}
	
//	public Books getBookbyId()

	public Books getBookbyId(Integer id) {
		Books book = this.restTemplate.getForObject("http://localhost:1235/getbooks/"+ id , Books.class);
		return book;
	}

	public void editBook(Books newBook) throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI uri = new URI("http://localhost:1235/updateById");

		HttpEntity<Books> httpEntity = new HttpEntity<>(newBook, headers);
		this.restTemplate.put(uri, httpEntity);
		
	}

	public void deleteById(Integer id) throws URISyntaxException {
		URI uri = new URI("http://localhost:1235/deleteBookbyId/"+id);
		this.restTemplate.delete(uri);
		
	}

}
