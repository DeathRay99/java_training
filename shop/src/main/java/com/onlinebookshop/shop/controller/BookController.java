package com.onlinebookshop.shop.controller;
 
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.service.BookService;
 
@Controller
@RequestMapping("/api")
public class BookController{
		private BookService bookService;

		public BookController(BookService bookService) {
			this.bookService = bookService;
		}
 
		@GetMapping("/books")
		@ResponseBody
		public List<Book> fetchBooks()
		{
			return bookService.getAllBooks();
		}
		
		@GetMapping("/books/{id}")
		@ResponseBody
		public Book fetchBookById(@PathVariable int id)
		{
			return bookService.getBookById(id);
		}
		
		@PostMapping("/books")
		@ResponseBody
		public String addBook(@RequestBody Book book) {
			bookService.addBook(book);
			return "Book Added Successfully";
		}
		
		@DeleteMapping("/books/{id}")
		@ResponseBody
		public  ResponseEntity<String> deleteBook(@PathVariable int id) {
			try {
				int rowsAffected=bookService.deleteBookById(id);
				if(rowsAffected>0) {
					return ResponseEntity.ok("Book deleted successfully");
				}else
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
			}
			catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting book");
			}
		}
		
		@PutMapping("/books/{id}")
	    @ResponseBody
	    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book book) {
	        try {
	            book.setId(id);
	            int rowsAffected = bookService.updateBook(book);
	            if (rowsAffected > 0) {
	                return ResponseEntity.ok("Book updated successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating book");
	        }
	    }
}
	