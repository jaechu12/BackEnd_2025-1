package com.example.bcsd.Model;
import com.example.bcsd.DTO.BoardDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String board;

    @OneToMany(mappedBy = "board", orphanRemoval = true, cascade = ALL)
    @JsonIgnore
    private List<Article> articles = new ArrayList<>();

    public Board(Long id) {
        this.id = id;
    }

    public Board(Long id, String board) {
        this.id = id;
        this.board = board;
    }

    public void setId(Long ID) {
        this.id = ID;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public Board() {
    }


    public Long getId() {
        return id;
    }

    public String getBoard() {
        return board;
    }


    public static Board from(BoardDTO dto) {
        if (dto == null) return null;

        return new Board(
                dto.id(),
                dto.board()
        );
    }
}
