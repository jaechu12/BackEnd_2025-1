package com.example.bcsd;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ArticleDTO {
    private Long id;
    private Long author;
    private Long board;
    private String title;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime revisedDate;

    public ArticleDTO() {
    }

    public ArticleDTO(String title, Long author, LocalDateTime date, String content) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public ArticleDTO(long id, Long author_id, Long board_id, String title, String content, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.author = author_id;
        this.board = board_id;
        this.title = title;
        this.content = content;
        this.date = created_date;
        this.revisedDate = modified_date;
    }


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


}
