package com.example.bcsd;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ArticleController {

    private final Map<Long, Article> articles = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        Article article = articles.get(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/article")
    public ResponseEntity<Article> postArticle(@RequestBody Article article) {
        long id = idGenerator.getAndIncrement();
        article.setId(id);
        articles.put(id, article);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<Article> putArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        Article article = articles.get(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        article.setTitle(updatedArticle.getTitle());
        article.setContent(updatedArticle.getContent());
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        Article article = articles.remove(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
