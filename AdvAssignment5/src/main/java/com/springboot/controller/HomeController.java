package com.springboot.controller;

import java.io.IOException;


import java.net.URISyntaxException;

import java.util.Optional;
import com.springboot.model.Books;

import javax.servlet.ServletException;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dao.BooksRepository;
import com.springboot.dao.UserRepository;
import com.springboot.model.User;
import com.springboot.service.HomeServices;

@Controller
public class HomeController {
	
	@Autowired
	private HomeServices service;
	
	@Autowired
	private UserRepository userrepo;
	
	
	
	
	
	
	
	@RequestMapping("/loginAccess")
	public String loginHandler(@ModelAttribute User user,HttpSession session)
	{
		Optional<User>getUsers =  userrepo.findUser(user.getUsername(), user.getPassword());
		
		if(getUsers.isPresent())
		{
			session.setAttribute("username", user.getUsername());
			return "redirect:/listBooks";
		}
		session.setAttribute("message","wrong Details!");
		return "redirect:/login";
	}
	

	
	
	@RequestMapping("/listBooks")
	public String Books(Model model)
	{
		Books[] list = this.service.getAllBooks();
		model.addAttribute("list", list);
		return "listBooks";
		
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "getlogin";
		
	}
	

	
	
	@RequestMapping("/edit/{id}" )
	public String editBooks(@PathVariable("id") Integer id,Model model)
	{
		
		System.out.println("reached here");
		
		Books getbook = this.service.getBookbyId(id);
		System.out.println(getbook.getDateAdded());
		model.addAttribute("edit", getbook);
		return "getEdit";
		
	}
	
	
	@RequestMapping("/submitEdit")
	public String saveEditObj(@ModelAttribute Books book,Model model) throws URISyntaxException
	{
	System.out.println(book.getBookName()+book.getBookId());

	this.service.editBook(book);
		return "redirect:/listBooks";
	}
	
	
	@RequestMapping("/deleteBooks/{id}" )
	public String deleteBooks(@PathVariable("id") Integer id) throws URISyntaxException
	{
		
		this.service.deleteById(id);
		return "redirect:/listBooks";
		
	}
	
	
	@RequestMapping("/datasave")
	public String saveBook(@ModelAttribute Books books,HttpSession session)throws ServletException, IOException, URISyntaxException
	{
		Books added = this.service.addBook(books);
		
		
		
		
		if(added!=null)
		{
			return "redirect:/listBooks";	}
		else
		{
			return "redirect:/addBooks";
			
		}
		
		
		
		
	}
	
	@RequestMapping(path="/logoutUser")
	public String Userlogout(HttpSession session ) {
	    session.invalidate();
	    return "getlogin";
	} 
	
	@RequestMapping("/addBooks")
	public String addBooks() 
	{

		return "addBook";
		
	}

}
