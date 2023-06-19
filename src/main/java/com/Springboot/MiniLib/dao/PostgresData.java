package com.Springboot.MiniLib.dao;

import com.Springboot.MiniLib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class PostgresData implements BookDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBook(UUID id, Book book) {
        String sql = "INSERT INTO book (id, title, author, pages, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, id, book.getTitle(), book.getAuthor(), book.getPages(), book.getStatus());
    }

    @Override
    public List<Book> selectAllBooks() {
        final String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, (resultSet, i)->{
            UUID idd = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            Integer page = resultSet.getInt("pages");
            String status =resultSet.getString("status");
            return new Book(idd,
                    title,
                    author,
                    page,
                    status);
        });
    }

    @Override
    public void deleteBookbyId(UUID id) {
        final String sql = "DELETE FROM book where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean isExist(UUID id) {
        final String sql = "SELECT COUNT(*) FROM book WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }

    @Override
    public void updateBook(UUID id, Book newBook) {
        final String sql = "UPDATE book SET title = ?, author = ?, pages = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql, newBook.getTitle(), newBook.getAuthor(), newBook.getPages(), newBook.getStatus(), id);
    }


}
