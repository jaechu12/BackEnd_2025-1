package com.example.bcsd.Repository;

import com.example.bcsd.Model.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BoardRepository {

    private final JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Board> deleteBoardById(Long id) {
        Board article = em.find(Board.class, id);
        if (article != null) {
            em.remove(article);
        }
        return null;
    }
}
