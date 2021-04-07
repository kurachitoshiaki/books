package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Book> booklist=bookService.searchAll();
        model.addAttribute("booklist", booklist);
        return "index";
    }
    
    @GetMapping("/book/{id}")
    public String displayView(@PathVariable Long id, Model model) {
      Book book = bookService.findById(id);
      model.addAttribute("book", book);
      return "show";
    }
}