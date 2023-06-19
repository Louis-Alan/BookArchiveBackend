package com.Springboot.MiniLib.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {

    private final UUID id;
    private final String title;
    private final String author;
    private final int pages;
    private final String status;

    public Book(@JsonProperty("id") UUID id, @JsonProperty("title") String title,
                @JsonProperty("author") String author, @JsonProperty("pages") int pages,
                @JsonProperty("status") String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.status = status;
    }
    public UUID getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public String getStatus() {
        return status;
    }

}
