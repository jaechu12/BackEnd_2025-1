package com.example.bcsd;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private String author;
    private String board;
    private String title;
    private String content;
    private LocalDateTime date;
    private LocalDateTime revisedDate;

    public Article(String title, String author, LocalDateTime date, String content) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setRevisedDate(LocalDateTime revisedDate) {
        this.revisedDate = revisedDate;
    }


    public Long getID() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBoard() {
        return board;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime getRevisedDate() {
        return revisedDate;
    }


}
