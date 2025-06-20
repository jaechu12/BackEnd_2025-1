package com.example.bcsd.Service;

import com.example.bcsd.DTO.ArticleDTO;
import com.example.bcsd.DTO.MemberDTO;
import com.example.bcsd.Model.Article;
import com.example.bcsd.Model.Board;
import com.example.bcsd.Model.Member;
import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.Repository.BoardRepository;
import com.example.bcsd.Repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ArticleService {

    @PersistenceContext
    private EntityManager em;

    private final JdbcTemplate jdbcTemplate;
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public ArticleService(JdbcTemplate jdbcTemplate, ArticleRepository articleRepository, MemberRepository memberRepository, BoardRepository boardRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
    }

    public Optional<Article> getArticle(Long id) {
        Optional<Article> articles = articleRepository.findById(id);

        return articles;
    }


    @Transactional
    public Article postArticle(Article article) {
        return articleRepository.save(article);
    }


    @Transactional
    public ArticleDTO putArticle(Long id, ArticleDTO dto) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없음" + id));

        article.setTitle(dto.title());
        article.setContent(dto.content());

        Article updated = articleRepository.save(article);

        return ArticleDTO.from(updated);
    }

    @Transactional
    public MemberDTO putMember(Long id, MemberDTO dto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없음" + id));

        member.setName(dto.name());
        member.setEmail(dto.email());

        Member updated = memberRepository.save(member);

        return MemberDTO.from(updated);
    }

    @Transactional
    public ResponseEntity<String> deleteArticle(Long id) {
        Optional<ArticleDTO> article = articleRepository.deleteArticleById(id);
        return null;
    }

    @Transactional
    public ResponseEntity<String> deleteMember(Long id) {
        Optional<ArticleDTO> article = articleRepository.deleteMemberById(id);
        return null;
    }

    @Transactional
    public ResponseEntity<String> deleteBoard(Long id) {
        Optional<Board> board = boardRepository.deleteBoardById(id);
        return null;
    }

}

