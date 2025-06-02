package com.example.bcsd.Service;

import com.example.bcsd.DTO.ArticleDTO;
import com.example.bcsd.DTO.HelloDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class HelloService {
    private final JdbcTemplate jdbcTemplate;

    public HelloService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String introduceName(HelloDTO request, Model model) {
        if (request.getName() == null) {
            return "hello.html";
        }
        model.addAttribute("name", request.getName());
        return "hello2.html";
    }

    public HelloDTO posts(Long boardId) {
        String boardName = jdbcTemplate.queryForObject(
                "select name from board where id = ?",
                (rs, rowNum) -> rs.getString("name"),
                boardId
        );

        List<String> articleTitles = jdbcTemplate.query(
                "select title from article where board_id = ?",
                (rs, rowNum) -> rs.getString("title"),
                boardId
        );

        return new HelloDTO(boardName, articleTitles);
    }


    public List<ArticleDTO> getboardId(Long boardId) {
        return jdbcTemplate.query(
                "select id, author_id, board_id, title, content, created_date, modified_date from article where board_id = ?",
                new Object[]{boardId},
                (rs, rowNum) -> new ArticleDTO(
                        rs.getLong("id"),
                        rs.getLong("author_id"),
                        rs.getLong("board_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("created_date").toLocalDateTime(),
                        rs.getTimestamp("modified_date").toLocalDateTime()
                )
        );
    }


}


