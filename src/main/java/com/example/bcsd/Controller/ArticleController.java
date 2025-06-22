package com.example.bcsd.Controller;

import com.example.bcsd.DTO.ArticleDTO;
import com.example.bcsd.DTO.MemberDTO;
import com.example.bcsd.Model.Article;
import com.example.bcsd.Service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        Optional<Article> article = articleService.getArticle(id);
        return ResponseEntity.ok(article.get());
    }


    @PostMapping("/articles")
    public ResponseEntity<Article> postArticle(@RequestBody Article articleDTO) {
        Article article = articleService.postArticle(articleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> putArticle(@PathVariable Long id, @RequestBody ArticleDTO updatedArticleDTO) {
        Optional<Article> article = articleService.putArticle(id, updatedArticleDTO);
        return ResponseEntity.ok(article.get());
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<MemberDTO> putMember(@PathVariable Long id, @RequestBody MemberDTO updatedMemberDTO) {
        MemberDTO article = articleService.putMember(id, updatedMemberDTO);
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        ResponseEntity<String> article = articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        ResponseEntity<String> article = articleService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        ResponseEntity<String> article = articleService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

}
