package com.example.bcsd.Repository;

import com.example.bcsd.Model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public Member save(Member member) {
        if (member.getID() == null) {
            em.persist(member);
            return member;
        } else {
            return em.merge(member);
        }
    }
}
