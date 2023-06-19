package com.Springboot.MiniLib.api;

import com.Springboot.MiniLib.model.Book;
import com.Springboot.MiniLib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RequestMapping("api/v1/Book")
@RestController
public class BookController {
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private final BookService bookService;

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> GetAllBooks(){
        return bookService.getAllBooks();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteBookbyId(@PathVariable UUID id){
        if(!bookService.isExist(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not Found");
        }
        bookService.deleteBookbyId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void updateBookbyId(@PathVariable UUID id, @RequestBody Book book){
        if(!bookService.isExist(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not Found");
        }
        bookService.updateBook(id, book);
    }


}
