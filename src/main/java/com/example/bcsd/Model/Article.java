package com.example.bcsd.Model;

import com.example.bcsd.DTO.ArticleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "article")
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_id")
    private Long author;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String title;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;



    public Article(Long id, Long author, Long board, String title, String content, LocalDateTime date, LocalDateTime modifiedDate) {
    }

    public Article(String title, Long author, LocalDateTime date, String content) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public Article(long id, Long author_id, Board board_id, String title, String content, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.author = author_id;
        this.board = board_id;
        this.title = title;
        this.content = content;
        this.date = created_date;
        this.modifiedDate = modified_date;
    }

    public Article() {
    }

    public Article(long id, long authorId, long boardId, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = authorId;
        this.board = new Board();
        this.board.setId(boardId);
        this.content = content;
        this.date = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public void setBoard(Board board) {
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

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    public Long getId() {
        return id;
    }

    public Long getAuthor() {
        return author;
    }

    public Board getBoard() {
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

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public static Article from(ArticleDTO dto) {
        if (dto == null) return null;

        return new Article(
                dto.id(),
                dto.author(),
                dto.board(),
                dto.title(),
                dto.content(),
                dto.date(),
                dto.modifiedDate()
        );
    }

}
