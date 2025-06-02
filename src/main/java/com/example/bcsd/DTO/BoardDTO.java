package com.example.bcsd.DTO;

import jakarta.persistence.*;


@Entity
@Table(name = "member")
public class BoardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String board;

    @Column(name = "board_id")
    private String boardId;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }


    public Long getID() {
        return ID;
    }

    public String getBoard() {
        return board;
    }


}
