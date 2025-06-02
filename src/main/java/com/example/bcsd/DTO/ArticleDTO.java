package com.example.bcsd.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Table(name = "article")
@EntityListeners(AuditingEntityListener.class)
public class ArticleDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_id")
    private Long author;

    @Column(name = "board_id")
    private Long board;

    private String title;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "modified_date")
    @LastModifiedDate
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

    public static ArticleDTO from(ArticleDTO article) {
        if (article == null) {
            return null;
        }

        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getID());
        dto.setAuthor(article.getAuthor()); // author → member 참조
        dto.setBoard(article.getBoard());   // board → board 참조
        dto.setTitle(article.getTitle());
        dto.setContent(article.getContent());
        dto.setDate(article.getDate());
        dto.setRevisedDate(article.getRevisedDate());

        return dto;
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
