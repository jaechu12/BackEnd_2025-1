package com.example.bcsd.DTO;


import com.example.bcsd.Model.Board;

import java.util.Objects;


public record BoardDTO(
        Long id,
        String board
) {
    public BoardDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(board);
    }

    public static BoardDTO from(Board board) {
        if (board == null) return null;

        return new BoardDTO(
                board.getId(),
                board.getBoard()
        );
    }
}
