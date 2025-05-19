package com.example.bcsd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ArticleController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> getArticle(@PathVariable Long id) {
        ArticleDTO article = articleService.articlesId(id);
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleDTO> postArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDTO article = articleService.postArticle(articleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> putArticle(@PathVariable Long id, @RequestBody ArticleDTO updatedArticleDTO) {
        ArticleDTO article = articleService.putArticle(id, updatedArticleDTO);
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        ResponseEntity<String> article = articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

}
