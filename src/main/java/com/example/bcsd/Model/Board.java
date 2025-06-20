package com.example.bcsd.Model;
import com.example.bcsd.DTO.BoardDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String board;


    public Board(Long id, String board) {
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public Board() {
    }


    public Long getID() {
        return ID;
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
