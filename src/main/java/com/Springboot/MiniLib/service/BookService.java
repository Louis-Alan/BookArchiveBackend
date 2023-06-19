package com.Springboot.MiniLib.service;

import com.Springboot.MiniLib.dao.BookDao;
import com.Springboot.MiniLib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    public BookService(@Qualifier("postgres") BookDao bookDao) {
        this.bookDao = bookDao;
    }
    private final BookDao bookDao;

    public List<Book> getAllBooks(){
        return bookDao.selectAllBooks();
    }

    public void addBook(Book book){
        bookDao.insertBook(book);
    }

    public void deleteBookbyId(UUID id) {
        bookDao.deleteBookbyId(id);
    }

    public boolean isExist(UUID id) {
        return bookDao.isExist(id);
    }

    public void updateBook(UUID id, Book book) {
        bookDao.updateBook(id, book);
    }
}
