package com.example.bcsd.Service;

import com.example.bcsd.Model.Member;
import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.Repository.BoardRepository;
import com.example.bcsd.Repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @PersistenceContext
    private EntityManager em;

    private final JdbcTemplate jdbcTemplate;
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public LoginService(JdbcTemplate jdbcTemplate, ArticleRepository articleRepository, MemberRepository memberRepository, BoardRepository boardRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
    }


    public Member login(String email, String password) {
        Member member = memberRepository.findByEmail(email);

        if (member == null) {
            return null;
        }

        if (member.getPassword().equals(password)) {
            System.out.println("d");
            return member;
        }

        return null;
    }
}
