package com.Springboot.MiniLib.dao;

import com.Springboot.MiniLib.model.Book;

import java.util.UUID;
import java.util.List;

public interface BookDao {
    int insertBook(UUID id, Book book);

    default int insertBook(Book book){
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }

    List<Book> selectAllBooks();

    public void deleteBookbyId(UUID id);

    boolean isExist(UUID id);

    void updateBook(UUID id, Book book);
}
