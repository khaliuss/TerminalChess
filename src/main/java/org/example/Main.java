package org.example;


import org.example.board.Board;
import org.example.board.BoardConsoleRender;
import org.example.pieces.CoordinatesShift;
import org.example.pieces.Knight;
import org.example.pieces.Piece;

import java.util.Set;

public class Main {
    static void main() {
        Board board = new Board();
        board.setupDefaultPiecesPosition();
        Game game = new Game(board);


        game.gameLoop();


    }
}
