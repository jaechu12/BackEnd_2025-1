package com.example.bcsd;


public class BoardDTO {
    private Long ID;
    private String board;
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
