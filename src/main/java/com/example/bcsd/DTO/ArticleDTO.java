package com.example.bcsd.DTO;

import com.example.bcsd.Model.Article;
import com.example.bcsd.Model.Board;

import java.time.LocalDateTime;
import java.util.Objects;

public record ArticleDTO(
        Long id,
        Long author,
        Long board,
        String title,
        String content,
        LocalDateTime date,
        LocalDateTime modifiedDate
) {

    public static ArticleDTO from(Article article) {
        if (article == null) return null;

        return new ArticleDTO(
                article.getId(),
                article.getAuthor(),
                article.getBoard() != null ? article.getBoard().getId() : null,
                article.getTitle(),
                article.getContent(),
                article.getDate(),
                article.getModifiedDate()
        );
    }
}
