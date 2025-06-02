package com.example.bcsd.Service;

import com.example.bcsd.DTO.ArticleDTO;
import com.example.bcsd.DTO.MemberDTO;
import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.Repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class ArticleService {

    @PersistenceContext
    private EntityManager em;

    private final JdbcTemplate jdbcTemplate;
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public ArticleService(JdbcTemplate jdbcTemplate, ArticleRepository articleRepository, MemberRepository memberRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
    }

    public Optional<ArticleDTO> getArticle(Long id) {
        Optional<ArticleDTO> articles = articleRepository.findById(id);

        return articles;
    }


    @Transactional
    public ArticleDTO postArticle(ArticleDTO article) {

        return articleRepository.save(article);
    }


    @Transactional
    public ArticleDTO putArticle(@PathVariable Long id, @RequestBody ArticleDTO article) {
        ArticleDTO existing = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없음" + id));

        existing.setTitle(article.getTitle());
        existing.setContent(article.getContent());

        ArticleDTO updated = articleRepository.save(existing);

        return updated;
    }


    public MemberDTO putMember(@PathVariable Long id, @RequestBody MemberDTO member) {


        member.setName(member.getName());
        member.setEmail(member.getEmail());

        MemberDTO updated = memberRepository.save(member);

        return updated;
    }

    @Transactional
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        Optional<ArticleDTO> article = articleRepository.deleteArticleById(id);
        return null;
    }

    @Transactional
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        Optional<ArticleDTO> article = articleRepository.deleteMemberById(id);
        return null;
    }

    @Transactional
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        Optional<ArticleDTO> article = articleRepository.deleteBoardById(id);
        return null;
    }

}

