package com.example.bcsd.DTO;


import com.example.bcsd.Model.Board;



public class BoardDTO {

    private Long ID;
    private String board;
    private String boardID;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setBoardID(String boardID) {
        this.boardID = boardID;
    }


    public Long getID() {
        return ID;
    }

    public String getBoard() {
        return board;
    }

    public String getBoardID() {
        return boardID;
    }


    public static BoardDTO from(Board board) {
        BoardDTO dto = new BoardDTO();
        dto.setID(board.getID());
        dto.setBoard(board.getBoard());
        return dto;
    }
}
