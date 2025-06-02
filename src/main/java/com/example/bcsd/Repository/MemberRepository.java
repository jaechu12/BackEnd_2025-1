package com.example.bcsd.Repository;

import com.example.bcsd.DTO.MemberDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MemberDTO save(MemberDTO member) {
        if (member.getID() == null) {
            em.persist(member);
            return member;
        } else {
            return em.merge(member);
        }
    }
}
