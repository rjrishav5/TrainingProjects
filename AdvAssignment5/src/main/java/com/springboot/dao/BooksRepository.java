package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Books;

public interface BooksRepository  extends JpaRepository<Books, Integer>{

}
