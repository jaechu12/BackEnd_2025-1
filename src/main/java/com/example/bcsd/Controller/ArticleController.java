package com.example.bcsd.Controller;

import com.example.bcsd.DTO.ArticleDTO;
import com.example.bcsd.DTO.MemberDTO;
import com.example.bcsd.Model.Article;
import com.example.bcsd.Model.Member;
import com.example.bcsd.Service.ArticleService;
import com.example.bcsd.Service.LoginService;
import com.example.bcsd.SessionConst;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final LoginService loginService;

    public ArticleController(ArticleService articleService, LoginService loginService) {
        this.articleService = articleService;
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginForm(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute(SessionConst.LOGIN_MEMBER) != null) {
            model.addAttribute("alreadyLogin", true);
            return "loginForm";
        }

        return "login!";
    }
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        Article article = articleService.getArticle(id);
        return ResponseEntity.ok(article);
    }

    @PostMapping("/login")
    public String login(@Valid Member member, BindingResult bindingResult, HttpServletRequest request) throws ServletException {

        Member loginMember = loginService.login(member.getEmail(), member.getPassword());
        if (loginMember == null) {
            return "이메일 또는 비밀번호를 확인해주세요";
        }

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return "로그인되었습니다";
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
