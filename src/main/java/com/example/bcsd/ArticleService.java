package com.example.bcsd;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;

@Service
public class ArticleService {
    private final JdbcTemplate jdbcTemplate;

    public ArticleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArticleDTO articlesId(@PathVariable() Long id) {
        ArticleDTO articles = jdbcTemplate.queryForObject(
                "select id, author_id, board_id, title, content, created_date, modified_date from article where id = ?",
                new Object[]{id},
                (resultSet, rowNum) -> new ArticleDTO(
                        resultSet.getLong("id"),
                        resultSet.getLong("author_id"),
                        resultSet.getLong("board_id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp("created_date").toLocalDateTime(),
                        resultSet.getTimestamp("modified_date").toLocalDateTime())
        );

        return articles;
    }

    @Transactional
    public ArticleDTO postArticle(@RequestBody ArticleDTO articleDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "insert into article (board_id, author_id, title, content, created_date, modified_date) values (?, ?, ?, ?, now(), now())";

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, articleDTO.getBoard());
            preparedStatement.setLong(2, articleDTO.getAuthor());
            preparedStatement.setString(3, articleDTO.getTitle());
            preparedStatement.setString(4, articleDTO.getContent());
            return preparedStatement;
        }, keyHolder);

        Number key = keyHolder.getKey();
        articleDTO.setId(key.longValue());

        articleDTO.setDate(LocalDateTime.now());
        articleDTO.setRevisedDate(LocalDateTime.now());


        return articleDTO;
    }

    @Transactional
    public ArticleDTO putArticle(@PathVariable Long id, @RequestBody ArticleDTO updatedArticle) {

        String sql = "UPDATE article SET board_id = ?, title = ?, content = ?, modified_date = now() WHERE id = ?";

        jdbcTemplate.update(sql,
                updatedArticle.getBoard(),
                updatedArticle.getTitle(),
                updatedArticle.getContent(),
                id);

        String Sql = "SELECT id, author_id, board_id, title, content, created_date, modified_date FROM article WHERE id = ?";
        ArticleDTO articles = jdbcTemplate.queryForObject(Sql, (resultSet, rowNum) -> {
            ArticleDTO article = new ArticleDTO();
            article.setId(resultSet.getLong("id"));
            article.setAuthor(resultSet.getLong("author_id"));
            article.setBoard(resultSet.getLong("board_id"));
            article.setTitle(resultSet.getString("title"));
            article.setContent(resultSet.getString("content"));
            article.setDate(resultSet.getTimestamp("created_date").toLocalDateTime());
            article.setRevisedDate(resultSet.getTimestamp("modified_date").toLocalDateTime());
            return article;
        }, id);

        return articles;
    }

    public MemberDTO putMember(@PathVariable Long id, @RequestBody MemberDTO updatedMember) {

        String sql = "UPDATE member SET name = ?, email = ?, password = ? WHERE id = ?";

        jdbcTemplate.update(sql,
                updatedMember.getName(),
                updatedMember.getEmail(),
                updatedMember.getPassword(),
                id);

        String Sql = "SELECT id, name, email, password FROM member WHERE id = ?";
        MemberDTO members = jdbcTemplate.queryForObject(Sql, (resultSet, rowNum) -> {
            MemberDTO member= new MemberDTO();
            member.setID(resultSet.getLong("id"));
            member.setName(resultSet.getString("name"));
            member.setEmail(resultSet.getString("email"));
            member.setPassword(resultSet.getString("password"));
            return member;
        }, id);

        return members;
    }

    @Transactional
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        jdbcTemplate.update("delete from article where id = ?", Long.valueOf(id));
        return null;
    }

    @Transactional
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        jdbcTemplate.update("delete from member where id = ?", Long.valueOf(id));
        return null;
    }

    @Transactional
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        jdbcTemplate.update("delete from board where id = ?", Long.valueOf(id));
        return null;
    }

}
