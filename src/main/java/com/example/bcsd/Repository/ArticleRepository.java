package com.example.bcsd.Repository;

import com.example.bcsd.DTO.ArticleDTO;
import com.example.bcsd.Model.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class ArticleRepository {

    private final JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    public ArticleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Article> findById(Long id) {
        Article article = em.find(Article.class, id);
        return Optional.ofNullable(article);
    }


    public Optional<ArticleDTO> deleteArticleById(Long id) {
        ArticleDTO article = em.find(ArticleDTO.class, id);
        if (article != null) {
            em.remove(article);
        }
        return null;
    }

    public Optional<ArticleDTO> deleteMemberById(Long id) {
        ArticleDTO article = em.find(ArticleDTO.class, id);
        if (article != null) {
            em.remove(article);
        }
        return null;
    }



    @Transactional
    public Article save(Article article) {
        if (article.getId() == null) {
            em.persist(article);
            return article;
        } else {
            return em.merge(article);
        }
    }

    @Transactional
    public ArticleDTO update(Long id, ArticleDTO article) {
        return em.merge(article);
    }
}
