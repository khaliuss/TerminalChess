package org.example;

import org.example.board.Board;
import org.example.board.BoardConsoleRender;
import org.example.pieces.Piece;

public class Game {

    private final Board board;
    private final BoardConsoleRender renderer = new BoardConsoleRender();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            if (!isWhiteToMove) {
                isWhiteToMove = !isWhiteToMove;
                continue;
            }

            renderer.render(board);

            Coordinates coordinatesPieceToMove = InputCoordinates.inputPieceCoordinates(
                    isWhiteToMove ? Color.WHITE : Color.BLACK,
                    board
            );

            Piece piece = board.getPiece(coordinatesPieceToMove);
            Coordinates coordinatesMoveTo = InputCoordinates.inputMoveCoordinates(piece.getAvailableMoveSquare(board));

            board.setPieces(coordinatesMoveTo, piece);
            board.removePiece(coordinatesPieceToMove);


            isWhiteToMove = !isWhiteToMove;
        }
    }

}
