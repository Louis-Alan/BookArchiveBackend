package com.Springboot.MiniLib.dao;

import com.Springboot.MiniLib.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Repository("FakeBook")
public class FakeBookAccess implements BookDao{
    private static List<Book> DB = new ArrayList<>();

    public int insertBook(UUID id, Book book) {
        DB.add(new Book(id, book.getTitle(), book.getAuthor(), book.getPages(), book.getStatus()));
        return 1;
    }

    @Override
    public List<Book> selectAllBooks() {
        return DB;
    }

    @Override
    public void deleteBookbyId(UUID id) {

    }

    @Override
    public boolean isExist(UUID id) {
        return false;
    }

    @Override
    public void updateBook(UUID id, Book book) {

    }
}
