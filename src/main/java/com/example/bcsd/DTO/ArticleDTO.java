package com.example.bcsd.DTO;


import com.example.bcsd.Model.Article;

import java.time.LocalDateTime;


public class ArticleDTO {

    private Long id;
    private Long author;
    private Long board;
    private String title;
    private String content;
    private LocalDateTime date;
    private LocalDateTime revisedDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public void setBoard(Long board) {
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

    public Long getAuthor() {
        return author;
    }

    public Long getBoard() {
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

    public static ArticleDTO from(Article article) {
        if (article == null) return null;

        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getID());
        dto.setAuthor(article.getAuthor());
        dto.setBoard(article.getBoard());
        dto.setTitle(article.getTitle());
        dto.setContent(article.getContent());
        dto.setDate(article.getDate());
        dto.setRevisedDate(article.getRevisedDate());
        return dto;
    }
}
